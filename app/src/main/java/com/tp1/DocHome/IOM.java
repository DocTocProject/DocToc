package com.tp1.DocHome;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class IOM extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iom);
    }

    public void OnClickMed(View v) {
        startActivity(new Intent(this, HomeActivity.class));
    }

    public void OnClickInf(View v) {
        startActivity(new Intent(this, HomeActivity.class));
    }
}



