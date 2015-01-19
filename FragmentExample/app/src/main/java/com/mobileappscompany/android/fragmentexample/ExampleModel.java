package com.mobileappscompany.android.fragmentexample;

import java.util.Date;
import java.util.UUID;

/**
 * Created by Android1 on 1/18/2015.
 */
public class ExampleModel {
    private UUID mId;
    private String mTitle;
    private Date mDate;

    ExampleModel() {
        mId = UUID.randomUUID();
        mDate = new Date();
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public Date getDate() {
        return mDate;
    }

    public void setDate(Date mDate) {
        this.mDate = mDate;
    }

    public UUID getId() {
        return mId;
    }

}
