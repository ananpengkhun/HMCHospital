package com.example.ananpengkhun.hmchospital.httpmanager;

import com.example.ananpengkhun.hmchospital.httpmanager.api.HMCApi;

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
    }

    public HMCApi getHmcApi() {
        return hmcApi;
    }
}
