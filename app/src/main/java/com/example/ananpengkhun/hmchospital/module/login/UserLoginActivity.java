package com.example.ananpengkhun.hmchospital.module.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.FrameLayout;

import com.example.ananpengkhun.hmchospital.R;
import com.example.ananpengkhun.hmchospital.common.HMCBaseActivity;
import com.example.ananpengkhun.hmchospital.module.doctor.DoctorActivity;
import com.example.ananpengkhun.hmchospital.module.main.MainActivity;
import com.example.ananpengkhun.hmchospital.module.patient.PatientActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by ananpengkhun on 6/19/17.
 */

public class UserLoginActivity extends HMCBaseActivity implements UserLoginContractor.View {

    @BindView(R.id.content_container) FrameLayout contentContainer;
    private UserLoginContractor.UserLoginPresenter presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userlogin);
        ButterKnife.bind(this);
        presenter = new UserLoginPresenter(this, UserLoginActivity.this);
        init();
    }

    private void init() {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(contentContainer.getId(),UserLoginFragment.newInstant(),"UserLoginFragment")
                .addToBackStack(null)
                .commit();
    }


    @Override
    public void setPresenter(UserLoginContractor.UserLoginPresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void navigateToPatient() {
        Intent intent = new Intent(UserLoginActivity.this, PatientActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void navigateToDoctor() {
        Intent intent = new Intent(UserLoginActivity.this, DoctorActivity.class);
        startActivity(intent);
        finish();
    }
}
