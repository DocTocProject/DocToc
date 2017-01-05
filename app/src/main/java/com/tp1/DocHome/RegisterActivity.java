package com.tp1.DocHome;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.Calendar;

public class RegisterActivity extends AppCompatActivity {
    Button bRegister;
    EditText etName;
    EditText etAge;
    EditText etBirthDate;
    EditText etUsername;
    EditText etPassword;
    EditText etPasswordcheck;
    RadioGroup radiogroup;
    RadioButton radioButton;
    Button button;
    EditText etphone;
    EditText etmailid;
    EditText etPass;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        final Calendar c = Calendar.getInstance();
        final int year = c.get(Calendar.YEAR);
        final int month = c.get(Calendar.MONTH);
        final int day = c.get(Calendar.DAY_OF_MONTH);

        etName = (EditText) findViewById(R.id.etName);
        etAge = (EditText) findViewById(R.id.etNom);

        etBirthDate = (EditText) findViewById(R.id.etBirthDate);
        etphone = (EditText) findViewById(R.id.etphone);
        etmailid = (EditText) findViewById(R.id.etmailid);
        etUsername = (EditText) findViewById(R.id.etUsername);
        etPassword = (EditText) findViewById(R.id.etPassword);
        etPass = (EditText) findViewById(R.id.etPasswordcheck);



        etBirthDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog birthdate = new DatePickerDialog(RegisterActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        etBirthDate.setText(year + "/ " + month + "/ " + dayOfMonth);
                    }
                }, year, month, day);
                birthdate.setTitle("Select BirthDate");
                birthdate.show();
            }
        });


        radiogroup = (RadioGroup) findViewById(R.id.radiogroup);
        //radiogroup.setOnClickListener(this);

    }



    public void OnClickLreg(View v) {
        bRegister = (Button) findViewById(R.id.bRegister);
            /*String etNamestr =etName.getText().toString();
            String etAgestr =etAge.getText().toString();
            String etUsernamestr =etUsername.getText().toString();
            String etPasswordstr =etPassword.getText().toString();
            String etpasswordcheck =etPasswordcheck.getText().toString();
            String etphonestr =etphone.getText().toString();
            String etmailidstr =etmailid.getText().toString();




            if (etNamestr.equals("") || etAgestr.equals("") || etUsernamestr.equals("") || etPasswordstr.equals("") || etphonestr.equals("") || etmailidstr.equals("") || etpasswordcheck.equals("")) {
                Toast.makeText(this, "Vous avez oublié de remplir des champs", Toast.LENGTH_SHORT).show();
            }

            /*if (etpasswordcheck.equals(etPasswordstr)){
                Toast.makeText(this,"Le mot de passe n'est pas comfirmé", Toast.LENGTH_SHORT);
            }

            else {*/

        startActivity(new Intent(this, TutoActivity.class));
    }
}


