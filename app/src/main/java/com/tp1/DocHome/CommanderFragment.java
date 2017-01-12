package com.tp1.DocHome;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by martinezeva on 12/01/2017.
 */
public class CommanderFragment extends Fragment implements View.OnClickListener {
    Button boutonfinaliser;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_commander, container, false);
        boutonfinaliser = (Button) view.findViewById(R.id.boutonfinaliser);
        boutonfinaliser.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.boutonfinaliser:
                FinaliserFargment finaliserFargment = new FinaliserFargment();
                FragmentManager manager = getActivity().getSupportFragmentManager();
                manager.beginTransaction().replace(R.id.relativelayout_for_fragment, finaliserFargment, finaliserFargment.getTag()).commit();
                break;
        }
    }
}



