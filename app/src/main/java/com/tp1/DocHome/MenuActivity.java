package com.tp1.DocHome;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static java.security.AccessController.getContext;

public class MenuActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    final Context context = this;
    private Button button;
    private EditText result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        GMapsFragment mapFragment = new GMapsFragment();
        FragmentManager manager = getSupportFragmentManager();
        manager.beginTransaction().replace(R.id.relativelayout_for_fragment, mapFragment, mapFragment.getTag()).commit();



    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.menuRight) {
           // TutoSlide0Fragment tutoSlide0Fragment = new TutoSlide0Fragment();
           // FragmentManager manager = getSupportFragmentManager();
           // manager.beginTransaction().replace(R.id.relativelayout_for_fragment, tutoSlide0Fragment, tutoSlide0Fragment.getTag()).commit();
            startActivity(new Intent(this, TutoActivity.class));
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_accueil) {
            GMapsFragment mapFragment = new GMapsFragment();
            FragmentManager manager = getSupportFragmentManager();
            manager.beginTransaction().replace(R.id.relativelayout_for_fragment, mapFragment, mapFragment.getTag()).commit();




        } else if (id == R.id.nav_historique) {
            HistoriqueFragment historiqueFragment = new HistoriqueFragment();
            FragmentManager manager = getSupportFragmentManager();
            manager.beginTransaction().replace(R.id.relativelayout_for_fragment, historiqueFragment, historiqueFragment.getTag()).commit();



        } else if (id == R.id.nav_profil) {
            ProfilFragment profilFragment = new ProfilFragment();
            FragmentManager manager = getSupportFragmentManager();
            manager.beginTransaction().replace(R.id.relativelayout_for_fragment, profilFragment, profilFragment.getTag()).commit();


        } else if (id == R.id.nav_carnet) {

                    // get securitylayout.xml view
                    LayoutInflater li = LayoutInflater.from(context);
                    View promptsView = li.inflate(R.layout.securitylayout, null);

                    AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                            context);

                    // set prompts.xml to alertdialog builder
                    alertDialogBuilder.setView(promptsView);

                    final EditText userInput = (EditText) promptsView
                            .findViewById(R.id.editTextDialogUserInput);

                    // set dialog message
                    alertDialogBuilder
                            .setCancelable(false)
                            .setPositiveButton("OK",
                                    new DialogInterface.OnClickListener() {
                                        public void onClick(DialogInterface dialog,int id) {

                                            CarnetFragment carnetFragment = new CarnetFragment();
                                            FragmentManager manager = getSupportFragmentManager();
                                            manager.beginTransaction().replace(R.id.relativelayout_for_fragment, carnetFragment, carnetFragment.getTag()).commit();

                                        }
                                    });


                    // create alert dialog
                    AlertDialog alertDialog = alertDialogBuilder.create();

                    // show it
                    alertDialog.show();


        } else if (id == R.id.nav_paiement) {
            PaiementFragment paiementFragment = new PaiementFragment();
            FragmentManager manager = getSupportFragmentManager();
            manager.beginTransaction().replace(R.id.relativelayout_for_fragment, paiementFragment, paiementFragment.getTag()).commit();


        } else if (id == R.id.nav_deconnection) {
            startActivity(new Intent(this, FirstActivity.class));
                Toast.makeText(this, " Vous êtes déconnecté !", Toast.LENGTH_SHORT).show();
            }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
