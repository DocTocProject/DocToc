package com.tp1.DocHome;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;


public class RegisterActivity extends AppCompatActivity {
    public static final String prenom = "nameKey";
    public static final String ageuser = "ageKey";
    public static final String pseudo = "pseudoKey";
    public static final String mdp = "mdpKey";
    EditText idpseudo, idnom, idmotdepasse, idage;
    Calendar birthdate = Calendar.getInstance();
    DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
            year = year;
            monthOfYear = dayOfMonth;
            dayOfMonth = dayOfMonth;
        }
    };
    Toast edittext;

    private void updateLabel() {
        String format = "DD/MM/YY";
        SimpleDateFormat x = new SimpleDateFormat(format, Locale.FRANCE);
        final Button button;
        edittext.setText(x.format(Calendar.getInstance()));
    }

    public void onDateSet(DatePicker view, int day, int month, int year) {
        birthdate.set(Calendar.DAY_OF_MONTH, day);
        birthdate.set(Calendar.MONTH, month);
        birthdate.set(Calendar.YEAR, year);
        updateLabel();
    }

    private void updatedisplay() {
        edittext.setText(new StringBuilder().append(Calendar.DAY_OF_MONTH).append(Calendar.MONTH).append(Calendar.YEAR));
        //return new DatePickerDialog(getApplication(),this,);

    }

    private Context getLocalClassName(RegisterActivity registerActivity) {
        return null;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        //idpseudo = (EditText) findViewById(R.id.idpseudo);
        idnom = (EditText) findViewById(R.id.idnom);
        //idage = (EditText) findViewById(R.id.idage);
        //idmotdepasse = (EditText) findViewById(R.id.idmotdepasse);

    }


    public void OnClickRegister(View v) {

        String name = idnom.getText().toString();
        /*String age = idage.getText().toString();
        String username = idpseudo.getText().toString();
        String password = idmotdepasse.getText().toString();*/

        startActivity(new Intent(this, MenuActivity.class));

         if (name.equals("")) {
            Toast.makeText(RegisterActivity.this, "Vous avez oublié de remplir des champs", Toast.LENGTH_SHORT).show();
        } else {
            SharedPreferences sharedpreferences = PreferenceManager.getDefaultSharedPreferences(this);
            SharedPreferences.Editor editor = sharedpreferences.edit();
            editor.putString(prenom, name);
            editor.putBoolean("connected", true);
            editor.commit();
            startActivity(new Intent(this, TutoActivity.class));
        }


    }

    /*public DatePickerDialog onCreateDialog(Bundle savedInstanceState) {
        Calendar birthdate = Calendar.getInstance();
        int day = birthdate.get(Calendar.DAY_OF_MONTH);
        int month = birthdate.get(Calendar.MONTH);
        int year = birthdate.get(Calendar.YEAR);
        return new DatePickerDialog(getApplication(), this, day, month, year);
    }

    @Override
    public void onClick(View v) {
        Calendar birthdate = Calendar.getInstance(TimeZone.getDefault());

        new DatePickerDialog(getLocalClassName(this), date, birthdate.get(Calendar.DAY_OF_MONTH),
                birthdate.get(Calendar.MONTH), birthdate.get(Calendar.YEAR)).show();
    }*/
}