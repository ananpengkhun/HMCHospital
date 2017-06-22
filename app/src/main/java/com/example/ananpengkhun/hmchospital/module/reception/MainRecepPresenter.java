package com.example.ananpengkhun.hmchospital.module.reception;

import com.example.ananpengkhun.hmchospital.dao.ReceptionDao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

    @Override
    public void callRequestPatient() {
        List<ReceptionDao> list = new ArrayList<>();
        for(int i=0;i<10;i++){
            ReceptionDao receptionDao = new ReceptionDao();
            receptionDao.setRequestId(i);
            receptionDao.setRequestDes("sick :"+i);
            receptionDao.setRequestUser("user:"+i);
            receptionDao.setRequestDate(new Date());
            list.add(receptionDao);
        }
        view.showRequestPatient(list);
    }
}
