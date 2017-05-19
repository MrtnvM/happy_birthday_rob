package ru.mrtnv.max.happybirthdayrob.ui.robohype;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by maxmr on 5/19/2017.
 */

public class RobohypeItem implements Parcelable {

    private String friendName;
    private int photoId;
    private String content;
    private float textScale;

    public RobohypeItem() {
    }

    public RobohypeItem(String friendName, int photoId, String content) {
        this.friendName = friendName;
        this.photoId = photoId;
        this.content = content;
    }

    public RobohypeItem(String friendName, int photoId, String content, float textSize) {
        this(friendName, photoId, content);
        this.textScale = textSize;
    }

    protected RobohypeItem(Parcel in) {
        friendName = in.readString();
        photoId = in.readInt();
        content = in.readString();
    }

    public static final Creator<RobohypeItem> CREATOR = new Creator<RobohypeItem>() {
        @Override
        public RobohypeItem createFromParcel(Parcel in) {
            return new RobohypeItem(in);
        }

        @Override
        public RobohypeItem[] newArray(int size) {
            return new RobohypeItem[size];
        }
    };

    public String getFriendName() {
        return friendName;
    }

    public void setFriendName(String friendName) {
        this.friendName = friendName;
    }

    public int getPhotoId() {
        return photoId;
    }

    public void setPhotoId(int photoId) {
        this.photoId = photoId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeStringArray(new String[]{
                this.friendName,
                String.valueOf(this.photoId),
                this.content});
    }

    public float getTextScale() {
        return textScale;
    }

    public void setTextScale(float textScale) {
        this.textScale = textScale;
    }
}
