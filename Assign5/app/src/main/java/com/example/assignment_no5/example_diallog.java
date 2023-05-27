package com.example.assignment_no5;


import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;
import android.view.LayoutInflater;
import android.view.View;


import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDialogFragment;

public class example_diallog extends AppCompatDialogFragment {
    EditText name,Pass;
    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState)
    {
    AlertDialog.Builder builder=new  AlertDialog.Builder(getActivity());
    LayoutInflater layoutInflate=getActivity().getLayoutInflater();
    View view= layoutInflate.inflate(R.layout.dialogbox,null);
    name =view.findViewById(R.id.editTextTextPersonName);
    Pass=view.findViewById(R.id.editTextTextPersonName2);
    builder.setView(view)
            .setTitle("registration")
            .setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {

                }

            })
            .setPositiveButton("register", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {

                }
            });
    return builder.create();
    }
}
