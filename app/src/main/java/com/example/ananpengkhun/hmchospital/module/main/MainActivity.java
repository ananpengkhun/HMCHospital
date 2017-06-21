package com.example.ananpengkhun.hmchospital.module.main;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.ActivityCompat;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.ananpengkhun.hmchospital.R;
import com.example.ananpengkhun.hmchospital.common.HMCBaseActivity;
import com.example.ananpengkhun.hmchospital.constants.HMCconstants;


import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends HMCBaseActivity implements MainConstractor.View {
    private static final String TAG = "Main";
    @BindView(R.id.beacons_rv) RecyclerView beaconsRv;
    @BindView(R.id.scan_fab) FloatingActionButton scanFab;
    @BindView(R.id.btn_token) Button btnToken;
    private MainConstractor.MainPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        init();
    }

    private void init() {
        scanFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int accessLo = ActivityCompat.checkSelfPermission(MainActivity.this,Manifest.permission.ACCESS_COARSE_LOCATION);
                if(accessLo != PackageManager.PERMISSION_GRANTED){
                    Log.d(TAG, "onClick: chech permission");
                     ActivityCompat.requestPermissions(MainActivity.this,new String[]{Manifest.permission.ACCESS_COARSE_LOCATION},HMCconstants.REQUEST_COARSE_LOCATION);
                    return;
                }
                accesslocation();
            }
        });

    }

    private void accesslocation() {
        Log.d(TAG, "onClick: check grant");
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void setPresenter(MainConstractor.MainPresenter presenter) {
        this.presenter = presenter;
    }



    @Override
    protected void onResume() {
        super.onResume();

    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode){
            case HMCconstants.REQUEST_COARSE_LOCATION:
                if(grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    accesslocation();
                }else{
                    Toast.makeText(MainActivity.this, "ACCESS_COARSE_LOCATION Denied", Toast.LENGTH_SHORT)
                            .show();
                }
                break;
            default:
                super.onRequestPermissionsResult(requestCode,permissions,grantResults);
        }
    }

}
