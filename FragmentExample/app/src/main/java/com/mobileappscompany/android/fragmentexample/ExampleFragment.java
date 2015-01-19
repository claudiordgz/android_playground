package com.mobileappscompany.android.fragmentexample;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

/**
 * Created by Android1 on 1/18/2015.
 */
public class ExampleFragment extends Fragment{
    private ExampleModel mModel;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mModel = new ExampleModel();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.example_fragment, parent, false);
        EditText fragmentTitle = (EditText)v.findViewById(R.id.fragment_title);
        fragmentTitle.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence c, int start,
                                      int before, int count) {
                mModel.setTitle(c.toString());
            }
            @Override
            public void beforeTextChanged(
                    CharSequence c, int start, int count, int after) {
                // This space intentionally left blank
            }
            @Override
            public void afterTextChanged(Editable c) {
                // This one too
            }
        });
        return v;
    }
}
