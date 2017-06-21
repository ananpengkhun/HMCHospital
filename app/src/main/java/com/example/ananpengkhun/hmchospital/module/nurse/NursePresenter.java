package com.example.ananpengkhun.hmchospital.module.nurse;

/**
 * Created by ananpengkhun on 6/21/17.
 */

public class NursePresenter implements NurseContractor.NursePresenter {
    private final NurseContractor.View view;
    private final NurseActivity nurseActivity;

    public NursePresenter(NurseContractor.View view, NurseActivity nurseActivity) {
        this.view = view;
        this.nurseActivity = nurseActivity;
    }
}
