package com.tp1.DocHome;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
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

public class HistoriqueFragment extends Fragment implements View.OnClickListener {

        Button button;
        Button button2;
        Button button3;
        Button button4;
        Button button5;


        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView =inflater.inflate(R.layout.historique_fragment, container, false);

            button= (Button)rootView.findViewById(R.id.button);
            button.setOnClickListener(this);

            button2= (Button)rootView.findViewById(R.id.button2);
            button2.setOnClickListener(this);

            button3= (Button)rootView.findViewById(R.id.button3);
            button3.setOnClickListener(this);

            button4= (Button)rootView.findViewById(R.id.button4);
            button4.setOnClickListener(this);

            button5= (Button)rootView.findViewById(R.id.button5);
            button5.setOnClickListener(this);
            return rootView;

        }

        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.button:

                    HistoriqueFragmentdetail historiqueFragmentdetail = new HistoriqueFragmentdetail();
                    FragmentManager manager = getActivity().getSupportFragmentManager();
                    manager.beginTransaction().replace(R.id.relativelayout_for_fragment, historiqueFragmentdetail, historiqueFragmentdetail.getTag()).commit();
                    break;



                case R.id.button2:
                    Toast x2= Toast.makeText(getContext(),"Data will appear", Toast.LENGTH_SHORT);
                    x2.show();
                    //popup msg
                    break;

                case R.id.button3:
                    Toast x3= Toast.makeText(getContext(),"Data will appear", Toast.LENGTH_SHORT);
                    x3.show();
                    //popup msg
                    break;

                case R.id.button4:
                    Toast x4= Toast.makeText(getContext(),"Data will appear", Toast.LENGTH_SHORT);
                    x4.show();
                    //popup msg
                    break;

                case R.id.button5:
                    Toast x5= Toast.makeText(getContext(),"Data will appear", Toast.LENGTH_SHORT);
                    x5.show();
                    //popup msg
                    break;

            }
        }
    }