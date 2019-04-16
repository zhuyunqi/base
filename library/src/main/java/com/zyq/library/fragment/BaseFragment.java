package com.zyq.library.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.zyq.library.R;


/**
 * @author: zhu yun qi
 * @mail: zhuyunqi_88@163.com
 * @date: 2018/3/14
 * @describe:
 */

public abstract class BaseFragment extends LogFragment {

    private Toolbar toolbar;

    private FrameLayout contentView;

    private TextView title;

    private LinearLayout hintView;

    private ImageView hintImg;

    private TextView hintText;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View baseView = inflater.inflate(R.layout.base_content_view, container, false);
        initWidget(baseView);
        initTopBar();
        initContentView();
        return baseView;
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onStop() {
        super.onStop();
        hideProgressBar();
    }

    private void initWidget(View view) {
        toolbar = view.findViewById(R.id.toolbar);
        contentView = view.findViewById(R.id.contentView);
        title = view.findViewById(R.id.title);
        hintView = view.findViewById(R.id.hintView);
        hintImg = view.findViewById(R.id.hintImg);
        hintText = view.findViewById(R.id.hintText);
    }

    public LinearLayout getHintView() {
        return hintView;
    }

    private void initContentView() {
        LayoutInflater.from(getActivity()).inflate(getContentView(), contentView);
    }

    private void initTopBar() {
        if (showTopBar()) {
            toolbar.setVisibility(View.VISIBLE);
        } else {
            toolbar.setVisibility(View.GONE);
        }
    }

    /**
     * 显示ProgressBar
     */
    protected void showProgressBar() {
    }

    /**
     * 掩藏ProgressBar
     */
    protected void hideProgressBar() {

    }

    /**
     * 加载布局文件
     *
     * @return
     */
    protected abstract int getContentView();

    /**
     * 设置TopBar是否可见
     *
     * @return
     */
    protected boolean showTopBar() {
        return false;
    }

    public Toolbar getToolbar() {
        return toolbar;
    }

    public TextView getTittle() {
        return title;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    /**
     * 设置页面提示语
     *
     * @param text
     * @param img
     */
    protected void setHintView(String text, int img) {
        hintView.setVisibility(View.VISIBLE);
        hintText.setText(text);
        hintImg.setImageResource(img);
    }

    protected void hideHintView() {
        hintView.setVisibility(View.GONE);
    }


}