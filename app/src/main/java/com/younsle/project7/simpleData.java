package com.younsle.project7;

import android.os.Parcel;
import android.os.Parcelable;

public class simpleData implements Parcelable {

    String identification;

    public simpleData(String id) {
        identification = id;
    }

    public simpleData(Parcel src) {
        identification = src.readString();
    }

    public static final Creator<simpleData> CREATOR = new Creator<simpleData>() {
        @Override
        public simpleData createFromParcel(Parcel source) {
            return new simpleData(source);
        }

        @Override
        public simpleData[] newArray(int size) {
            return new simpleData[size];
        }
    };
    @Override
    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(identification);
    }
}

