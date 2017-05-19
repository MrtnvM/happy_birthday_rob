package ru.mrtnv.max.happybirthdayrob.ui.robohype;

import android.support.v4.view.ViewPager;
import android.view.View;

import ru.mrtnv.max.happybirthdayrob.R;

public class ParallaxPageTransformer implements ViewPager.PageTransformer {

    private static final float MIN_SCALE = 0.75f;

    public void transformPage(View view, float position) {

        int pageWidth = view.getWidth();

        View content = view.findViewById(R.id.tvContent);
        View friendName = view.findViewById(R.id.friendName);
        View avatar = view.findViewById(R.id.friendAvatar);

        if (position < -1) { // [-Infinity,-1)
            // This page is way off-screen to the left.
            view.setAlpha(1);

        } else if (position <= 1) { // [-1,1]

            friendName.setTranslationX(1.f * position * (float)Math.log((pageWidth / 0.9f)));
            friendName.setAlpha(1 - Math.abs(position));

            avatar.setTranslationX(0.9f*position * (pageWidth / 1.2f));

            float scaleFactor = MIN_SCALE
                    + (1 - MIN_SCALE) * (1 - Math.abs(position));
            view.setScaleX(scaleFactor);
            view.setScaleY(scaleFactor);

            content.setTranslationX(0.7f * position * (float)(Math.log(pageWidth / 1.5f)));
            content.setAlpha(1 - Math.abs(position));


        } else { // (1,+Infinity]
            // This page is way off-screen to the right.
            view.setAlpha(1);
        }


    }
}