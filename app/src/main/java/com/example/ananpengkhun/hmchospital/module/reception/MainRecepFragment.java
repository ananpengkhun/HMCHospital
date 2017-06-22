package com.example.ananpengkhun.hmchospital.module.reception;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ananpengkhun.hmchospital.R;
import com.example.ananpengkhun.hmchospital.common.HMCBaseFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class MainRecepFragment extends HMCBaseFragment implements MainRecepContractor.View {

    private MainRecepContractor.MainRecepPresenter presenter;
    private ReceptionActivity activity;
    public MainRecepFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activity = (ReceptionActivity) getActivity();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_main_recep, container, false);
        presenter = new MainRecepPresenter(this, activity);
        init();
        return v;
    }

    private void init() {

    }

    @Override
    public void setPresenter(MainRecepContractor.MainRecepPresenter presenter) {
        this.presenter = presenter;
    }

    public static Fragment newInstant() {
        MainRecepFragment mainRecepFragment = new MainRecepFragment();
        return mainRecepFragment;
    }
}
