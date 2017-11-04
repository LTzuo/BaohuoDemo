package com.ltz.baohuodemo.viewpagerdialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.view.ViewPager;

import com.ltz.baohuodemo.R;

/**
 * viewpager结合dialog，实现浮层轮播
 * Created by 1 on 2017/11/4.
 */
public class ViewPagerDialog extends Dialog{

    ViewPager mViewPager;
    MyViewPagerAdapter myViewPagerAdapter;

    public ViewPagerDialog(Context context) {
        super(context);
    }

    public ViewPagerDialog(Context context, int style){
        //自定义dialog风格
        super(context,R.style.dialogstyle);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //设置dialog弹出动画
        getWindow().setWindowAnimations(R.style.dialogWindowAnim);
        setContentView(R.layout.viewpager_dialog_layout);
        initView();
    }

    private void initView() {
        mViewPager = findViewById(R.id.dialogviewpager);
    }


}
