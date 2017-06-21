package com.example.ananpengkhun.hmchospital.module.patient;

/**
 * Created by ananpengkhun on 6/20/17.
 */

public class PatientPresenter implements PatientContractor.PatientPresenter{
    private final PatientContractor.View view;
    private final PatientActivity patientActivity;

    public PatientPresenter(PatientContractor.View view, PatientActivity patientActivity) {
        this.view = view;
        this.patientActivity = patientActivity;
    }
}
