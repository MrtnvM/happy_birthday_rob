package ru.mrtnv.max.happybirthdayrob.ui.robogramm;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import ru.mrtnv.max.happybirthdayrob.R;

/**
 * Created by maxmr on 5/19/2017.
 */

public class RobogrammAdapter extends RecyclerView.Adapter<RobogrammAdapter.RobophotoViewHolder> {

    private int[] images;
    private Context context;

    public RobogrammAdapter(Context context) {
        this.context = context;

        images = new int[]{
                R.drawable.q1, R.drawable.q2, R.drawable.q3, R.drawable.q4, R.drawable.q5,
                R.drawable.q6, R.drawable.q7, R.drawable.q8, R.drawable.q9, R.drawable.q10,
                R.drawable.q11, R.drawable.q12, R.drawable.q13, R.drawable.q14, R.drawable.q15,
                R.drawable.q16, R.drawable.q17, R.drawable.q18, R.drawable.q20,
                R.drawable.q21, R.drawable.q22, R.drawable.q23, R.drawable.q25, R.drawable.q26,
                R.drawable.q27, R.drawable.q28, R.drawable.q29, R.drawable.q30};
    }

    @Override
    public RobophotoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new RobophotoViewHolder(
                LayoutInflater.from(context).inflate(R.layout.item_gallery, parent, false));
    }

    @Override
    public void onBindViewHolder(RobophotoViewHolder holder, int position) {
        String text = String.valueOf(234 + (int)(Math.random() * 700));
        holder.tvLikesCount.setText(text);

        final TextView likes = holder.tvLikesCount;
        holder.ibLikeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String likesCount = likes.getText().toString();
                likes.setText(String.valueOf(Integer.valueOf(likesCount) + 1));
            }
        });

        Glide.with(context).load(images[position]).into(holder.ivPhoto);
    }

    @Override
    public int getItemCount() {
        return images.length;
    }

    public class RobophotoViewHolder extends RecyclerView.ViewHolder {

        TextView tvLikesCount;
        ImageButton ibLikeButton;
        ImageView ivPhoto;

        public RobophotoViewHolder(View itemView) {
            super(itemView);

            tvLikesCount = (TextView) itemView.findViewById(R.id.likesCount);
            ibLikeButton = (ImageButton) itemView.findViewById(R.id.likeButton);
            ivPhoto = (ImageView) itemView.findViewById(R.id.photo);
        }
    }
}
