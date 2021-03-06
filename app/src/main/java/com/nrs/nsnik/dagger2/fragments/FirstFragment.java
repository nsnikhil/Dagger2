package com.nrs.nsnik.dagger2.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.nrs.nsnik.dagger2.MyApplication;
import com.nrs.nsnik.dagger2.R;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.Unbinder;


public class FirstFragment extends Fragment {

    private Unbinder mUnbinder;
    @Inject
    Object mObject;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ((MyApplication) getActivity().getApplicationContext()).getFirstComponent().injectInFirstFragment(this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.first_fragment, container, false);
        mUnbinder = ButterKnife.bind(this, v);
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