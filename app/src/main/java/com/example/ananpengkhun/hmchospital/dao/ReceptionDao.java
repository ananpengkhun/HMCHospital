package com.example.ananpengkhun.hmchospital.dao;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Date;

/**
 * Created by ananpengkhun on 6/22/17.
 */

public class ReceptionDao implements Parcelable {

    private int requestId;
    private String requestUser;
    private String requestDes;
    private Date requestDate;



    public int getRequestId() {
        return requestId;
    }

    public void setRequestId(int requestId) {
        this.requestId = requestId;
    }

    public String getRequestUser() {
        return requestUser;
    }

    public void setRequestUser(String requestUser) {
        this.requestUser = requestUser;
    }

    public String getRequestDes() {
        return requestDes;
    }

    public void setRequestDes(String requestDes) {
        this.requestDes = requestDes;
    }

    public Date getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(Date requestDate) {
        this.requestDate = requestDate;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.requestId);
        dest.writeString(this.requestUser);
        dest.writeString(this.requestDes);
        dest.writeLong(this.requestDate != null ? this.requestDate.getTime() : -1);
    }

    public ReceptionDao() {
    }

    protected ReceptionDao(Parcel in) {
        this.requestId = in.readInt();
        this.requestUser = in.readString();
        this.requestDes = in.readString();
        long tmpRequestDate = in.readLong();
        this.requestDate = tmpRequestDate == -1 ? null : new Date(tmpRequestDate);
    }

    public static final Parcelable.Creator<ReceptionDao> CREATOR = new Parcelable.Creator<ReceptionDao>() {
        @Override
        public ReceptionDao createFromParcel(Parcel source) {
            return new ReceptionDao(source);
        }

        @Override
        public ReceptionDao[] newArray(int size) {
            return new ReceptionDao[size];
        }
    };
}
