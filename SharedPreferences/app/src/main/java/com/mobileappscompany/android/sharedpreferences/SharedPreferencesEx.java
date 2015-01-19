package com.mobileappscompany.android.sharedpreferences;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class SharedPreferencesEx extends Activity implements View.OnClickListener{

    private SharedPreferences mSettings;

    EditText mEdTxtUser;
    EditText mEdTxtPassword;
    Button mBtnAdd;
    Button mBtnRemove;
    Button mBtnSelect;

    String mUser;
    String mPassword;

    private SharedPreferences.OnSharedPreferenceChangeListener settingsListener;

    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.btnSelect:
                select();
                break;
            case R.id.btnAdd:
                update();
                break;
            case R.id.btnRemove:
                delete();
                break;
        }
    }

    private void delete(){
        mSettings.edit().remove("user").apply();
        mSettings.edit().remove("password").apply();
    }

    private void select(){
        mUser = mSettings.getString("user", "not found");
        mPassword = mSettings.getString("password", "not found");
        mEdTxtUser.setText(mUser);
        mEdTxtPassword.setText(mPassword);
    }

    private void update(){
        //        SharedPreferences.Editor editor;
        //        editor = settings.edit();
        //        editor.putString("user", txtUser.getText().toString());
        //        editor.putString("password", txtPassword.getText().toString());
        //        editor.commit();
        Intent intent = new Intent(this, SharedPreferencesActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_preferences);

        mSettings = PreferenceManager.getDefaultSharedPreferences(this);
        mBtnSelect = (Button) findViewById(R.id.btnSelect);
        mBtnAdd = (Button) findViewById(R.id.btnAdd);
        mBtnRemove = (Button) findViewById(R.id.btnRemove);

        mEdTxtUser = (EditText) findViewById(R.id.txtUser);
        mEdTxtPassword = (EditText) findViewById(R.id.txtPassword);

        mBtnSelect.setOnClickListener(this);
        mBtnAdd.setOnClickListener(this);
        mBtnRemove.setOnClickListener(this);

        settingsListener = new SharedPreferences.OnSharedPreferenceChangeListener() {
            @Override
            public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
                SharedPreferencesEx.this.select();
            }
        };

        mSettings.registerOnSharedPreferenceChangeListener(settingsListener);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_shared_preferences, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
