package com.example.assignment_no5;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button reg= findViewById(R.id.button);
        TextView t=findViewById(R.id.textView);
        registerForContextMenu(t);
        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                example_diallog diag= new example_diallog();
                diag.show(getSupportFragmentManager(),"example_diallog");
            }
        });
    }
    @Override
    public void onCreateContextMenu(ContextMenu menu,View v,ContextMenu.ContextMenuInfo menuInfo)
    {
        super.onCreateContextMenu(menu,v,menuInfo);
        MenuInflater menuInflater=getMenuInflater();
        menuInflater.inflate(R.menu.context_menu,menu);
    }
    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item)
    {
        switch (item.getItemId())
        {
            case R.id.it1:
                Toast.makeText(this,"Item1 selected",Toast.LENGTH_LONG).show();
                return true;
            case R.id.it2:
                Toast.makeText(this,"Item2 selected",Toast.LENGTH_LONG).show();
                return true;
            default:
                return super.onContextItemSelected(item);
        }
    }
    public  boolean onCreateOptionMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.option_menu, menu);
        return true;
    }
    public boolean onOptionsItemSelected(@NonNull MenuItem item)
    {
        switch (item.getItemId())
        {
            case R.id.item1:
                Toast.makeText(this,"Item! selected",Toast.LENGTH_LONG).show();
                return true;
            case R.id.item2:
                Toast.makeText(this,"Item2 selected",Toast.LENGTH_LONG).show();
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    public  void Showpopup(View view )
    {
        PopupMenu popupMenu=new PopupMenu(this,view);
        popupMenu.inflate(R.menu.popup_menu);
        popupMenu.show();
       popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
           @Override
           public boolean onMenuItemClick(MenuItem menuItem) {
               switch (menuItem.getItemId())
               {
                   case R.id.itt1:
                       Toast.makeText(MainActivity.this,"Item! selected",Toast.LENGTH_LONG).show();
                       return true;


               }
               return false;
           }
       });
    }

}