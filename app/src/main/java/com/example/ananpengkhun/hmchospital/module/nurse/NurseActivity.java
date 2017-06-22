package com.example.ananpengkhun.hmchospital.module.nurse;

import android.os.Bundle;
import android.widget.FrameLayout;

import com.example.ananpengkhun.hmchospital.R;
import com.example.ananpengkhun.hmchospital.common.HMCBaseActivity;
import com.example.ananpengkhun.hmchospital.constants.HMCconstants;
import com.google.firebase.messaging.FirebaseMessaging;

import butterknife.BindView;
import butterknife.ButterKnife;

public class NurseActivity extends HMCBaseActivity implements NurseContractor.View {
    @BindView(R.id.content_container) FrameLayout contentContainer;
    private NurseContractor.NursePresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nurse);
        ButterKnife.bind(this);
        presenter = new NursePresenter(this, NurseActivity.this);
        init();
    }

    private void init() {
        FirebaseMessaging.getInstance().subscribeToTopic(HMCconstants.TOPIC_NURSE);
        getSupportFragmentManager()
                .beginTransaction()
                .replace(contentContainer.getId(),MainNurseFragment.newInstant(),"MainNurseFragment")
                .addToBackStack(null)
                .commit();
    }

    @Override
    public void setPresenter(NurseContractor.NursePresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        FirebaseMessaging.getInstance().unsubscribeFromTopic(HMCconstants.TOPIC_NURSE);
    }
}
