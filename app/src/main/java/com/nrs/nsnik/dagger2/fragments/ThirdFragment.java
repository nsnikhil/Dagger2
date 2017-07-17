package com.nrs.nsnik.dagger2.fragments;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.nrs.nsnik.dagger2.R;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class ThirdFragment extends Fragment {


    private static final String NULL_VALUE = "N/A";

    private Unbinder mUnbinder;

    public ThirdFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v =  inflater.inflate(R.layout.fragment_third, container, false);
        mUnbinder = ButterKnife.bind(this,v);
        return v;
    }


    private void cleanUp() {
        if (mUnbinder != null) {
            mUnbinder.unbind();
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        cleanUp();
    }

}
