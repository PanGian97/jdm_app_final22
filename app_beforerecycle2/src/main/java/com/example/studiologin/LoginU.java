package com.example.studiologin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.widget.TextView;


public class LoginU extends AppCompatActivity implements View.OnClickListener{
    Button bLogin;
    EditText userLogin;
    EditText passLogin;
    TextView registerLink;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        userLogin = (EditText) findViewById(R.id.userLogin);
        passLogin = (EditText) findViewById(R.id.passLogin);
        bLogin = (Button) findViewById(R.id.loginButton);
        registerLink = (TextView)findViewById(R.id.registerLink);

        bLogin.setOnClickListener(this);
        registerLink.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
                case R.id.loginButton:
                    Intent intent = new Intent(this,InterfaceU.class);
                  String  message_userLogin = userLogin.getText().toString();
                    intent.putExtra("username","Welcome  "+message_userLogin+"  select your car brand");
                    startActivity(intent);
                    break;

            case R.id.registerLink: startActivity(new Intent(this, RegisterU.class));break;

        }
    }
}

