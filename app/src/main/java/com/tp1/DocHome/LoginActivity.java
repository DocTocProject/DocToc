package com.tp1.DocHome;

import android.content.Intent;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.EditText;
import android.widget.Toast;

import com.tp1.DocHome.Models.Patient;
import com.tp1.DocHome.Server.DoctocServer;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class LoginActivity extends AppCompatActivity {

    private static final String API_URL = "http://10.0.2.2:8085";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    //Yuting It is for connect server and test the password and username
    public void OnClickLog (View v) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        DoctocServer doctocServer = retrofit.create(DoctocServer.class);

        EditText emailView = (EditText) findViewById(R.id.etusername);
        EditText passwordView = (EditText) findViewById(R.id.etpassword);
        final String email = emailView.getText().toString();
        String password = passwordView.getText().toString();

        String etusernamestr = emailView.getText().toString();
        if (etusernamestr.matches("")) {
            Toast.makeText(this, "You did not enter a username", Toast.LENGTH_SHORT).show();
            return;
        }

        String etpasswordstr = passwordView.getText().toString();
        if (etpasswordstr.matches("")) {
            Toast.makeText(this, "You did not enter a password", Toast.LENGTH_SHORT).show();
            return;
        }

        Call<Patient> loginCall = doctocServer.login(email, password);

        final Context context = this;

        loginCall.enqueue(new Callback<Patient>() {
            @Override
            public void onResponse(Call<Patient> call, Response<Patient> response) {
                if (response.code() != 200) {
                    TextView errorView = (TextView) findViewById(R.id.eterrormessage);
                    errorView.setText("Wrong credentials !");

                } else {
                    startActivity(new Intent(context, MenuActivity.class));
                    SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);

                    prefs.edit().putBoolean("connected", true).commit();
                    Patient patient = response.body();
                    prefs.edit().putString("email", patient.getEmail().toString()).commit();
                    prefs.edit().putString("first_name", patient.getFirstName().toString()).commit();
                    prefs.edit().putString("last_name", patient.getLastName().toString()).commit();
                    prefs.edit().putString("sex", patient.getSex().toString()).commit();
                    prefs.edit().putString("telephone",String.valueOf(patient.getTelephone())).commit();
                    prefs.edit().putLong("id",patient.getId()).commit();

                    finish();
                   // Toast.makeText(context,"You are logged in!", Toast.LENGTH_SHORT);
                }
            }

            @Override
            public void onFailure(Call<Patient> call, Throwable t) {
                TextView errorView = (TextView) findViewById(R.id.eterrormessage);
                errorView.setText("Connexion Failed !");
            }
        });

    }
}