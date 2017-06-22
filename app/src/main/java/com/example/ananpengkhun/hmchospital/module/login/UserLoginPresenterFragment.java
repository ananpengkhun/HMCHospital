package com.example.ananpengkhun.hmchospital.module.login;

import android.util.Log;

import com.example.ananpengkhun.hmchospital.common.HMCBaseActivity;
import com.example.ananpengkhun.hmchospital.constants.HMCconstants;
import com.google.firebase.messaging.FirebaseMessaging;

import java.util.Iterator;

/**
 * Created by ananpengkhun on 6/19/17.
 */

public class UserLoginPresenterFragment implements UserLoginContractorFragment.UserLoginPresenterFragment {
    private final UserLoginContractorFragment.View view;
    private final HMCBaseActivity activity;

    public UserLoginPresenterFragment(UserLoginContractorFragment.View view, HMCBaseActivity activity) {
        this.view = view;
        this.activity = activity;
        view.setPresenter(this);
    }

    @Override
    public void checkUserLogin(String user, String pass) {
        if (!"".equals(user) && !"".equals(pass)) {
            for (int i=0;i<HMCconstants.USERNAME.length;i++) {
                if (user.equals(HMCconstants.USERNAME[i]) && pass.equals(HMCconstants.PASSWORD[i])) {
                    // login success
                    int type = HMCconstants.TYPE[i];
                    if(1 == type){
                        view.navigateToPatient();
                    }else if(2 == type){
                        view.navigateToDoctor();
                    }else if(3 == type){
                        view.navigateToNurse();
                    }else if(4 == type){
                        view.navigateToReception();
                    }
                } else {
                    //login fail
                    view.loginFail();
                }
            }
        } else {
            view.loginFail();
        }
    }
}
