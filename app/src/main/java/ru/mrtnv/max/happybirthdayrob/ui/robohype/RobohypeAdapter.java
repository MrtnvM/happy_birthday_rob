package ru.mrtnv.max.happybirthdayrob.ui.robohype;

import android.app.Fragment;
import android.app.FragmentManager;
import android.support.v13.app.FragmentStatePagerAdapter;

import java.util.ArrayList;

import ru.mrtnv.max.happybirthdayrob.R;

/**
 * Created by maxmr on 5/19/2017.
 */

public class RobohypeAdapter extends FragmentStatePagerAdapter {

    private static ArrayList<RobohypeItem> items;

    RobohypeAdapter(FragmentManager fm) {
        super(fm);

        items = new ArrayList<>();
        items.add(new RobohypeItem("Лена", R.drawable.leeena,  "Я , Шишкова Е.В. , хотела бы поздравить Вас , Бадамшин Р.Р. с Днем рождения от всей так сказать меня ! И пожелать Вам главного на данный момент - защитить диплом и сдать ГОСы (на отлично , естественно) , ну а так же здоровья крепкого , хорошего настроения и достижения всех целей ! Целую , обнимаю !", 0.7f));
        items.add(new RobohypeItem("Настя", R.drawable.nastuha, "Дорогой друуууг, как же хорошо, что ты существуешь. Я очень рада нашей дружбе и надеюсь, что она никогда не закончится) Желаю тебе добиться высоких успехов в жизни, стать влиятельным, богатым и статусным дядькой) Желаю никогда не терять интерес к жизни , много счастливых моментов) Конечно, хорошую семью, когда придет время) Чтобы тебя обходили болезни стороной) Оставайся таким же весёлым и добрым)", 0.6f));
        items.add(new RobohypeItem("Егор", R.drawable.egor, "С днюхой, братан!))) Я уверен, что с таким упорством ты многое достигнешь в жизни!)) Желаю тебе и дальше не сворачивать со своего пути и достигать все новых вершин!))", 0.9f));
        items.add(new RobohypeItem("Макс", R.drawable.max, "Куян, С Днем Рождения! Будь счастлив и всегда двигайся алга!"));
        items.add(new RobohypeItem("Лиза", R.drawable.liza, "Желаю больше удачных экспериментов с покраской бороды в новый цвет"));
        items.add(new RobohypeItem("Женя", R.drawable.zhenya, "Желаю тебе оставаться таким же отзывчивым, веселым и искренним, и чтобы ноги не мерзли!"));
        items.add(new RobohypeItem("Тимур", R.drawable.timur, "С днём рождения, Веселящий Мужик)"));
        items.add(new RobohypeItem("Антон", R.drawable.anton, "С днем рождения, браток! Всех благ и чтобы за@$ись"));
        items.add(new RobohypeItem("Саня", R.drawable.sanya, "Чтоб бабла вагона два, и писюн пол метра, но не полтора"));
        items.add(new RobohypeItem("Кузя", R.drawable.kuzya, "С днем рождения бро, Fantastic four желает бабла , здоровья, и защитить диплом"));
        items.add(new RobohypeItem("Денис", R.drawable.den, "TripleB, Поздравляю тебя с твоим Днём Рождения *Nigga* Всех благ тебе этого мира *SwagLife* Чтобы всё у тебя в жизни складывалось *WestSide* Тёлочки никогда не ломались перед твоим BigTall&Wide little Brother *Mfaka* Задачки щёлкались как орешки *BubleButt bitch*. Happy Birthday real gangsta TripleB *Yo yo yo!*", 0.7f));
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
