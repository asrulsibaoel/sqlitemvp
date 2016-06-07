package com.penguin.padang.pasir.sqlitesharedpreferences.models;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by jowy on 6/3/16.
 */
public class Member implements Parcelable {

    private int id;
    private String name;
    private String team;
    private int thumb;

    public Member(){

    }

    protected Member(Parcel in) {
        this.id = in.readInt();
        this.name = in.readString();
        this.team = in.readString();
        this.thumb = in.readInt();
    }

    public static final Creator<Member> CREATOR = new Creator<Member>() {
        @Override
        public Member createFromParcel(Parcel in) {
            return new Member(in);
        }

        @Override
        public Member[] newArray(int size) {
            return new Member[size];
        }
    };

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public int getThumb() {
        return thumb;
    }

    public void setThumb(int thumb) {
        this.thumb = thumb;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(name);
        dest.writeString(team);
        dest.writeInt(thumb);
    }
}
