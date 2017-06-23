package com.example.ananpengkhun.hmchospital.module.patient;


import android.app.TimePickerDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TimePicker;

import com.example.ananpengkhun.hmchospital.R;
import com.example.ananpengkhun.hmchospital.common.HMCBaseFragment;
import com.fourmob.datetimepicker.date.DatePickerDialog;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;



/**
 * A simple {@link Fragment} subclass.
 */
public class MainPatientFragment extends HMCBaseFragment implements MainPatientContractor.View {

    @BindView(R.id.tv_calendar) TextView tvCalendar;
    @BindView(R.id.imv_calendar) ImageView imvCalendar;
    @BindView(R.id.tv_time) TextView tvTime;
    @BindView(R.id.imv_time) ImageView imvTime;
    @BindView(R.id.ed_behavior_basic) EditText edBehaviorBasic;
    @BindView(R.id.btn_save) Button btnSave;
    private MainPatientContractor.MainPatientPresenter presenter;
    private PatientActivity patientActivity;
    private DatePickerDialog mDatePicker;
    private TimePickerDialog mTimePicker;
    private Calendar mCalendar;
    private int hour;
    private int minute;


    public MainPatientFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        patientActivity = (PatientActivity) getActivity();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_main_patient, container, false);
        presenter = new MainPatientPresenter(this, (PatientActivity) getActivity());
        ButterKnife.bind(this, v);
        init();
        return v;
    }

    private void init() {
        mCalendar = Calendar.getInstance();
        hour = mCalendar.get(Calendar.HOUR_OF_DAY);
        minute = mCalendar.get(Calendar.MINUTE);
        mDatePicker = DatePickerDialog.newInstance(onDateSetListener,
                mCalendar.get(Calendar.YEAR),       // ปี
                mCalendar.get(Calendar.MONTH),      // เดือน
                mCalendar.get(Calendar.DAY_OF_MONTH),// วัน (1-31)
                false);
        imvCalendar.setOnClickListener(onCalendarClicklistener);
        imvTime.setOnClickListener(onTimeClicklistener);
        btnSave.setOnClickListener(onSaveClicklistener);
    }

    @Override
    public void setPresenter(MainPatientContractor.MainPatientPresenter presenter) {
        this.presenter = presenter;
    }

    public static Fragment newInstant() {
        MainPatientFragment mainPatientFragment = new MainPatientFragment();
        return mainPatientFragment;
    }

    private View.OnClickListener onCalendarClicklistener = view -> {
        mDatePicker.setYearRange(2000, 2020);
        mDatePicker.show(getFragmentManager(), "datePicker");
    };

    private View.OnClickListener onTimeClicklistener = view -> {
        mTimePicker = new TimePickerDialog(patientActivity, (timePicker, hour, minute) -> {
            tvTime.setText(hour+":"+minute);
        },hour,minute,true);
        mTimePicker.setTitle("Select Time");
        mTimePicker.show();
    };

    private View.OnClickListener onSaveClicklistener  = view -> {
        //on send data to firebase
        presenter.pushNotify();
    };

    private DatePickerDialog.OnDateSetListener onDateSetListener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePickerDialog datePickerDialog, int year, int month, int day) {
            mCalendar.set(year, month, day);
            presenter.setFormatDate(mCalendar);
        }
    };

    @Override
    public void getDateFromFormat(String date) {
        tvCalendar.setText(date);
    }
}
