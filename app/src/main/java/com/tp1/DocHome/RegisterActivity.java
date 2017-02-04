package com.tp1.DocHome;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.tp1.DocHome.Models.Patient;
import com.tp1.DocHome.Server.DoctocServer;

import java.util.Calendar;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RegisterActivity extends AppCompatActivity {

   private static final String API_URL = "http://10.0.2.2:8085";
   // private static final String API_URL = "http://192.168.0.17:8085";

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
        idradioboutonfemme = (RadioButton) findViewById(R.id.radiobuttonfemme);
        idradioboutonhomme = (RadioButton) findViewById(R.id.radiobuttonhomme);

        iddatedenaissance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog birthdate = new DatePickerDialog(RegisterActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        int month1=month+1;
                        iddatedenaissance.setText(dayOfMonth + "" + month1 + "" + year);
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

        final String first_name=idprenom.getText().toString();
        final String last_name =idnom.getText().toString();
        String password =idmotdepasse.getText().toString();
        String confirmationmotdepasse =idconfirmationmotdepasse.getText().toString();
        final String telephone = idnumerodetelephone.getText().toString();
        // int telephone =Integer.parseInt(idnumerodetelephone.getText().toString());
        final String email =idemail.getText().toString();
        String sex ="";
        if (idradioboutonfemme.isChecked())
        {
            sex = "f";
        }
        else
        {
            sex = "h";
        }


        if (first_name.equals("") || last_name.equals("")  || password.equals("") || (telephone == null)   || email.equals("") || confirmationmotdepasse.equals(""))
        {
            Toast.makeText(this, "Vous avez oublié de remplir des champs", Toast.LENGTH_SHORT).show();
        }
        else
        if (!password.equals(confirmationmotdepasse))
        {
            Toast.makeText(this, "Vos mot de passe sont différents", Toast.LENGTH_SHORT).show();
            //"Your password is different"
        }

        else
        {

            final Patient patient = new Patient(
                    null,
                    password,
                    last_name,
                    first_name,
                    sex,
                    Long.parseLong(telephone),
                    email,
                    "noaddress"
            );
            Call<Patient> registerCall = doctocServer.createAPatient(patient);
            final Context context = this;

            final String finalSex = sex;
            registerCall.enqueue(new Callback<Patient>() {
                @Override
                public void onResponse(Call<Patient> call, Response<Patient> response) {
                    if (response.code() != 201) {
                        Log.e("API-ERROR", patient.toString());
                        Log.e("API-ERROR", "Received code : " + response.code());
                        Log.e("API-ERROR", "Received response : " + response.raw().toString());
                        Toast.makeText(context, "Une erreur est intervenue lors de l'enregistrement", Toast.LENGTH_SHORT).show();

                    } else {
                        startActivity(new Intent(context, TutoActivity.class));
                        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
                        prefs.edit().putBoolean("connected", true).commit();
                        prefs.edit().putString("email",email).commit();
                        prefs.edit().putString("last_name",last_name).commit();
                        prefs.edit().putString("first_name",first_name).commit();
                        prefs.edit().putString("sex", finalSex).commit();
                        prefs.edit().putString("telephone",telephone).commit();
                        finish();
                    }
                }
                @Override
                public void onFailure(Call<Patient> call, Throwable t) {
                    Toast.makeText(context, "Une erreur est intervenue lors de l'enregistrement", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }}


