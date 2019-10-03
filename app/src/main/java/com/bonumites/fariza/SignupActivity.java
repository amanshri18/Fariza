package com.bonumites.fariza;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.PasswordTransformationMethod;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;
import android.widget.Toolbar;

import com.bonumites.fariza.ui.home.HomeFragment;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SignupActivity extends AppCompatActivity {

    EditText emaileditxt;
    Button registrbtn;
    TextInputLayout psswrdeditxtTextInputLayout;
    TextInputEditText psswrdeditxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        ActionBar actionBar = getSupportActionBar();
        if(actionBar != null){
            actionBar.setTitle("Signup");
        }

        // ActionBar Back Button
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);


        emaileditxt = (EditText) findViewById(R.id.email_editxt);
        psswrdeditxtTextInputLayout = (TextInputLayout) findViewById(R.id.psswrd_editxt_txtinputLayout);
        psswrdeditxt = (TextInputEditText) findViewById(R.id.psswrd_editxt);

        registrbtn = (Button) findViewById(R.id.signup_nxt_btn);
        registrbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!ValidateEmail(emaileditxt.getText().toString())){

                    emaileditxt.setError("Invalid Email");
                    emaileditxt.requestFocus();
                }else if (!ValidatePassword(psswrdeditxt.getText().toString())){
                    psswrdeditxt.setError("Minimum 6 letters");
                    psswrdeditxt.requestFocus();
                }else {
                    Intent intent = new Intent(SignupActivity.this, BottomNav.class);
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

    // ActionBar Back button.
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == android.R.id.home)
            finish();
        return super.onOptionsItemSelected(item);
    }

}
