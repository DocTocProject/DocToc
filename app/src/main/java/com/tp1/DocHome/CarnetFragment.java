package com.tp1.DocHome;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


public class CarnetFragment extends Fragment implements AdapterView.OnItemSelectedListener {

    Spinner spinner;
    Object value;
    Button register;
    private ArrayList<String> descriptionsAllergies;
    private ArrayList<String> descriptionsOperations;
    private ArrayList<String> descriptionsMaladies;
    private ArrayAdapter<String> adaptador1;
    private ArrayAdapter<String> adaptador2;
    private ArrayAdapter<String> adaptador3;
    private ListView lv1;
    private EditText et1;
    public CarnetFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView =inflater.inflate(R.layout.carnetsante_fragment, container, false);
        register = (Button) rootView.findViewById(R.id.benregistrer);
        spinner = (Spinner) rootView.findViewById(R.id.spinner1);
        et1 = (EditText) rootView.findViewById(R.id.editText);
        lv1 = (ListView) rootView.findViewById(R.id.listView);

        descriptionsAllergies = new ArrayList<String>();
        descriptionsAllergies.add("Mounir");
        descriptionsAllergies.add("Boutaina");
        descriptionsAllergies.add("Eva");

        descriptionsMaladies = new ArrayList<String>();
        descriptionsMaladies.add("Maladie1");
        descriptionsMaladies.add("Maladie2");
        descriptionsMaladies.add("Maladie3");

        descriptionsOperations = new ArrayList<String>();
        descriptionsOperations.add("Operation1");
        descriptionsOperations.add("Operation2");
        descriptionsOperations.add("Operation3");
        adaptador1 = new ArrayAdapter<String>(getContext(), android.R.layout.simple_list_item_1, descriptionsAllergies);
        adaptador2 = new ArrayAdapter<String>(getContext(), android.R.layout.simple_list_item_1, descriptionsMaladies);
        adaptador3 = new ArrayAdapter<String>(getContext(), android.R.layout.simple_list_item_1, descriptionsOperations);
        lv1.setAdapter(adaptador1);
        lv1.setAdapter(adaptador2);
        lv1.setAdapter(adaptador3);


        ArrayAdapter adapter = ArrayAdapter.createFromResource(getContext(),R.array.type1,R.layout.support_simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        // spinner.setOnItemSelectedListener(this);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {
                TextView myText = (TextView) view;
                Toast.makeText(getContext(), "Choisir" + myText.getText(), Toast.LENGTH_SHORT).show();

                value = parent.getItemAtPosition(position);
                switch (position) {
                    case 0:
                        lv1.setAdapter(adaptador1);
                        lv1.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
                            @Override
                            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                                final int posicion = i;

                                AlertDialog.Builder dialogo1 = new AlertDialog.Builder(getContext());
                                dialogo1.setTitle("Important");
                                dialogo1.setMessage("Voulez vous éliminer cet element ?");
                                dialogo1.setCancelable(false);
                                dialogo1.setPositiveButton("Confirmer", new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialogo1, int id) {
                                        descriptionsAllergies.remove(posicion);
                                        adaptador1.notifyDataSetChanged();
                                    }
                                });
                                dialogo1.setNegativeButton("Terminer", new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialogo1, int id) {
                                    }
                                });
                                dialogo1.show();

                                return false;
                            }
                        });
                        register.setOnClickListener(new View.OnClickListener() {

                            @Override
                            public void onClick(View v) {

                                descriptionsAllergies.add(et1.getText().toString());
                                adaptador1.notifyDataSetChanged();
                                et1.setText("");
                            }
                        });

                        break;

                    case 1:
                        lv1.setAdapter(adaptador2);

                        lv1.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
                            @Override
                            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                                final int posicion = i;

                                AlertDialog.Builder dialogo1 = new AlertDialog.Builder(getContext());
                                dialogo1.setTitle("Important");
                                dialogo1.setMessage("Voulez vous éliminer cet element ?");
                                dialogo1.setCancelable(false);
                                dialogo1.setPositiveButton("Confirmer", new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialogo1, int id) {
                                        descriptionsMaladies.remove(posicion);
                                        adaptador2.notifyDataSetChanged();
                                    }
                                });
                                dialogo1.setNegativeButton("Terminer", new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialogo1, int id) {
                                    }
                                });
                                dialogo1.show();

                                return false;
                            }
                        });
                        register.setOnClickListener(new View.OnClickListener() {

                            @Override
                            public void onClick(View v) {

                                descriptionsMaladies.add(et1.getText().toString());
                                adaptador2.notifyDataSetChanged();
                                et1.setText("");
                            }
                        });
                        break;

                    case 2:
                        lv1.setAdapter(adaptador3);
                        lv1.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
                            @Override
                            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                                final int posicion = i;

                                AlertDialog.Builder dialogo1 = new AlertDialog.Builder(getContext());
                                dialogo1.setTitle("Important");
                                dialogo1.setMessage("Voulez vous éliminer cet element ?");
                                dialogo1.setCancelable(false);
                                dialogo1.setPositiveButton("Confirmer", new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialogo1, int id) {
                                        descriptionsOperations.remove(posicion);
                                        adaptador3.notifyDataSetChanged();
                                    }
                                });
                                dialogo1.setNegativeButton("Terminer", new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialogo1, int id) {
                                    }
                                });
                                dialogo1.show();

                                return false;
                            }
                        });
                        register.setOnClickListener(new View.OnClickListener() {

                            @Override
                            public void onClick(View v) {

                                descriptionsOperations.add(et1.getText().toString());
                                adaptador3.notifyDataSetChanged();
                                et1.setText("");
                            }
                        });

                        break;
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        return rootView;
    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        TextView myText=(TextView) view;
        Toast.makeText(getContext(),"Choissir"+myText.getText(),Toast.LENGTH_SHORT).show();

        value = parent.getItemAtPosition(position);
        switch (position) {
            case 0:
                lv1.setAdapter(adaptador1);
                break;

            case 1:
                lv1.setAdapter(adaptador2);
                break;

            case 2:
                lv1.setAdapter(adaptador3);
                break;
        }



    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

}