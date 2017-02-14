package com.example.sujic.proyectofinal_susana;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by sujic on 10/02/2017.
 */
public class MyDialogFragment extends DialogFragment {

    public static MyDialogFragment newInstance(String valor) {

        MyDialogFragment fragment = new MyDialogFragment();

        return fragment;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        LayoutInflater inflater = (LayoutInflater) getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        ViewGroup dialogView = (ViewGroup) inflater.inflate(R.layout.dialog_fragment, null);

        TextView name = (TextView) dialogView.findViewById(R.id.infoUser);
        TextView password = (TextView)  dialogView.findViewById(R.id.infoPass);

        SharedPreferences prefs = getActivity().getSharedPreferences("Preferencias", Context.MODE_PRIVATE);
        String nombre = prefs.getString("nombre","name");
        String pw = prefs.getString("pwd", "password");

        Log.i("Preferences", "Nombre: " + nombre);
        Log.i("Preferences", "Pass: " + pw);

        name.setText(nombre);
        password.setText(pw);

        Button home = (Button) dialogView.findViewById(R.id.bhome);

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
                //View layout = getDialog().getWindow().findViewById(R.id.dialog_fragment);
                //layout.setVisibility(View.INVISIBLE);
            }
        });

        // asignar el dialog a la vista
        return new AlertDialog.Builder(getActivity()).setView(dialogView).create();

    }

}
