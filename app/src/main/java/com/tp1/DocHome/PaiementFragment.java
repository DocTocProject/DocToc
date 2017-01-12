package com.tp1.DocHome;


import android.app.DatePickerDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;


/**
 * A simple {@link Fragment} subclass.
 */
public class PaiementFragment extends Fragment implements AdapterView.OnItemSelectedListener{

    EditText iddateexpiration;


    public PaiementFragment() {
        // Required empty public constructor
    }

    Spinner spinner;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView =inflater.inflate(R.layout.fragment_paiement, container, false);

        spinner = (Spinner) rootView.findViewById(R.id.spinner);
        ArrayAdapter adapter = ArrayAdapter.createFromResource(getContext(),R.array.type,R.layout.support_simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
            // start
        final Calendar c = Calendar.getInstance();
        final int year = c.get(Calendar.YEAR);
        final int month = c.get(Calendar.MONTH);
        final int day = c.get(Calendar.DAY_OF_MONTH);

        iddateexpiration = (EditText) rootView.findViewById(R.id.iddateexpiration);

        iddateexpiration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog birthdate = new DatePickerDialog(getContext(), new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        iddateexpiration.setText(year + "/ " + month + "/ " + dayOfMonth);
                    }
                }, year, month, day);
                birthdate.setTitle("Sélectionner votre date d'expiration");
                birthdate.show();
            }
        });

        //end
    return rootView ;



    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        TextView myText=(TextView) view;
        Toast.makeText(getContext(),"Choissir"+myText.getText(),Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }





}
