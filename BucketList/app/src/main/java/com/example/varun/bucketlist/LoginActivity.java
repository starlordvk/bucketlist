package com.example.varun.bucketlist;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    SharedPreferences sharedPref;
    public static final String mypreferences="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        TextView caption=(TextView)findViewById(R.id.caption);
        Typeface custom_font = Typeface.createFromAsset(getAssets(),"fonts/billabong.ttf");

        caption.setTypeface(custom_font);

        final EditText input_username=(EditText)findViewById(R.id.input_username);
        Button btn_login=(Button)findViewById(R.id.btn_login);

        //saving the login details using shared preferences

        sharedPref=getSharedPreferences("login_details", Context.MODE_PRIVATE);
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String username=input_username.getText().toString();
              SharedPreferences.Editor editor=sharedPref.edit();
                editor.putString("username", username);
                editor.apply();
                editor.commit();
                Toast.makeText(LoginActivity.this,"Login credentials saved",Toast.LENGTH_LONG).show();


            }
        });




    }

}
