package ru.mrtnv.max.happybirthdayrob.ui.robogramm;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ru.mrtnv.max.happybirthdayrob.R;

public class RoboGalleryFragment extends Fragment {

    RecyclerView rvGallery;

    public RoboGalleryFragment() {
    }

    public static RoboGalleryFragment newInstance() {
        RoboGalleryFragment fragment = new RoboGalleryFragment();
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
        View view = inflater.inflate(R.layout.fragment_robo_gallery, container, false);
        rvGallery = (RecyclerView)view.findViewById(R.id.rvGallery);
        rvGallery.setHasFixedSize(true);
        rvGallery.setLayoutManager(new LinearLayoutManager(getActivity()));
        rvGallery.setAdapter(new RobogrammAdapter(getActivity()));
        return view;
    }

}
