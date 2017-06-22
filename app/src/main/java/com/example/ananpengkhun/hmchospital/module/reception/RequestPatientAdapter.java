package com.example.ananpengkhun.hmchospital.module.reception;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.ananpengkhun.hmchospital.R;
import com.example.ananpengkhun.hmchospital.dao.ReceptionDao;
import com.example.ananpengkhun.hmchospital.dialog.HMCDialogFragment;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

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
                    hmcDialogFragment.dismiss();
                    return false;
                });
            });
        }
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
