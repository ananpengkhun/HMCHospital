package com.example.ananpengkhun.hmchospital.module.patient;

import com.example.ananpengkhun.hmchospital.common.BasePresent;
import com.example.ananpengkhun.hmchospital.common.BaseView;

import java.util.Calendar;

/**
 * Created by ananpengkhun on 6/20/17.
 */

public class MainPatientContractor {
    public interface MainPatientPresenter extends BasePresent{
        void setFormatDate(Calendar mCalendar);
    }

    public interface View extends BaseView<MainPatientContractor.MainPatientPresenter>{
        void getDateFromFormat(String date);
    }
}
