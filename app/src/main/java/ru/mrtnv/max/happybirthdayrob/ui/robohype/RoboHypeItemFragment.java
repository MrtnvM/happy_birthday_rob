package ru.mrtnv.max.happybirthdayrob.ui.robohype;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import ru.mrtnv.max.happybirthdayrob.R;

/**
 * Created by maxmr on 5/19/2017.
 */

public class RoboHypeItemFragment extends Fragment {

    TextView friendName;
    ImageView avatar;
    TextView content;

    RobohypeItem item;

    public RoboHypeItemFragment() {
    }

    public static RoboHypeItemFragment newInstance(RobohypeItem item) {

        Bundle args = new Bundle();
//        args.putParcelable("robohype_item", item);
        RoboHypeItemFragment fragment = new RoboHypeItemFragment();
        fragment.setArguments(args);
        fragment.item = item;
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_robohype_item, container, false);
        friendName = (TextView) view.findViewById(R.id.friendName);
        avatar = (ImageView) view.findViewById(R.id.friendAvatar);
        content = (TextView) view.findViewById(R.id.tvContent);

//        if (getArguments() != null) {
//            RobohypeItem item = getArguments().getParcelable("robohype_item");
//            assert item != null;
//            this.item = item;
//        }

        setItem(item);

        return view;
    }

    public void setItem(RobohypeItem item) {
        this.item = item;

        if (item != null && friendName != null) {
            friendName.setText(item.getFriendName());
//            Integer index = RobohypeAdapter.images.get(item.getPhotoId());
//            Drawable drawable = RobohypeAdapter.imagesCache.get(index);
//            avatar.setImageDrawable(getResources().getDrawable(item.getPhotoId(), getActivity().getTheme()));
            Glide.with(getActivity()).load(item.getPhotoId()).into(avatar);
            content.setText(item.getContent());

            if (item.getTextScale() > 0) {
                float scaledDensity = getResources().getDisplayMetrics().scaledDensity;
                float size = content.getTextSize() * item.getTextScale() / scaledDensity;
                content.setTextSize(size);
            }
        }
    }

}
