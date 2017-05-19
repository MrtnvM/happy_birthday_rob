package ru.mrtnv.max.happybirthdayrob.ui;

import android.animation.ValueAnimator;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.github.florent37.viewanimator.ViewAnimator;

import ru.mrtnv.max.happybirthdayrob.R;

/**
 * Created by maxmr on 5/19/2017.
 */

public class AboutKuyanFragment extends Fragment {

    public static final String TAG = "AboutKuyanFragment";

    ImageView rob;
    ImageView glasses;
    TextView bigRussianRob;

    public AboutKuyanFragment() {

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_kuyan, container, false);

        rob = (ImageView) view.findViewById(R.id.rob);
        glasses = (ImageView) view.findViewById(R.id.glasses);
        bigRussianRob = (TextView) view.findViewById(R.id.big_russian_rob);

        ImageView c = (ImageView)view.findViewById(R.id.container);
        Glide.with(getActivity()).load(R.drawable.graffiti_city_2).into(c);

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();

        //noinspection ConstantConditions
        getView().getViewTreeObserver()
                .addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
                    @Override
                    public void onGlobalLayout() {
                        ViewAnimator
                                .animate(rob)
                                .alpha(1)
                                .startDelay(200)
                                .duration(2000)

                                .thenAnimate(rob)
                                .waitForHeight()
                                .rotation(-15)
                                .accelerate()
                                .duration(500)

                                .thenAnimate(glasses)
                                .waitForHeight()
                                .alpha(0, 1)
                                .translationY(0, rob.getHeight() * 0.404f)
                                .translationX(rob.getWidth() * 0.02f, rob.getWidth() * 0.02f)
                                .duration(1000)

                                .thenAnimate(bigRussianRob)
                                .alpha(1)
                                .rotation(-15, -15)
                                .duration(300)

                                .andAnimate(rob, glasses)
                                .pulse()
                                .repeatCount(7)
                                .duration(600)
                                .repeatMode(ValueAnimator.RESTART)

                                .thenAnimate(bigRussianRob)
                                .pulse()
                                .repeatCount(1000)
                                .duration(700)
                                .rotation(-0.25f)
                                .repeatMode(ValueAnimator.REVERSE)

                                .start();
                    }
                });

    }
}
