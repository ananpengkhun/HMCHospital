package com.example.ananpengkhun.hmchospital.module.doctor;

/**
 * Created by ananpengkhun on 6/20/17.
 */

public class MainDoctorPresenter implements MainDoctorContractor.MainDoctorPresenter {

    private final MainDoctorContractor.View view;
    private final DoctorActivity activity;

    public MainDoctorPresenter(MainDoctorContractor.View view, DoctorActivity activity) {
        this.view = view;
        this.activity = activity;
    }
}
