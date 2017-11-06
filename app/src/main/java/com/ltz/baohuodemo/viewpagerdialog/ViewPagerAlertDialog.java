package com.ltz.baohuodemo.viewpagerdialog;

import android.app.AlertDialog;
import android.content.Context;
import com.ltz.baohuodemo.R;

/**
 * Created by 1 on 2017/11/6.
 */
public class ViewPagerAlertDialog extends AlertDialog.Builder{

    public ViewPagerAlertDialog(Context context) {
        super(context);
    }

    public ViewPagerAlertDialog(Context context,int style){
        super(context, R.style.dialogstyle);
    }
}
