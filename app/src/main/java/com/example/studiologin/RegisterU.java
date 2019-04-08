package com.example.studiologin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;

public class RegisterU extends AppCompatActivity implements View.OnClickListener{

    Button bReg;
    EditText userReg;
    EditText passReg;
    EditText emailReg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        userReg = (EditText) findViewById(R.id.userReg);
        passReg = (EditText) findViewById(R.id.passReg);
        emailReg = (EditText) findViewById(R.id.emailReg);
        bReg = (Button) findViewById(R.id.registerButton);

        bReg.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.registerButton:

                startActivity(new Intent(this, LoginU.class));
             break;

        }
    }
}
