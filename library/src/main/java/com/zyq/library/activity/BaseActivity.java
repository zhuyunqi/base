package com.zyq.library.activity;

import android.os.Build;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.zyq.library.R;


/**
 * @author: zhu yun qi
 * @mail: zhuyunqi_88@163.com
 * @date: 2018/3/14
 * @describe: BaseActivity
 */

public abstract class BaseActivity extends LogActivity {

    private Toolbar toolbar;

    private FrameLayout viewContent;

    private TextView title;

    /**
     * 状态栏颜色
     */
    private int statusBarColor = R.color.colorPrimary;

    /**
     * 是否设置状态栏
     */
    private boolean isSetBarFlag = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.base_content_view);
        initView();
        initStatusBar();
        initTopBar();
        initContentView();
    }

    @Override
    protected void onStop() {
        super.onStop();
        hideProgressBar();
    }

    private void initView() {
        toolbar = findViewById(R.id.toolbar);
        viewContent = findViewById(R.id.contentView);
        title = findViewById(R.id.title);
    }

    private void initStatusBar() {
        Window window = getWindow();
        if (fullScreen()) {
            window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
            return;
        }
        setStatusBarColor(isSetBarFlag, statusBarColor);
        if (isSetBarFlag) {
            //设置透明状态栏,这样才能让 ContentView 向上
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
                window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            }
            //需要设置这个 flag 才能调用 setStatusBarColor 来设置状态栏颜色
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            }

            //设置状态栏颜色,要想状态栏颜色生效需要要使用window.clearFlags
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                window.setStatusBarColor(ContextCompat.getColor(this, statusBarColor));
            }

            ViewGroup mContentView = this.findViewById(Window.ID_ANDROID_CONTENT);
            View mChildView = mContentView.getChildAt(0);
            if (mChildView != null) {
                //注意不是设置 ContentView 的 FitsSystemWindows, 而是设置 ContentView 的第一个子 View . 使其不为系统 View 预留空间.
                ViewCompat.setFitsSystemWindows(mChildView, false);
            }
        }

    }

    private void initTopBar() {
        //初始化设置 Toolbar
        setSupportActionBar(toolbar);
        if (showTopBar()) {
            toolbar.setVisibility(View.VISIBLE);
        } else {
            toolbar.setVisibility(View.GONE);
        }
        //默认是返回图标，可以在子类重置
        toolbar.setNavigationIcon(R.drawable.img_back);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
    }

    private void initContentView() {
        LayoutInflater.from(this).inflate(getContentView(), viewContent);
    }

    /**
     * 设置TopBar是否可见
     *
     * @return
     */
    protected boolean showTopBar() {
        return true;
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
     * 掩藏状态栏，显示全屏
     *
     * @return
     */
    protected boolean fullScreen() {
        return false;
    }

    protected void setStatusBarColor(boolean isSetBarFlag, int statusBarColor) {
        this.isSetBarFlag = isSetBarFlag;
        this.statusBarColor = statusBarColor;
    }

    /**
     * 加载布局文件
     *
     * @return
     */
    protected abstract int getContentView();

    public Toolbar getToolbar() {
        return toolbar;
    }

    public TextView getTittle() {
        return title;
    }

}
