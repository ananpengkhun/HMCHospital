package com.example.ananpengkhun.hmchospital.module.reception;

/**
 * Created by ananpengkhun on 6/22/17.
 */

public class MainRecepPresenter implements MainRecepContractor.MainRecepPresenter {
    private final MainRecepContractor.View view;
    private final ReceptionActivity activity;

    public MainRecepPresenter(MainRecepContractor.View view, ReceptionActivity activity) {
        this.view = view;
        this.activity = activity;
    }
}
