package com.example.ananpengkhun.hmchospital.module.login;

import com.example.ananpengkhun.hmchospital.common.BasePresent;
import com.example.ananpengkhun.hmchospital.common.BaseView;

/**
 * Created by ananpengkhun on 6/19/17.
 */

public class UserLoginContractorFragment {
    public interface UserLoginPresenterFragment extends BasePresent{
        void checkUserLogin(String user, String pass);
    }

    public interface View extends BaseView<UserLoginContractorFragment.UserLoginPresenterFragment>{
        void loginFail();
        void navigateToPatient();
        void navigateToDoctor();
        void navigateToNurse();
        void navigateToReception();
    }
}
