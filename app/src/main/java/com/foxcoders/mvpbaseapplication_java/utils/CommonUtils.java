package com.foxcoders.mvpbaseapplication_java.utils;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;

import com.foxcoders.mvpbaseapplication_java.R;

public class CommonUtils {
    public static ProgressDialog showLoading(Context context){
        ProgressDialog dialog = new ProgressDialog(context);
        dialog.show();
        if(dialog.getWindow()!=null){
            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        }
        dialog.setContentView(R.layout.loading_layout);
        dialog.setCancelable(false);
        dialog.setCanceledOnTouchOutside(false);
        return dialog;
    }
}
