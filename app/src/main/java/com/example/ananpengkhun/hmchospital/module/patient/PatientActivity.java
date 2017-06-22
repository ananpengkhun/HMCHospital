package com.example.ananpengkhun.hmchospital.module.patient;

import android.os.Bundle;
import android.widget.FrameLayout;

import com.example.ananpengkhun.hmchospital.R;
import com.example.ananpengkhun.hmchospital.common.HMCBaseActivity;
import com.example.ananpengkhun.hmchospital.constants.HMCconstants;
import com.google.firebase.messaging.FirebaseMessaging;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PatientActivity extends HMCBaseActivity implements PatientContractor.View {

    @BindView(R.id.content_container) FrameLayout contentContainer;
    private PatientContractor.PatientPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient);
        ButterKnife.bind(this);
        presenter = new PatientPresenter(this, PatientActivity.this);
        init();

    }

    private void init() {
        FirebaseMessaging.getInstance().subscribeToTopic(HMCconstants.TOPIC_PATIENT);
        getSupportFragmentManager()
                .beginTransaction()
                .replace(contentContainer.getId(),MainPatientFragment.newInstant(),"MainPatientFragment")
                .addToBackStack(null)
                .commit();
    }

    @Override
    public void setPresenter(PatientContractor.PatientPresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        FirebaseMessaging.getInstance().unsubscribeFromTopic(HMCconstants.TOPIC_PATIENT);
    }
}
