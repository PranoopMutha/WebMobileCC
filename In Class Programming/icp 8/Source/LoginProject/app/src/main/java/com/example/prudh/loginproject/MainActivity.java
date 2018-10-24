package com.example.prudh.loginproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    public EditText Username,Password;
    public TextView msg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void login(View view)
    {
        Username = (EditText) findViewById(R.id.username);
        Password = (EditText) findViewById(R.id.PasswordTxt);
        msg = (TextView) findViewById(R.id.auth);

        if(Username.getText().toString().equals("admin") && Password.getText().toString().equals("admin")){
            Intent intent = new Intent(MainActivity.this, LoginScreen.class);
            startActivity(intent);
        }
        else
        {
            msg.setVisibility(View.VISIBLE);
            msg.setText("Wrong UserName or password");
        }
    }
}
