package com.example.mati.checkbuttons;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    CheckBox chkBoxCycling;
    CheckBox chkTeaching;
    CheckBox chkBoxBlogging;

    Button btnHobby;
    TextView txtHobby;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       initialUISetup();
    }

   public void initialUISetup()
    {

        chkBoxCycling = (CheckBox) findViewById(R.id.chkBoxCycling);
        chkTeaching = (CheckBox) findViewById(R.id.chkBoxTeaching);
        chkBoxBlogging = (CheckBox) findViewById(R.id.chkBoxBlogging);

        btnHobby = (Button) findViewById(R.id.button);

        txtHobby = (TextView) findViewById(R.id.textView);

       btnHobby.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getHobbyClick(v);
            }
        });

    }

   public void getHobbyClick(View v)
    {
        String strMessage = "";

        if(chkBoxCycling.isChecked())
        {
            strMessage+="Cycling";
        }
        if(chkTeaching.isChecked())
        {
            strMessage+="Teaching";
        }
        if(chkBoxBlogging.isChecked())
        {
            strMessage+="Blogging";
        }
        showTextNotification (strMessage);
    }

    public void showTextNotification (String msgToDisplay)
    {
        txtHobby.setText(msgToDisplay);
    }

}
