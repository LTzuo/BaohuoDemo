package com.ltz.baohuodemo.viewpagerdialog;

import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;

import com.ltz.baohuodemo.R;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 1 on 2017/11/6.
 */
public class ViewPagerAlertDialog {

    private Context context;
    private AlertDialog ad;
    ViewPager mViewPager;
    private List<View> pages;

    public ViewPagerAlertDialog(Context context) {
        this.context = context;
        ad = new AlertDialog.Builder(context,R.style.dialogstyle).create();
        ad.show();
        Window window = ad.getWindow();
        window.setContentView(R.layout.viewpager_dialog_layout);
        mViewPager = window.findViewById(R.id.dialogviewpager);
        initAdapter();
    }

    /**初始化适配器**/
    public void initAdapter() {
        pages = getPages();
        MyViewPagerAdapter  myViewPagerAdapter = new MyViewPagerAdapter(pages);
        mViewPager.setAdapter(myViewPagerAdapter);
    }

    private List<View> getPages() {
        List<View> pages=new ArrayList<>();
        Field[] fields=R.drawable.class.getDeclaredFields();
        try {
            for (Field field : fields) {
                if (field.getName().startsWith("page")) {
                    ImageView view = new ImageView(context);
                    view.setImageResource(field.getInt(null));
                    view.setScaleType(ImageView.ScaleType.CENTER_CROP);
//                    TextView view = new TextView(this.getContext());
//                    view.setText("");
                     pages.add(view);
                }
            }
        }
        catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return pages;
    }




}
