package com.example.ananpengkhun.hmchospital.module.reception;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.ananpengkhun.hmchospital.R;
import com.example.ananpengkhun.hmchospital.constants.HMCconstants;
import com.example.ananpengkhun.hmchospital.dao.ReceptionDao;
import com.example.ananpengkhun.hmchospital.dialog.HMCDialogFragment;
import com.example.ananpengkhun.hmchospital.httpmanager.HMCHospitalHttpManager;
import com.example.ananpengkhun.hmchospital.httpmanager.request.FirebaseToNurseNotify;
import com.example.ananpengkhun.hmchospital.httpmanager.request.FirebaseToRecepNotify;
import com.example.ananpengkhun.hmchospital.httpmanager.response.MessageResponse;
import com.google.gson.Gson;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * Created by ananpengkhun on 6/22/17.
 */

public class RequestPatientAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<ReceptionDao> data;
    private ReceptionActivity activity;


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_request_patient, parent, false);
        return new RequestPatientViewHolder(v);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof RequestPatientViewHolder) {
            RequestPatientViewHolder requestPatientViewHolder = (RequestPatientViewHolder) holder;
            requestPatientViewHolder.tvName.setText(data.get(position).getRequestUser());
            requestPatientViewHolder.tvDate.setText(data.get(position).getRequestDate().toString());
            requestPatientViewHolder.cvCardItem.setOnClickListener(view -> {
                activity.showDialogSuccess("ยืนยันการมาถึง", "", (hmcDialogFragment, view1) -> {
                    pushNotifyToNurse();
                    hmcDialogFragment.dismiss();
                    return false;
                });
            });
        }
    }

    private void pushNotifyToNurse() {
        FirebaseToNurseNotify.NotificationBean notificationBean = new FirebaseToNurseNotify.NotificationBean();
        notificationBean.setTitle("From Nurse ...");
        notificationBean.setBody("Please help me !!");
        notificationBean.setClick_action("OPEN_NurseActivity");
        notificationBean.setUser_type("3");
        FirebaseToNurseNotify.DataBean dataBean = new FirebaseToNurseNotify.DataBean();
        dataBean.setPicture_url("http://www3i.adintrend.com/upload_img2/screenshot/movies_movies/2012-03/006/pic02-big.jpg");
        FirebaseToNurseNotify firebaseNotify = new FirebaseToNurseNotify();
        firebaseNotify.setTo("/topics/"+ HMCconstants.TOPIC_NURSE);
        firebaseNotify.setPriority("high");
        firebaseNotify.setNotification(notificationBean);
        firebaseNotify.setData(dataBean);
        Gson gson = new Gson();
        String a = gson.toJson(firebaseNotify);
        Log.d("RequestNurse", "pushNotify: "+a);
        HMCHospitalHttpManager.getInstance().getHmcApi().getIdNotifyNurse(firebaseNotify).enqueue(new Callback<MessageResponse>() {
            @Override
            public void onResponse(Call<MessageResponse> call, Response<MessageResponse> response) {
                Log.d("Adapter", "onResponse: "+response.body().getMessage_id());
            }

            @Override
            public void onFailure(Call<MessageResponse> call, Throwable t) {
                Log.d("Adapter", "final: "+t.getMessage());
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public void setData(List<ReceptionDao> data, ReceptionActivity activity) {
        this.data = data;
        this.activity = activity;
    }


    class RequestPatientViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.cv_card_item) CardView cvCardItem;
        @BindView(R.id.cb_check) CheckBox cbCheck;
        @BindView(R.id.tv_name) TextView tvName;
        @BindView(R.id.tv_date) TextView tvDate;

        public RequestPatientViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
