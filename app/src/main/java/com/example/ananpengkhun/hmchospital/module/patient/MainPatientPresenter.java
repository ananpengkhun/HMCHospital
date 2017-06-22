package com.example.ananpengkhun.hmchospital.module.patient;

import android.util.Log;

import com.example.ananpengkhun.hmchospital.module.reception.MainRecepContractor;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

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

    @Override
    public void setFormatDate(Calendar mCalendar) {
        Date date = mCalendar.getTime();
        //String textDate = dateFormat.format(date);
        DateFormat df = new SimpleDateFormat("d/MM/yyyy");
        final String now = df.format(date);
        Log.d("date", "onDateSet: " + now);
        view.getDateFromFormat(now);
    }
}
