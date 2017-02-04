package com.tp1.DocHome;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.tp1.DocHome.Models.Consultation;
import com.tp1.DocHome.Server.DoctocServer;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class HistoriqueFragmentdetail extends Fragment{

    private static final String API_URL = "http://10.0.2.2:8085";

        TextView textView;
        TextView textView2;
        TextView textView3;
        TextView textView4;
        Context context = this.getContext();

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState)
        {
            View rootView =inflater.inflate(R.layout.historiquefragmentdetail, container, false);

            textView= (TextView)rootView.findViewById(R.id.textView);
            textView2= (TextView)rootView.findViewById(R.id.textView2);
            textView3= (TextView)rootView.findViewById(R.id.textView3);
            textView4= (TextView)rootView.findViewById(R.id.textView4);
            return rootView;

        }
        public void OnClickreg(View v){



        }
    }
