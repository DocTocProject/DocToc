package com.tp1.DocHome;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class CarnetFragment extends Fragment {

    EditText profil_allergie, profil_operation, profil_traitement;
    public static final String MYPREFERENCES = "keyallergie";
    public static final String ALLERGIE = "keyallergie";
    public static final String TRAITEMENT = "keytrai";
    public static final String OPERATION = "keyope";
    SharedPreferences sharedPreferences;

    String stringallergie;
    String stringtraitement;
    String stringoperation;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        sharedPreferences = this.getActivity().getSharedPreferences(MYPREFERENCES, Context.MODE_PRIVATE);
        stringallergie = sharedPreferences.getString(ALLERGIE, "");
        stringoperation = sharedPreferences.getString(OPERATION, "");
        stringtraitement = sharedPreferences.getString(TRAITEMENT, "");

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.profil_fragment, container, false);
        profil_allergie = (EditText) view.findViewById(R.id.profil_allergie);
        profil_operation = (EditText) view.findViewById(R.id.profil_operation);
        profil_traitement = (EditText) view.findViewById(R.id.profil_traitement);


        profil_allergie.setText(stringallergie);
        profil_operation.setText(stringoperation);
        profil_traitement.setText(stringtraitement);

        Button buttonenregistrer = (Button) view.findViewById(R.id.benregistrer);
        buttonenregistrer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stringallergie = profil_allergie.getText().toString();
                stringtraitement = profil_traitement.getText().toString();
                stringoperation = profil_operation.getText().toString();

                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString(ALLERGIE, stringallergie);
                editor.putString(TRAITEMENT, stringtraitement);
                editor.putString(OPERATION, stringoperation);
                editor.commit();
                Toast.makeText(getContext(), "Les informations ont bien été enregistrées", Toast.LENGTH_LONG).show();
            }
        });
        return view;
    }


}