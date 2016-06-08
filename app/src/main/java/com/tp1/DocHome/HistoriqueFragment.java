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

public class HistoriqueFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View v = inflater.inflate(R.layout.historique_fragment, container, false);

        String[] consultation = new String[]{
                "Sélectionnez votre consultation", "Consultation du 23/02/2015", "Consultation du 09/01/2016", "Consultation du 01/02/2016", "Consultation du 05/04/2016", "Consultation du 22/05/2016"
        };


        Spinner s = (Spinner) v.findViewById(R.id.spin);
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, consultation);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s.setAdapter(dataAdapter);
        s.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                TextView textinfo = (TextView) v.findViewById(R.id.information);
                TextView texttemp = (TextView) v.findViewById(R.id.temperature);
                TextView texttens = (TextView) v.findViewById(R.id.tension);
                TextView textsymp = (TextView) v.findViewById(R.id.symptome);
                TextView textdiag = (TextView) v.findViewById(R.id.diagnostic);
                TextView texttrait = (TextView) v.findViewById(R.id.traitement);
                switch (position) {
                    case 0:
                        textinfo.setText("");
                        texttemp.setText("");
                        texttens.setText("");
                        textsymp.setText("");
                        textdiag.setText("");
                        texttrait.setText("");
                        break;
                    case 1:
                        textinfo.setText("Nom du professionel de santé: Docteur Christina Yang");
                        texttemp.setText("Température : 37.6°C");
                        texttens.setText("Tension : 11.6");
                        textsymp.setText("Symptomes : Douleur intense dans le bras gauche");
                        textdiag.setText("Diagnostic : Tendinite");
                        texttrait.setText("Traitement : Le patient doit prendre 3 dolipranes/jours pendant 3 jours + Voltarène gel 3%");
                        break;
                    case 2:
                        textinfo.setText("Nom du professionel de santé: Docteur Meredith Grey");
                        texttemp.setText("Température : 39.6°C");
                        texttens.setText("Tension : 8.6");
                        textsymp.setText("Symptomes : Douleur abdominale vive + sang dans les urines ");
                        textdiag.setText("Diagnostic : Infetion urinaire");
                        texttrait.setText("Traitement : Le patient doit prendre de la penicilline pendant 3 jours ");
                        break;
                    case 3:
                        textinfo.setText("Nom du professionel de santé: Docteur Derick Shepherd");
                        texttemp.setText("Température : 38.3°C");
                        texttens.setText("Tension : 11.6");
                        textsymp.setText("Symptomes : Maux de têtes + obstruction nasale ");
                        textdiag.setText("Diagnostic : Rhinopharingite");
                        texttrait.setText("Traitement : Le patient doit prendre 3 dolipranes/jours pendant 3 jours + lavage nasale au serum physiologique");
                        break;
                    case 4:
                        textinfo.setText("Nom du professionel de santé: Docteur Gregory House");
                        texttemp.setText("Température : 37.8°C");
                        texttens.setText("Tension : 13.2");
                        textsymp.setText("Symptomes : Nausées + vertiges + sueurs + maux de tête");
                        textdiag.setText("Diagnostic : Hypotension artérielle");
                        texttrait.setText("Traitement : Le patient doit se reposer pendant 1 journée + doliprane/3 jours");
                        break;
                    case 5:
                        textinfo.setText("Nom du professionel de santé: Docteur Christina Yang");
                        texttemp.setText("Température : 39.6°C");
                        texttens.setText("Tension : 11.6");
                        textsymp.setText("Symptomes : Nausées, vomissements, crampes abdominales, déshydratation, fatigue");
                        textdiag.setText("Diagnostic : Intoxication alimentaire");
                        texttrait.setText("Traitement : Réhidratation + antibiotique pendant 4 jours matin et soir");
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