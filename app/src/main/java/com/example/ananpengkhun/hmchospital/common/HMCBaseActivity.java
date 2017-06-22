package com.example.ananpengkhun.hmchospital.common;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.ananpengkhun.hmchospital.dialog.HMCDialogFragment;

/**
 * Created by ananpengkhun on 6/19/17.
 */

public abstract class HMCBaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public void showDialogSuccess(String title, String description, HMCDialogFragment.HMCDialogFragmentOnClicklistener hmcDialogFragmentOnClicklistener){
        HMCDialogFragment hmcDialogFragment = HMCDialogFragment.createSuccessDialog(title,description,hmcDialogFragmentOnClicklistener);
        hmcDialogFragment.show(getSupportFragmentManager(),"SuccessDialog");
    }




}
