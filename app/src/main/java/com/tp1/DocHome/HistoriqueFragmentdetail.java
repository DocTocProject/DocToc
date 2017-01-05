package com.tp1.DocHome;
import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
/**
 * Created by martinezeva on 05/01/2017.
 */

public class HistoriqueFragmentdetail extends Activity{


        TextView textView;
        TextView textView2;
        TextView textView3;
        TextView textView4;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.historiquefragmentdetail);

            textView= (TextView)findViewById(R.id.textView);
            textView2= (TextView)findViewById(R.id.textView2);
            textView3= (TextView)findViewById(R.id.textView3);
            textView4= (TextView)findViewById(R.id.textView4);

        }
    }
