package com.ltz.baohuodemo.viewpagerdialog;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;
/**
 * viewpager 适配器
 * Created by 1 on 2017/11/4.
 */
public class MyViewPagerAdapter extends PagerAdapter{

    private List<View> mViewList = new ArrayList<>();

    public MyViewPagerAdapter(List<View> mList){
        this.mViewList = mList;
    }

    @Override
    public int getCount() {
        return mViewList.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {//必须实现，实例化
        container.addView(mViewList.get(position));
        return mViewList.get(position);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {//必须实现，销毁
        container.removeView(mViewList.get(position));
    }




}
