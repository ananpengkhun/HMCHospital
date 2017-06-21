package com.example.ananpengkhun.hmchospital.module.login;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.ananpengkhun.hmchospital.R;
import com.example.ananpengkhun.hmchospital.common.HMCBaseActivity;
import com.example.ananpengkhun.hmchospital.common.HMCBaseFragment;
import com.example.ananpengkhun.hmchospital.constants.HMCconstants;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class UserLoginFragment extends HMCBaseFragment implements UserLoginContractorFragment.View {
    @BindView(R.id.ed_username) EditText edUsername;
    @BindView(R.id.ed_password) EditText edPassword;
    @BindView(R.id.btn_submit) Button btnSubmit;
    private UserLoginContractorFragment.UserLoginPresenterFragment presenterFragment;
    private UserLoginActivity activity;


    public UserLoginFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activity = (UserLoginActivity) getActivity();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_user_login, container, false);
        ButterKnife.bind(this, v);
        presenterFragment = new UserLoginPresenterFragment(this, (HMCBaseActivity) getActivity());
        initViewLogin();
        return v;
    }

    private void initViewLogin() {
        edUsername.setText(HMCconstants.USERNAME[0]);
        edPassword.setText(HMCconstants.PASSWORD[0]);
        btnSubmit.setOnClickListener(onSubmitlistener);
    }

    @Override
    public void setPresenter(UserLoginContractorFragment.UserLoginPresenterFragment presenter) {
        this.presenterFragment = presenter;
    }

    private View.OnClickListener onSubmitlistener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            presenterFragment.checkUserLogin(
                    edUsername.getText().toString(),
                    edPassword.getText().toString());
        }
    };

    public static Fragment newInstant() {
        UserLoginFragment userLoginFragment = new UserLoginFragment();
        Bundle bundle = new Bundle();
        userLoginFragment.setArguments(bundle);
        return userLoginFragment;
    }

    @Override
    public void loginFail() {

    }

    @Override
    public void navigateToPatient() {
        activity.navigateToPatient();
    }

    @Override
    public void navigateToDoctor() {
        activity.navigateToDoctor();
    }
}
