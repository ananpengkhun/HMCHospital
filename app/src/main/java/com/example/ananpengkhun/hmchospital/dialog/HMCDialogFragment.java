package com.example.ananpengkhun.hmchospital.dialog;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.ananpengkhun.hmchospital.R;
import com.example.ananpengkhun.hmchospital.common.HMCBaseFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by ananpengkhun on 6/22/17.
 */

public class HMCDialogFragment extends DialogFragment {
    public static final int DIALOG_SUCCESS = 1;

    private HMCDialogFragmentOnClicklistener hmcDialogFragmentOnClicklistener;
    private int layout;
    private int dialogType;
    private String titleMsg;
    private String descMsg;

    public interface HMCDialogFragmentOnClicklistener{
        boolean onClick(HMCDialogFragment hmcDialogFragment, View view);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = savedInstanceState != null ? savedInstanceState : getArguments();
        dialogType = bundle.getInt("DIALOG_TYPE");
        titleMsg = bundle.getString("title");
        descMsg = bundle.getString("desc");

        if (DIALOG_SUCCESS == dialogType) {
            setStyle(STYLE_NORMAL, R.style.ThemeDialog);
            layout = R.layout.dialog_success;
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (savedInstanceState != null) {
            layout = savedInstanceState.getInt("layout");
        }
        View v = inflater.inflate(layout, container, false);
        // Inflate the layout for this fragment
        if (DIALOG_SUCCESS == dialogType) {
            DialogSuccessHolder successHolder = new DialogSuccessHolder(v);
            successHolder.tvTitle.setText(titleMsg);
            successHolder.tvDesc.setText(descMsg);
            successHolder.btnSuccess.setOnClickListener(onClickListener);
        }
        return v;
    }

    private View.OnClickListener onClickListener = view -> {

        Log.d("before: ssss", "onCLick: ssssss");
        if(!hmcDialogFragmentOnClicklistener.onClick(HMCDialogFragment.this,view)){
            Log.d("after : ssss", "onCLick: cvvbvbcvbcvb");
        }

    };

    public static HMCDialogFragment createSuccessDialog(String title, String description, HMCDialogFragmentOnClicklistener hmcDialogFragmentOnClicklistener) {
        HMCDialogFragment hmcDialogFragment = new HMCDialogFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("DIALOG_TYPE", DIALOG_SUCCESS);
        bundle.putString("title", title);
        bundle.putString("desc", description);
        hmcDialogFragment.setArguments(bundle);
        hmcDialogFragment.hmcDialogFragmentOnClicklistener = hmcDialogFragmentOnClicklistener;
        return hmcDialogFragment;
    }

    public class DialogSuccessHolder {
        @BindView(R.id.tv_title) TextView tvTitle;
        @BindView(R.id.tv_desc) TextView tvDesc;
        @BindView(R.id.btn_success) Button btnSuccess;

        DialogSuccessHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
