package com.tp1.DocHome;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class TutoSlide3Fragment extends Fragment implements View.OnClickListener {
    Button bStart;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View myView = inflater.inflate(R.layout.tutoslide3, container, false);
        bStart = (Button) myView.findViewById(R.id.bStart);
        bStart.setOnClickListener(this);
        return myView;
    }


    @Override
    public void onClick(View v) {
        startActivity(new Intent(getContext(), IOM.class));

    }
}




