package com.tp1.DocHome;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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



/**
 * A simple {@link Fragment} subclass.
 */
public class ProfilFragment extends Fragment {

    EditText profil_prenom, profil_nom, profil_sexe, profil_telephone, profil_email;
    public static final String MYPREFERENCES = "keysante";
    public static final String NOM = "keynom";
    public static final String PRENOM = "keyprenom";
    public static final String SEXE = "keysexe";
    public static final String TELEPHONE = "keytelephone";
    public static final String EMAIL = "keyemail";

    SharedPreferences sharedPreferences;

    String stringnom;
    String stringprenom;
    String stringsexe;
    String stringtelephone;
    String stringemail;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        sharedPreferences = this.getActivity().getSharedPreferences(MYPREFERENCES, Context.MODE_PRIVATE);
        stringnom = sharedPreferences.getString(NOM, "");
        stringprenom = sharedPreferences.getString(PRENOM, "");
        stringsexe = sharedPreferences.getString(SEXE, "");
        stringtelephone = sharedPreferences.getString(TELEPHONE, "");
        stringemail = sharedPreferences.getString(EMAIL, "");

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profil, container, false);
        profil_prenom = (EditText) view.findViewById(R.id.prenom);
        profil_nom = (EditText) view.findViewById(R.id.nom);
        profil_sexe = (EditText) view.findViewById(R.id.sexe);
        profil_telephone = (EditText) view.findViewById(R.id.numerodetelephone);
        profil_email = (EditText) view.findViewById(R.id.email);



        profil_prenom.setText(stringprenom);
        profil_nom.setText(stringnom);
        profil_telephone.setText(stringtelephone);
        profil_sexe.setText(stringsexe);
        profil_email.setText(stringemail);

        Button buttonenregistrer = (Button) view.findViewById(R.id.benregistrer);
        buttonenregistrer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stringprenom = profil_prenom.getText().toString();
                stringnom = profil_nom.getText().toString();
                stringsexe = profil_sexe.getText().toString();
                stringtelephone =profil_telephone.getText().toString();
                stringemail = profil_email.getText().toString();

                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString(PRENOM, stringprenom);
                editor.putString(NOM, stringnom);
                editor.putString(SEXE, stringsexe);
                editor.putString(TELEPHONE, stringtelephone);
                editor.putString(EMAIL, stringemail);
                editor.commit();
                Toast.makeText(getContext(), "Le profil a été mis à jour", Toast.LENGTH_LONG).show();
            }
        });
        return view;
    }


}
