package com.tp1.DocHome;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
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
    Button idbouton;
    RadioButton idradioboutonfemme;
    RadioButton idradioboutonhomme;
    RadioGroup idradiogroup;
    EditText idprenom;
    EditText idnom;
    EditText iddatedenaissance;
    EditText idnumerodetelephone;
    EditText idmotdepasse;
    EditText idconfirmationmotdepasse;
    EditText idemail;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        final Calendar c = Calendar.getInstance();
        final int year = c.get(Calendar.YEAR);
        final int month = c.get(Calendar.MONTH);
        final int day = c.get(Calendar.DAY_OF_MONTH);

        idprenom = (EditText) findViewById(R.id.idprenom);
        idnom = (EditText) findViewById(R.id.idnom);
        iddatedenaissance = (EditText) findViewById(R.id.iddatedenaissance);
        idnumerodetelephone = (EditText) findViewById(R.id.idnumerodetelephone);
        idemail = (EditText) findViewById(R.id.idemail);
        idmotdepasse = (EditText) findViewById(R.id.idmotdepasse);
        idconfirmationmotdepasse = (EditText) findViewById(R.id.idconfirmationmotdepasse);
        idradiogroup = (RadioGroup) findViewById(R.id.idradiogroup);



        iddatedenaissance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog birthdate = new DatePickerDialog(RegisterActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        iddatedenaissance.setText(year + "/ " + month + "/ " + dayOfMonth);
                    }
                }, year, month, day);
                birthdate.setTitle("Sélectionner votre date de naissance");
                birthdate.show();
            }
        });

    }



    public void OnClickreg(View v) {
        idbouton = (Button) findViewById(R.id.idbouton);
            String prenom  =idprenom.getText().toString();
            String nom =idnom.getText().toString();
            String motdepasse =idmotdepasse.getText().toString();
            String confirmationmotdepasse =idconfirmationmotdepasse.getText().toString();
            String telephone =idnumerodetelephone.getText().toString();
            String email =idemail.getText().toString();


            if (prenom.equals("") || nom.equals("")  || motdepasse.equals("") || telephone.equals("") || email.equals("") || motdepasse.equals("") || confirmationmotdepasse.equals("")) {
                Toast.makeText(this, "Vous avez oublié de remplir des champs", Toast.LENGTH_SHORT).show();

            }

            else if (!motdepasse.equals(confirmationmotdepasse)){
                Toast.makeText(this, "Vos mot de passe sont différents", Toast.LENGTH_SHORT).show();
        }
            else {
                    SharedPreferences sharedpreferences = PreferenceManager.getDefaultSharedPreferences(this);
                    SharedPreferences.Editor editor = sharedpreferences.edit();
                    editor.putBoolean("connected", true);
                    startActivity(new Intent(this, TutoActivity.class));
                }



}}


