package ru.mrtnv.max.happybirthdayrob.ui;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ru.mrtnv.max.happybirthdayrob.R;

public class RoboHypeFragment extends Fragment {


    public RoboHypeFragment() {
    }

   public static RoboHypeFragment newInstance() {
        RoboHypeFragment fragment = new RoboHypeFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_robo_hype, container, false);
    }
}
