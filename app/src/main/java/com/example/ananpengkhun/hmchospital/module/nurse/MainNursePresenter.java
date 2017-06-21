package com.example.ananpengkhun.hmchospital.module.nurse;

/**
 * Created by ananpengkhun on 6/21/17.
 */

public class MainNursePresenter implements MainNurseContractor.MainNursePresenter {
    private final MainNurseContractor.View view;
    private final NurseActivity nurseActivity;

    public MainNursePresenter(MainNurseContractor.View view, NurseActivity nurseActivity) {
        this.view = view;
        this.nurseActivity = nurseActivity;
    }
}
