package com.zyq.library.activity;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.WindowManager;

import com.zyq.library.util.LogUtils;


/**
 * @author: zhu yun qi
 * @mail: zhuyunqi_88@163.com
 * @date: 2018/3/14
 * @describe: 打印类
 */

public  class LogActivity extends AppCompatActivity {
    public String mTagActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mTagActivity = this.getClass().getSimpleName() + "[" + hashCode() + "]";
        LogUtils.i(mTagActivity);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        LogUtils.i(mTagActivity);
    }

    @Override
    public void onPostCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onPostCreate(savedInstanceState, persistentState);
        LogUtils.i(mTagActivity);
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        LogUtils.i(mTagActivity);
    }

    @Override
    protected void onStart() {
        super.onStart();
        LogUtils.i(mTagActivity);
    }

    @Override
    protected void onResume() {
        super.onResume();
        LogUtils.i(mTagActivity);
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        LogUtils.i(mTagActivity);
    }

    @Override
    protected void onPause() {
        super.onPause();
        LogUtils.i(mTagActivity);
    }

    @Override
    protected void onResumeFragments() {
        super.onResumeFragments();
        LogUtils.i(mTagActivity);
    }

    @Override
    protected void onStop() {
        super.onStop();
        LogUtils.i(mTagActivity);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        LogUtils.i(mTagActivity);
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        LogUtils.i(mTagActivity);
    }

    @Override
    public void onTrimMemory(int level) {
        super.onTrimMemory(level);
        LogUtils.i(mTagActivity, "level=", level);
    }

    @Override
    public void onContentChanged() {
        super.onContentChanged();
        LogUtils.i(mTagActivity);
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        LogUtils.i(mTagActivity, intent);
    }

    @Override
    public void onUserInteraction() {
        super.onUserInteraction();
        LogUtils.i(mTagActivity);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        LogUtils.i(mTagActivity);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        LogUtils.i(mTagActivity);
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
        LogUtils.i(mTagActivity);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        LogUtils.i(mTagActivity);
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onRestoreInstanceState(savedInstanceState, persistentState);
        LogUtils.i(mTagActivity);
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        LogUtils.i(mTagActivity, hasFocus);
    }

    @Override
    public void onWindowAttributesChanged(WindowManager.LayoutParams params) {
        super.onWindowAttributesChanged(params);
        LogUtils.i(mTagActivity, params);
    }

    @Override
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        LogUtils.i(mTagActivity);
    }

    @Override
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        LogUtils.i(mTagActivity);
    }

    @Override
    public void onAttachFragment(Fragment fragment) {
        super.onAttachFragment(fragment);
        LogUtils.i(mTagActivity, fragment);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        LogUtils.i(mTagActivity, event);
        return super.onTouchEvent(event);
    }

    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {
        LogUtils.i(mTagActivity, event);
        return super.dispatchKeyEvent(event);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        LogUtils.i(mTagActivity, event);
        return super.dispatchTouchEvent(event);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        LogUtils.i(mTagActivity, event);
        return super.onKeyDown(keyCode, event);
    }

    @Override
    public void onBackPressed() {
        LogUtils.i(mTagActivity);
        super.onBackPressed();
    }

    @Override
    public void finish() {
        LogUtils.i(mTagActivity);
        super.finish();
    }

}
