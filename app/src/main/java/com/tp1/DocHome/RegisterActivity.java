package com.tp1.DocHome;

import android.content.Intent;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.content.SharedPreferences;
import android.widget.Toast;


public class RegisterActivity extends AppCompatActivity {
    EditText idpseudo, idnom, idmotdepasse, idage;

    public static final String prenom = "nameKey";
    public static final String ageuser = "ageKey";
    public static final String pseudo = "pseudoKey";
    public static final String mdp = "mdpKey";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        idpseudo = (EditText) findViewById(R.id.idpseudo);
        idnom = (EditText) findViewById(R.id.idnom);
        idage = (EditText) findViewById(R.id.idage);
        idmotdepasse = (EditText) findViewById(R.id.idmotdepasse);

    }


    public void OnClickRegister(View v) {

        String name = idnom.getText().toString();
        String age = idage.getText().toString();
        String username = idpseudo.getText().toString();
        String password = idmotdepasse.getText().toString();

        if (name.equals("") || age.equals("") || username.equals("") || password.equals("")) {
            Toast.makeText(RegisterActivity.this, "Vous avez oublié de remplir des champs", Toast.LENGTH_SHORT).show();
        } else {
            SharedPreferences sharedpreferences = PreferenceManager.getDefaultSharedPreferences(this);
            SharedPreferences.Editor editor = sharedpreferences.edit();
            editor.putString(prenom, name);
            editor.putString(ageuser, age);
            editor.putString(pseudo, username);
            editor.putString(mdp, password);
            editor.putBoolean("connected", true);
            editor.commit();
            startActivity(new Intent(this, TutoActivity.class));
        }
    }
}