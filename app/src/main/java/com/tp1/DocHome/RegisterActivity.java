package com.tp1.DocHome;

import android.app.DatePickerDialog;
import android.content.Context;
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

import com.tp1.DocHome.Models.Patient;
import com.tp1.DocHome.Server.DoctocServer;

import java.util.Calendar;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RegisterActivity extends AppCompatActivity {

    private static final String API_URL = "http://10.0.2.2:8085";

    Button idbouton;
    RadioButton idradioboutonfemme;
    RadioButton idradioboutonhomme;
    RadioGroup idradiogroup;
    RadioButton idradiobutton;
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
        idradioboutonhomme = (RadioButton) findViewById(R.id.radiobuttonhomme);
        idradioboutonfemme = (RadioButton) findViewById(R.id.radiobuttonfemme);




        iddatedenaissance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog birthdate = new DatePickerDialog(RegisterActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        int month1=month+1;
                        iddatedenaissance.setText(dayOfMonth + "/ " + month1 + "/ " + year);
                    }
                }, year, month, day);
                birthdate.setTitle("Sélectionner votre date de naissance");
                birthdate.show();
            }
        });

    }

    public void OnClickreg(View v) {

        //Yuting It is for connect server and test the password and username
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        DoctocServer doctocServer = retrofit.create(DoctocServer.class);

        idbouton = (Button) findViewById(R.id.idbouton);
            String first_name=idprenom.getText().toString();
            String last_name =idnom.getText().toString();
            String password =idmotdepasse.getText().toString();
            String confirmationmotdepasse =idconfirmationmotdepasse.getText().toString();
            int telephone =Integer.parseInt(idnumerodetelephone.getText().toString());
            String email =idemail.getText().toString();
            String sex ="";
            if (idradioboutonfemme.isSelected())
            {
                sex = "femme";
            }
            else
            {
                if(idradioboutonhomme.isSelected())
                    sex = "homme";
            }

            //if (first_name.equals("") || last_name.equals("")  || password.equals("") || telephone.equals("") || email.equals("") || confirmationmotdepasse.equals("")) {
              //  Toast.makeText(this, "Vous avez oublié de remplir des champs", Toast.LENGTH_SHORT).show();

            //}

            // else if (!password.equals(confirmationmotdepasse)){
               // Toast.makeText(this, "Vos mot de passe sont différents", Toast.LENGTH_SHORT).show();
        //}
          //  else {

        Call<Patient> registerCall = doctocServer.register(password,last_name,first_name,sex,telephone,email);
        final Context context = this;


        //？？？
        SharedPreferences sharedpreferences = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = sharedpreferences.edit();

        editor.putBoolean("connected", true);

        editor.commit();

        startActivity(new Intent(this, TutoActivity.class));

        //}


}}


