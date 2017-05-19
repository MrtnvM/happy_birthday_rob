package ru.mrtnv.max.happybirthdayrob.ui.robohype;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import ru.mrtnv.max.happybirthdayrob.R;

public class RoboHypeFragment extends Fragment {

    ViewPager pager;
    RobohypeAdapter adapter;

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
        View view = inflater.inflate(R.layout.fragment_robo_hype, container, false);

        pager = (ViewPager)view.findViewById(R.id.pager);
        adapter = new RobohypeAdapter(getChildFragmentManager());
        pager.setAdapter(adapter);
        pager.setPageTransformer(true, new ParallaxPageTransformer());

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();

    }
}
