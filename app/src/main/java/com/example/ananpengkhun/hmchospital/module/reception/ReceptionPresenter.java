package com.example.ananpengkhun.hmchospital.module.reception;

/**
 * Created by ananpengkhun on 6/22/17.
 */

public class ReceptionPresenter implements ReceptionContractor.ReceptionPresenter {
    private final ReceptionContractor.View view;
    private final ReceptionActivity receptionActivity;

    public ReceptionPresenter(ReceptionContractor.View view, ReceptionActivity receptionActivity) {
        this.view = view;
        this.receptionActivity = receptionActivity;
    }
}
