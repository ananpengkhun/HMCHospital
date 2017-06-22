package com.example.ananpengkhun.hmchospital.module.reception;

import com.example.ananpengkhun.hmchospital.common.BasePresent;
import com.example.ananpengkhun.hmchospital.common.BaseView;
import com.example.ananpengkhun.hmchospital.dao.ReceptionDao;

import java.util.List;

/**
 * Created by ananpengkhun on 6/22/17.
 */

public class MainRecepContractor {
    public interface MainRecepPresenter extends BasePresent{
        void callRequestPatient();
    }

    public interface View extends BaseView<MainRecepContractor.MainRecepPresenter>{
        void showRequestPatient(List<ReceptionDao> list);
    }
}
