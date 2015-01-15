package com.mobileappscompany.android.listviewexamples;

/**
 * Created by Android1 on 1/13/2015.
 */
public class CountryElement {

    public CountryElement(String countryName) {
        setCountryname(countryName);
    }

    private String mCountryname;

    public String getCountryname() {
        return mCountryname;
    }

    public void setCountryname(String mCountryname) {
        this.mCountryname = mCountryname;
    }
}
