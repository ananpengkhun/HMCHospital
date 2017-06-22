package com.example.ananpengkhun.hmchospital.dao.notification.token;

import android.util.Log;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

/**
 * Created by ananpengkhun on 6/19/17.
 */

public class FirebaseInstantServiceToken extends FirebaseInstanceIdService {

    @Override
    public void onTokenRefresh() {
        super.onTokenRefresh();
        // if token expired this will get refresh token.
        String newToken = FirebaseInstanceId.getInstance().getToken();
        Log.d("newToken", "onTokenRefresh: "+newToken);
    }




}
