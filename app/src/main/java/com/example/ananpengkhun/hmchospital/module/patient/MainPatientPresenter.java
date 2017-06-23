package com.example.ananpengkhun.hmchospital.module.patient;

import android.util.Log;

import com.example.ananpengkhun.hmchospital.constants.HMCconstants;
import com.example.ananpengkhun.hmchospital.httpmanager.HMCHospitalHttpManager;
import com.example.ananpengkhun.hmchospital.httpmanager.request.FirebaseToRecepNotify;
import com.example.ananpengkhun.hmchospital.httpmanager.response.MessageResponse;
import com.google.gson.Gson;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * Created by ananpengkhun on 6/20/17.
 */

public class MainPatientPresenter implements MainPatientContractor.MainPatientPresenter{
    private static final String TAG = MainPatientPresenter.class.getSimpleName();
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

    @Override
    public void pushNotify() {
        FirebaseToRecepNotify.NotificationBean notificationBean = new FirebaseToRecepNotify.NotificationBean();
        notificationBean.setTitle("From Patient ...");
        notificationBean.setBody("Please help me !!");
        notificationBean.setClick_action("OPEN_ReceptionActivity");
        notificationBean.setUser_type("4");
        FirebaseToRecepNotify.DataBean dataBean = new FirebaseToRecepNotify.DataBean();
        dataBean.setPicture_url("http://www3i.adintrend.com/upload_img2/screenshot/movies_movies/2012-03/006/pic02-big.jpg");
        FirebaseToRecepNotify firebaseNotify = new FirebaseToRecepNotify();
        firebaseNotify.setTo("/topics/"+ HMCconstants.TOPIC_RECEPTION);
        firebaseNotify.setPriority("high");
        firebaseNotify.setNotification(notificationBean);
        firebaseNotify.setData(dataBean);
        Gson gson = new Gson();
        String a = gson.toJson(firebaseNotify);
        Log.d(TAG, "pushNotify: "+a);
        HMCHospitalHttpManager.getInstance().getHmcApi().getIdNotify(firebaseNotify).enqueue(new Callback<MessageResponse>() {
            @Override
            public void onResponse(Call<MessageResponse> call, Response<MessageResponse> response) {
                Log.d(TAG, "onResponse: "+response.body().getMessage_id());
            }

            @Override
            public void onFailure(Call<MessageResponse> call, Throwable t) {
                Log.d(TAG, "onResponse: "+t.getMessage());
            }
        });
    }
}
