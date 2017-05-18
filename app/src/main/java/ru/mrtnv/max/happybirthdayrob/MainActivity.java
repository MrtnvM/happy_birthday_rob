package ru.mrtnv.max.happybirthdayrob;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toolbar;

import ru.mrtnv.max.happybirthdayrob.ui.AboutKuyanFragment;
import ru.mrtnv.max.happybirthdayrob.ui.KuyanFragment;
import ru.mrtnv.max.happybirthdayrob.ui.RoboGalleryFragment;
import ru.mrtnv.max.happybirthdayrob.ui.RoboHypeFragment;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

@SuppressWarnings("ConstantConditions")
public class MainActivity extends AppCompatActivity {

    private TextView mTextMessage;
    private FrameLayout content;

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

    private void goToAboutKuyan() {
        getActionBar().setTitle(R.string.about_kuyan);
        getFragmentManager().beginTransaction()
                .replace(R.id.content, kuyanFragment)
                .commit();
    }

    private void goToRoboGallery() {
        getActionBar().setTitle(R.string.robogalery);
        getFragmentManager().beginTransaction()
                .replace(R.id.content, roboGalleryFragment)
                .commit();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        content = (FrameLayout)findViewById(R.id.content);

        kuyanFragment = new AboutKuyanFragment();
        roboGalleryFragment = RoboGalleryFragment.newInstance();
        roboHypeFragment = RoboHypeFragment.newInstance();

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setActionBar(toolbar);

        goToRoboHype();
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

    private void goToRoboHype() {
        getActionBar().setTitle(R.string.robohype);
        getFragmentManager().beginTransaction()
                .replace(R.id.content, roboHypeFragment)
                .commit();
    }
}
