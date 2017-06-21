package com.example.ananpengkhun.hmchospital.module.doctor;

/**
 * Created by ananpengkhun on 6/20/17.
 */

public class DoctorPresenter implements DoctorContractor.DoctorPresenter {
    private final DoctorContractor.View view;
    private final DoctorActivity doctorActivity;

    public DoctorPresenter(DoctorContractor.View view, DoctorActivity doctorActivity) {
        this.view = view;
        this.doctorActivity = doctorActivity;

    }
}
