package com.example.ananpengkhun.hmchospital.module.patient;


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
public class MainPatientFragment extends HMCBaseFragment implements MainPatientContractor.View{

    private MainPatientContractor.MainPatientPresenter presenter;
    private PatientActivity patientActivity;
    public MainPatientFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        patientActivity = (PatientActivity) getActivity();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_main_patient, container, false);
        presenter = new MainPatientPresenter(this, (PatientActivity) getActivity());
        return v;
    }

    @Override
    public void setPresenter(MainPatientContractor.MainPatientPresenter presenter) {
        this.presenter = presenter;
    }

    public static Fragment newInstant() {
        MainPatientFragment mainPatientFragment = new MainPatientFragment();
        return mainPatientFragment;
    }
}
