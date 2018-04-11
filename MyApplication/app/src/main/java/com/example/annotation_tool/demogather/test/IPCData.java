package com.example.annotation_tool.demogather.test;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by vincent on 2018/2/5.
 */

public class IPCData implements Parcelable {

    public String name;

    public IPCData() {

    }

    public IPCData(Parcel parcel) {
        this.name = parcel.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
    }

    public static Creator<IPCData> CREATOR = new ClassLoaderCreator<IPCData>() {

        @Override
        public IPCData createFromParcel(Parcel source, ClassLoader loader) {
            IPCData data = new IPCData(source);
            return data;
        }

        @Override
        public IPCData createFromParcel(Parcel source) {
            IPCData data = new IPCData(source);
            return data;
        }

        @Override
        public IPCData[] newArray(int size) {
            return new IPCData[size];
        }
    };
}
