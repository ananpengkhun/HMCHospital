package com.example.ananpengkhun.hmchospital.module.reception;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ananpengkhun.hmchospital.R;
import com.example.ananpengkhun.hmchospital.common.HMCBaseFragment;
import com.example.ananpengkhun.hmchospital.dao.ReceptionDao;

import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class MainRecepFragment extends HMCBaseFragment implements MainRecepContractor.View {

    @BindView(R.id.rc_reuest_patient) RecyclerView rcReuestPatient;
    private MainRecepContractor.MainRecepPresenter presenter;
    private ReceptionActivity activity;
    private RequestPatientAdapter patientAdapter;

    public MainRecepFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activity = (ReceptionActivity) getActivity();
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_main_recep, container, false);
        ButterKnife.bind(this, v);
        presenter = new MainRecepPresenter(this, activity);
        init();
        return v;
    }

    private void init() {
        presenter.callRequestPatient();
    }

    @Override
    public void setPresenter(MainRecepContractor.MainRecepPresenter presenter) {
        this.presenter = presenter;
    }

    public static Fragment newInstant() {
        MainRecepFragment mainRecepFragment = new MainRecepFragment();
        return mainRecepFragment;
    }

    @Override
    public void showRequestPatient(List<ReceptionDao> list) {
        rcReuestPatient.setLayoutManager(new LinearLayoutManager(activity));
        rcReuestPatient.setHasFixedSize(true);
        patientAdapter = new RequestPatientAdapter();
        patientAdapter.setData(list, activity);
        rcReuestPatient.setAdapter(patientAdapter);
    }
}
