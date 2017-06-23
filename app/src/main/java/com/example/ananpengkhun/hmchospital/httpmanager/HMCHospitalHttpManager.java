package com.example.ananpengkhun.hmchospital.httpmanager;

import com.example.ananpengkhun.hmchospital.constants.HMCconstants;
import com.example.ananpengkhun.hmchospital.httpmanager.api.HMCApi;
import com.google.gson.Gson;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by ananpengkhun on 6/19/17.
 */

public class HMCHospitalHttpManager {
    private static HMCHospitalHttpManager ourInstance;
    private HMCApi hmcApi;

    public static HMCHospitalHttpManager getInstance() {
        if(ourInstance == null){
            ourInstance = new HMCHospitalHttpManager();
        }
        return ourInstance;
    }

    private HMCHospitalHttpManager() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(HMCconstants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        hmcApi = retrofit.create(HMCApi.class);
    }

    public HMCApi getHmcApi() {
        return hmcApi;
    }
}
