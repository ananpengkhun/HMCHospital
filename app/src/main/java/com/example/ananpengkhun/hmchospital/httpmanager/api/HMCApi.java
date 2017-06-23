package com.example.ananpengkhun.hmchospital.httpmanager.api;

import com.example.ananpengkhun.hmchospital.constants.HMCconstants;
import com.example.ananpengkhun.hmchospital.httpmanager.request.FirebaseToNurseNotify;
import com.example.ananpengkhun.hmchospital.httpmanager.request.FirebaseToRecepNotify;
import com.example.ananpengkhun.hmchospital.httpmanager.response.MessageResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/**
 * Created by ananpengkhun on 6/19/17.
 */

public interface HMCApi {

    @Headers({HMCconstants.AUTHORIZATION_TOKEN,HMCconstants.CONTENT_TYPE_JSON})
    @POST(HMCconstants.PATH_NOTIFY)
    Call<MessageResponse> getIdNotify(@Body FirebaseToRecepNotify firebaseNotify);

    @Headers({HMCconstants.AUTHORIZATION_TOKEN,HMCconstants.CONTENT_TYPE_JSON})
    @POST(HMCconstants.PATH_NOTIFY)
    Call<MessageResponse> getIdNotifyNurse(@Body FirebaseToNurseNotify firebaseToNurseNotify);

}
