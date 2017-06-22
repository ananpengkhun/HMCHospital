package com.example.ananpengkhun.hmchospital.module.login;

import com.example.ananpengkhun.hmchospital.common.BasePresent;
import com.example.ananpengkhun.hmchospital.common.BaseView;

/**
 * Created by ananpengkhun on 6/19/17.
 */

public class UserLoginContractor {
    public interface UserLoginPresenter extends BasePresent{

    }

    public interface View extends BaseView<UserLoginContractor.UserLoginPresenter>{
        void navigateToPatient();
        void navigateToDoctor();
        void navigateToNurse();
        void navigateToReception();
    }
}
