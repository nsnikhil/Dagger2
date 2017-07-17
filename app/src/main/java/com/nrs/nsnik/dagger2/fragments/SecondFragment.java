package com.nrs.nsnik.dagger2.fragments;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.nrs.nsnik.dagger2.MyApplication;
import com.nrs.nsnik.dagger2.R;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class SecondFragment extends Fragment {

    @Inject
    SharedPreferences mSharedPreferences;

    @BindView(R.id.secondInput)
    EditText mInput;
    @BindView(R.id.secondOutput)
    TextView mOutput;
    @BindView(R.id.secondSave)
    Button mSave;
    @BindView(R.id.secondRetrieve)
    Button mRetrieve;

    private Unbinder mUnbinder;
    private static final String NULL_VALUE = "N/A";

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ((MyApplication) getActivity().getApplicationContext()).getSecondComponent().injectSecondFragment(this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.second_fragment, container, false);
        mUnbinder = ButterKnife.bind(this, v);
        return v;
    }

    @OnClick(R.id.secondSave)
    void save() {
        if (!mInput.getText().toString().isEmpty()) {
            mSharedPreferences.edit().putString(getActivity().getResources().getString(R.string.sPfKeySecondValue), mInput.getText().toString()).apply();
        } else {
            mInput.setError(getActivity().getResources().getString(R.string.secondError));
        }
    }

    @OnClick(R.id.secondRetrieve)
    void retrieve() {
        mOutput.setText(mSharedPreferences.getString(getActivity().getResources().getString(R.string.sPfKeySecondValue), NULL_VALUE));
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
