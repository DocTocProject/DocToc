package com.tp1.DocHome;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class HistoriqueFragment extends AppCompatActivity implements View.OnClickListener {

        Button button;
        Button button2;
        Button button3;
        Button button4;
        Button button5;


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.historique_fragment);

            button= (Button)findViewById(R.id.button);
            button.setOnClickListener(this);

            button2= (Button)findViewById(R.id.button2);
            button2.setOnClickListener(this);

            button3= (Button)findViewById(R.id.button3);
            button3.setOnClickListener(this);

            button4= (Button)findViewById(R.id.button4);
            button4.setOnClickListener(this);

            button5= (Button)findViewById(R.id.button5);
            button5.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.button:
                    Intent a=new Intent(this,HistoriqueFragmentdetail.class);
                    startActivity(a);
                    //startActivity(new Intent(this,History.class));
                    break;



                case R.id.button2:
                    Toast x2= Toast.makeText(this,"Data will appear", Toast.LENGTH_SHORT);
                    x2.show();
                    //popup msg
                    break;

                case R.id.button3:
                    Toast x3= Toast.makeText(this,"Data will appear", Toast.LENGTH_SHORT);
                    x3.show();
                    //popup msg
                    break;

                case R.id.button4:
                    Toast x4= Toast.makeText(this,"Data will appear", Toast.LENGTH_SHORT);
                    x4.show();
                    //popup msg
                    break;

                case R.id.button5:
                    Toast x5= Toast.makeText(this,"Data will appear", Toast.LENGTH_SHORT);
                    x5.show();
                    //popup msg
                    break;

            }
        }
    }