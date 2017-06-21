package com.example.ananpengkhun.hmchospital.module.patient;

import com.example.ananpengkhun.hmchospital.module.doctor.DoctorContractor;

/**
 * Created by ananpengkhun on 6/20/17.
 */

public class MainPatientPresenter implements MainPatientContractor.MainPatientPresenter{
    private final MainPatientContractor.View view;
    private final PatientActivity activity;

    public MainPatientPresenter(MainPatientContractor.View view, PatientActivity activity) {
        this.view = view;
        this.activity = activity;
    }
}
