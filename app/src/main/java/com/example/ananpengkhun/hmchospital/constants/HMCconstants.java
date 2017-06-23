package com.example.ananpengkhun.hmchospital.constants;

/**
 * Created by ananpengkhun on 6/19/17.
 */

public class HMCconstants {
    public static final String BASE_URL = "https://fcm.googleapis.com/fcm/";
    public static final String AUTHORIZATION_TOKEN = "Authorization: key=AIzaSyAf5Ix7KvE4BKKVZITes916nMyrcbJg3Y0";
    public static final String CONTENT_TYPE_JSON = "Content-Type: application/json";
    public static final int REQUEST_COARSE_LOCATION = 99;
    public static final String PATH_NOTIFY = "send";
    public static final String TOPIC_PATIENT = "patient";
    public static final String TOPIC_DOCTOR = "doctor";
    public static final String TOPIC_NURSE = "nurse";
    public static final String TOPIC_RECEPTION = "reception";
    public static final String[] USERNAME = {
            "patient",
            "doctor",
            "nurse",
            "reception"
    };
    public static final String[] PASSWORD = {
            "1111",
            "1111",
            "1111",
            "1111"
    };
    public static final int[] TYPE = {
            1,
            2,
            3,
            4
    };

}
