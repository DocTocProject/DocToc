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


public class ApplicationsFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View v = inflater.inflate(R.layout.applications_fragment, container, false);

        String[] consultation = new String[]{
               "Selectionner votre consultation", "1er Consultation", "2ème Consultation", "3ème Consultation", "4ème Consultation", "5ème Consultation"
        };


        Spinner s = (Spinner) v.findViewById(R.id.spin);
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_spinner_item, consultation);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s.setAdapter(dataAdapter);
        s.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                TextView textinfo = (TextView) v.findViewById(R.id.information);
                TextView texttemp = (TextView) v.findViewById(R.id.temperature);
                TextView texttens = (TextView) v.findViewById(R.id.tension);
                TextView textavis = (TextView) v.findViewById(R.id.avis);
                switch (position){
                    case 0:
                        textinfo.setText("Consultation du 23 janvier 2016 avec le Docteur Yang");
                        texttemp.setText("Votre température était de 38°C");
                        texttens.setText("Votre tension était de 11.6");
                        textavis.setText("Remarque : le patient doit prendre 3 dolipranes/jour pendant 3 jours");
                        break;
                    case 1:
                        textinfo.setText("Consultation du 4 avril 2016 avec le Docteur Hunt");
                        texttemp.setText("Votre température était de 38.6°C");
                        texttens.setText("Votre tension était de 18.9");
                        textavis.setText("Remarque : le patient doit prendre 3 dolipranes/jour pendant 3 jours");
                        break;
                    case 2:
                        textinfo.setText("Consultation du 14 mai 2016 avec le Docteur Shepherd");
                        texttemp.setText("Votre température était de 36.5°C");
                        texttens.setText("Votre tension était de 13.3");
                        textavis.setText("Remarque : le patient doit prendre 3 dolipranes/jour pendant 3 jours");
                        break;
                    case 3:
                        textinfo.setText("Consultation du 22 Décembre 2016 avec le Docteur Grey");
                        texttemp.setText("Votre température était de 37.2°C");
                        texttens.setText("Votre tension était de 15.6");
                        textavis.setText("Remarque : le patient doit prendre 3 dolipranes/jour pendant 3 jours");
                        break;
                    case 4:
                        textinfo.setText("Consultation du 25 Décembre 2016 avec le Docteur House");
                        texttemp.setText("Votre température était de 39.7°C");
                        texttens.setText("Votre tension était de 12.3");
                        textavis.setText("Remarque : le patient doit prendre 3 dolipranes/jour pendant 3 jours");
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        return v;
    }
}