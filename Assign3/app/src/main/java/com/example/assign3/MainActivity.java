package com.example.assign3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private DBhelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText Name1 = findViewById(R.id.editTextTextPersonName);
        EditText pass1 = findViewById(R.id.editTextTextPassword);
        EditText repass = findViewById(R.id.editTextTextPassword2);
        Button button = findViewById(R.id.button);
        db=new DBhelper(this);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = Name1.getText().toString();
                String password = pass1.getText().toString();
                String repassword = repass.getText().toString();
                if(password.equals(repassword)){
                    boolean checkuser=db.checkusername(username);
                    if (checkuser==false){
                        Boolean insert =db.inserdata(username,password);
                        if(insert==true){
                            Toast.makeText(MainActivity.this,"user registered succesfully",Toast.LENGTH_LONG).show();
                        }else{
                            Toast.makeText(MainActivity.this," registration unsuccesful",Toast.LENGTH_LONG).show();
                        }
                    }else{
                        Toast.makeText(MainActivity.this,"user already exist",Toast.LENGTH_LONG).show();
                    }
                }else{
                    Toast.makeText(MainActivity.this,"password not mathing",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
