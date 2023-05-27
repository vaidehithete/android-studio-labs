package com.example.assign4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {
    String finalOut = "";

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Spinner spinner = findViewById(R.id.subject_spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this,
                R.array.spinner_items,
                android.R.layout.simple_spinner_item
        );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        Button b = findViewById(R.id.register_button);
    }
    public void show(View view) {
        EditText nameEdit = findViewById(R.id.name_edit_text);
        String name = nameEdit.getText().toString();

        Spinner spinner = findViewById(R.id.subject_spinner);
        String course = spinner.getSelectedItem().toString();

        RadioGroup rg = findViewById(R.id.gender_radio_group);
        String gender;
        int id = rg.getCheckedRadioButtonId();
        if(id==R.id.male_radio_button) {
            gender = "Male";
        }else if(id==R.id.female_radio_button) {
            gender = "Female";
        }else {
            gender = "None";
        }

        CheckBox q1 = findViewById(R.id.qualification_check_box_1);
        CheckBox q2 = findViewById(R.id.qualification_check_box_2);
        CheckBox q3 = findViewById(R.id.qualification_check_box_3);
        String d1, d2, d3;
        if(q1.isChecked()) {
            d1 = "Bachelor's";
        }else{
            d1="";
        }

        if (q2.isChecked()) {
            d2 = "Master's";
        }else{
            d2="";
        }

        if (q3.isChecked()) {
            d3 = "PhD";
        }else{
            d3="";
        }

        finalOut += ("Name: " + name + "\n");
        finalOut += ("Course: " + course + "\n");
        finalOut += ("Gender: " + gender + "\n");
        finalOut += ("Qualification: " + d1 + ", " + d2 + ", " + d3);

        Intent intent = new Intent(MainActivity.this, SecondActivity.class);
        intent.putExtra("data",finalOut);
        startActivity(intent);
    }
}