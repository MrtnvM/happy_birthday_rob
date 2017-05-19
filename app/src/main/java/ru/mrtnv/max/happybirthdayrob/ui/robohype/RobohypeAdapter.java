package ru.mrtnv.max.happybirthdayrob.ui.robohype;

import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v13.app.FragmentPagerAdapter;
import android.support.v13.app.FragmentStatePagerAdapter;
import android.util.SparseArray;
import android.util.SparseIntArray;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import ru.mrtnv.max.happybirthdayrob.R;

/**
 * Created by maxmr on 5/19/2017.
 */

public class RobohypeAdapter extends FragmentStatePagerAdapter {

    private static ArrayList<RobohypeItem> items;

    RobohypeAdapter(FragmentManager fm) {
        super(fm);

        items = new ArrayList<>();
        items.add(new RobohypeItem("Настя", R.drawable.nastuha, "С ДР, Роб!"));
        items.add(new RobohypeItem("Лена", R.drawable.leeena,  "Я , Шишкова Е.В. , хотела бы поздравить Вас , Бадамшин Р.Р. с Днем рождения от всей так сказать меня ! И пожелать Вам главного на данный момент - защитить диплом и сдать ГОСы (на отлично , естественно) , ну а так же здоровья крепкого , хорошего настроения и достижения всех целей ! Целую , обнимаю !", 0.7f));
        items.add(new RobohypeItem("Егор", R.drawable.egor, "С днюхой, братан!))) Я уверен, что с таким упорством ты многое достигнешь в жизни!)) Желаю тебе и дальше не сворачивать со своего пути и достигать все новых вершин!))", 0.9f));
        items.add(new RobohypeItem("Макс", R.drawable.max, "Куян, С Днем Рождения! Будь счастлив и всегда двигайся алга!"));
    }

    @Override
    public Fragment getItem(int position) {
//        RoboHypeItemFragment fragment = cache[position % cache.length];
//        fragment.setItem(items.get(position));
        return RoboHypeItemFragment.newInstance(items.get(position));
    }

    @Override
    public int getCount() {
        return items.size();
    }


}
