package com.mobileappscompany.android.sharedpreferences;

import android.os.Bundle;
import android.preference.PreferenceActivity;

/**
 * Created by Android1 on 1/19/2015.
 */
public class SharedPreferencesActivity extends PreferenceActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.settings);
    }
}
