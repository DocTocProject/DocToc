package com.tp1.DocHome;
import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
/**
 * Created by martinezeva on 05/01/2017.
 */

public class HistoriqueFragmentdetail extends Fragment{


        TextView textView;
        TextView textView2;
        TextView textView3;
        TextView textView4;

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView =inflater.inflate(R.layout.historiquefragmentdetail, container, false);

            textView= (TextView)rootView.findViewById(R.id.textView);
            textView2= (TextView)rootView.findViewById(R.id.textView2);
            textView3= (TextView)rootView.findViewById(R.id.textView3);
            textView4= (TextView)rootView.findViewById(R.id.textView4);
            return rootView;

        }
    }
