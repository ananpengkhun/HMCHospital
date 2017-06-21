package com.example.ananpengkhun.hmchospital.module.nurse;

import android.os.Bundle;
import android.widget.FrameLayout;

import com.example.ananpengkhun.hmchospital.R;
import com.example.ananpengkhun.hmchospital.common.HMCBaseActivity;

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
}
