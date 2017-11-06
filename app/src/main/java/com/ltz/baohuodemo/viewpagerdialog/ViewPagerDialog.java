package com.ltz.baohuodemo.viewpagerdialog;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;

import com.ltz.baohuodemo.R;
import com.ltz.baohuodemo.navigator.ScaleCircleNavigator;

import net.lucode.hackware.magicindicator.MagicIndicator;
import net.lucode.hackware.magicindicator.ViewPagerHelper;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * viewpager结合dialog，实现浮层轮播
 * Created by 1 on 2017/11/4.
 */
public class ViewPagerDialog extends Dialog{

    ViewPager mViewPager;
    private List<View> pages;
    private MagicIndicator indicator;

    public ViewPagerDialog(Context context) {
        super(context);
    }

    public ViewPagerDialog(Context context, int style){
        //自定义dialog风格
        super(context,style);
    }

    public void setStyle(){
        //不能取消这个功能特别烦人，用户体验不好
        this.setCancelable(true);
        //去除title下方的
//      Context context = this.getContext();
//      int divierId = context.getResources().getIdentifier("android:id/titleDivider", null, null);
//      View divider = this.findViewById(divierId);
//      divider.setBackgroundColor(context.getResources().getColor(R.color.tabColor));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //设置dialog弹出动画
        getWindow().setWindowAnimations(R.style.dialogWindowAnim);
        setContentView(R.layout.viewpager_dialog_layout);
        init();
        setStyle();
    }

    private void init() {
        initView();
        initAdapter();
        initIndicator();
        /**将视图与指示器绑定**/
        ViewPagerHelper.bind(indicator, mViewPager);
    }

    private void initIndicator() {
        indicator=(MagicIndicator) findViewById(R.id.bottom_indicator);
        ScaleCircleNavigator navigator=new ScaleCircleNavigator(this.getContext());
        navigator.setCircleCount(pages.size());
        navigator.setNormalCircleColor(Color.DKGRAY);
        navigator.setSelectedCircleColor(Color.CYAN);
        navigator.setCircleClickListener(new ScaleCircleNavigator.OnCircleClickListener() {
            @Override
            public void onClick(int index) {
                mViewPager.setCurrentItem(index);
            }
        });
        indicator.setNavigator(navigator);
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
                    ImageView view = new ImageView(this.getContext());
                    view.setImageResource(field.getInt(null));
                    view.setScaleType(ImageView.ScaleType.CENTER_CROP);
                    pages.add(view);
                }
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return pages;
    }

    private void initView() {
        mViewPager = findViewById(R.id.dialogviewpager);
    }


}
