package com.bonumites.fariza;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.method.PasswordTransformationMethod;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.bonumites.fariza.ui.home.HomeFragment;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LoginActivity extends AppCompatActivity {

    EditText emaileditxt1;
    TextView forgetpsswrdtxt;
    Button finaloginbtn;
    TextInputLayout psswrdeditxt1TextInputLayout;
    TextInputEditText psswrdeditxt1;
    ProgressDialog progressDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ActionBar actionBar = getSupportActionBar();
        if(actionBar != null){
            actionBar.setTitle("Login");
        }



        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        emaileditxt1 = (EditText) findViewById(R.id.email_editxt1);
        psswrdeditxt1TextInputLayout = (TextInputLayout) findViewById(R.id.psswrd_editxt1_txtinputLayout);
        psswrdeditxt1 = (TextInputEditText) findViewById(R.id.psswrd_editxt1);

        forgetpsswrdtxt = (TextView) findViewById(R.id.forgetpasswrd_txtview1);
        forgetpsswrdtxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this,ForgetPassword.class);
                startActivity(intent);
            }
        });



        finaloginbtn = (Button) findViewById(R.id.login_nxt_btn);
        finaloginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!ValidateEmail(emaileditxt1.getText().toString())){

                    emaileditxt1.setError("Invalid Email");
                    emaileditxt1.requestFocus();
                }else if (!ValidatePassword(psswrdeditxt1.getText().toString())){
                    psswrdeditxt1.setError("Invalid Password");
                    psswrdeditxt1.requestFocus();
                }else {
                    Intent intent = new Intent(LoginActivity.this, BottomNav.class);
                    startActivity(intent);
                }

                }


        });


    }
    // Return  true if password is valid and false if password is invalid.
    protected boolean ValidatePassword(String password) {
        if (password!=null && password.length()>5){
            return true;
        }else {
            return false;
        }
    }

    // Return true if email is valid and false if email is invalid.
    protected boolean ValidateEmail(String email){
        String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

        Pattern pattern = Pattern.compile(emailPattern);
        Matcher matcher = pattern.matcher(email);

        return matcher.matches();
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == android.R.id.home)
            finish();
        return super.onOptionsItemSelected(item);
    }

}
