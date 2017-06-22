package com.example.ananpengkhun.hmchospital.module.reception;

import android.os.Bundle;
import android.widget.FrameLayout;

import com.example.ananpengkhun.hmchospital.R;
import com.example.ananpengkhun.hmchospital.common.HMCBaseActivity;
import com.example.ananpengkhun.hmchospital.constants.HMCconstants;
import com.google.firebase.messaging.FirebaseMessaging;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ReceptionActivity extends HMCBaseActivity implements ReceptionContractor.View {

    @BindView(R.id.content_container) FrameLayout contentContainer;
    private ReceptionContractor.ReceptionPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reception);
        ButterKnife.bind(this);
        presenter = new ReceptionPresenter(this, ReceptionActivity.this);
        init();
    }

    private void init() {
        FirebaseMessaging.getInstance().subscribeToTopic(HMCconstants.TOPIC_RECEPTION);
        getSupportFragmentManager()
                .beginTransaction()
                .replace(contentContainer.getId(),MainRecepFragment.newInstant(),"MainRecepFragment")
                .addToBackStack(null)
                .commit();
    }

    @Override
    public void setPresenter(ReceptionContractor.ReceptionPresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        FirebaseMessaging.getInstance().unsubscribeFromTopic(HMCconstants.TOPIC_RECEPTION);
    }
}
