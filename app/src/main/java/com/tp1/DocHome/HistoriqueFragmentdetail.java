package com.tp1.DocHome;
import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class HistoriqueFragmentdetail extends Fragment{


        TextView textView;
        TextView textView2;
        TextView textView4;

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView =inflater.inflate(R.layout.historiquefragmentdetail, container, false);

            textView= (TextView)rootView.findViewById(R.id.textView);
            textView2= (TextView)rootView.findViewById(R.id.textView2);
            textView4= (TextView)rootView.findViewById(R.id.textView4);
            return rootView;

        }
    }
