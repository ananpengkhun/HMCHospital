package com.example.ananpengkhun.hmchospital.module.doctor;


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
public class MainDoctorFragment extends HMCBaseFragment implements MainDoctorContractor.View{

    private MainDoctorContractor.MainDoctorPresenter presenter;
    private DoctorActivity activity;
    public MainDoctorFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activity = (DoctorActivity) getActivity();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_doctor, container, false);
        presenter = new MainDoctorPresenter(this,activity);
        return v;
    }

    @Override
    public void setPresenter(MainDoctorContractor.MainDoctorPresenter presenter) {
        this.presenter = presenter;
    }

    public static Fragment newInstant() {
        MainDoctorFragment doctorFragment = new MainDoctorFragment();
        return doctorFragment;
    }
}
