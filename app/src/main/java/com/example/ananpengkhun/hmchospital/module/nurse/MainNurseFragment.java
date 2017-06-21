package com.example.ananpengkhun.hmchospital.module.nurse;


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
public class MainNurseFragment extends HMCBaseFragment implements MainNurseContractor.View {
    private MainNurseContractor.MainNursePresenter presenter;
    private NurseActivity nurseActivity;
    public MainNurseFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        nurseActivity = (NurseActivity) getActivity();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_main_nurse, container, false);
        presenter = new MainNursePresenter(this, nurseActivity);
        return v;
    }

    public static Fragment newInstant() {
        MainNurseFragment mainNurseFragment = new MainNurseFragment();
        return mainNurseFragment;
    }

    @Override
    public void setPresenter(MainNurseContractor.MainNursePresenter presenter) {
        this.presenter = presenter;
    }
}
