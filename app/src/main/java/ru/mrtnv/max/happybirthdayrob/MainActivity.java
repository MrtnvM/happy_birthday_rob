package ru.mrtnv.max.happybirthdayrob;

import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.Toolbar;
import android.widget.VideoView;

import com.github.florent37.viewanimator.ViewAnimator;

import ru.mrtnv.max.happybirthdayrob.ui.AboutKuyanFragment;
import ru.mrtnv.max.happybirthdayrob.ui.RoboGalleryFragment;
import ru.mrtnv.max.happybirthdayrob.ui.robohype.RoboHypeFragment;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

@SuppressWarnings("ConstantConditions")
public class MainActivity extends AppCompatActivity {

    private FrameLayout content;
    private ImageButton musicButton;

    private VideoView hypeVideoView;
    private FrameLayout videoContainer;
    private int[] hypeVideos;

    private static boolean isEminemPlaying;
    private static MediaPlayer player;

    private int robohypeTrasitionCount;

    private AboutKuyanFragment kuyanFragment;
    private RoboGalleryFragment roboGalleryFragment;
    private RoboHypeFragment roboHypeFragment;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.robo_hype:
                    goToRoboHype();
                    return true;
                case R.id.robo_gallery:
                    goToRoboGallery();
                    return true;
                case R.id.about_kuyan:
                    goToAboutKuyan();
                    return true;
            }
            return false;
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        content = (FrameLayout) findViewById(R.id.content);
        musicButton = (ImageButton) findViewById(R.id.musicButton);
        hypeVideoView = (VideoView) findViewById(R.id.hypeVideoView);
        videoContainer = (FrameLayout) findViewById(R.id.videoContainer);

        hypeVideos = new int[]{R.raw.hype_1, R.raw.hype_2, R.raw.hype_3, R.raw.hype_4 };

        kuyanFragment = new AboutKuyanFragment();
        roboGalleryFragment = RoboGalleryFragment.newInstance();
        roboHypeFragment = RoboHypeFragment.newInstance();

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setActionBar(toolbar);

        goToRoboHype();

        musicButton.setVisibility(View.INVISIBLE);
        musicButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onMusicButtonClicked();
            }
        });
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

    private void goToRoboHype() {
        getActionBar().setTitle(R.string.robohype);

        roboHypeFragment = RoboHypeFragment.newInstance();

        getFragmentManager().beginTransaction()
                .replace(R.id.content, roboHypeFragment)
                .commit();

        if (robohypeTrasitionCount != 0) {
            playHypeVideo(hypeVideos[robohypeTrasitionCount % hypeVideos.length]);
        }

        robohypeTrasitionCount++;
    }

    private void goToAboutKuyan() {
        if (player == null) {
            isEminemPlaying = true;
            player = MediaPlayer.create(this, R.raw.eminem_without_me);
            player.start();
        }

        getActionBar().setTitle(R.string.about_kuyan);
        getFragmentManager().beginTransaction()
                .replace(R.id.content, kuyanFragment)
                .commit();

        musicButton.setVisibility(View.VISIBLE);
    }

    private void goToRoboGallery() {
        getActionBar().setTitle(R.string.robogalery);
        getFragmentManager().beginTransaction()
                .replace(R.id.content, roboGalleryFragment)
                .commit();
    }

    public void onMusicButtonClicked() {
        if (player == null)
            return;

        if (isEminemPlaying) {
            player.pause();
            musicButton.setImageDrawable(getDrawable(R.drawable.music));
            isEminemPlaying = false;
        } else {
            player.start();
            musicButton.setImageDrawable(getDrawable(R.drawable.music_off));
            isEminemPlaying = true;
        }
    }

    private void playHypeVideo(int video) {
        try {
            ViewAnimator
                    .animate(hypeVideoView, videoContainer)
                    .alpha(1)
                    .duration(300)

                    .andAnimate(content)
                    .alpha(0)
                    .duration(300)

                    .start();

            if (player != null) {
                player.pause();
            }

            String UrlPath = "android.resource://" + getPackageName() + "/" + video;
            hypeVideoView.setVideoURI(Uri.parse(UrlPath));
            hypeVideoView.start();

            hypeVideoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mediaPlayer) {
                    ViewAnimator
                            .animate(hypeVideoView, videoContainer)
                            .alpha(0)
                            .duration(300)

                            .andAnimate(content)
                            .alpha(1)
                            .duration(300)

                            .start();

                    if (isEminemPlaying && player != null) {
                        player.start();
                    }
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
            hypeVideoView.setAlpha(0);
            content.setAlpha(1);
        }
    }
}
