package com.zyq.library.fragment;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;

import com.zyq.library.util.LogUtils;

/**
 * @author: zhu yun qi
 * @mail: zhuyunqi_88@163.com
 * @date: 2018/3/14
 * @describe:
 */
public class LogFragment extends Fragment {

    public String TAG_FRAGMENT;

    public LogFragment() {
        TAG_FRAGMENT = this.getClass().getSimpleName() + "[" + hashCode() + "]";
        LogUtils.v(TAG_FRAGMENT);
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        LogUtils.v(TAG_FRAGMENT, "hidden=", hidden, "isVisible=", isVisible(), "isHidden=", isHidden());
    }

    @Override
    public void onInflate(Context context, AttributeSet attrs, Bundle savedInstanceState) {
        super.onInflate(context, attrs, savedInstanceState);
        LogUtils.v(TAG_FRAGMENT);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        LogUtils.v(TAG_FRAGMENT);
    }

    @Override
    public Animation onCreateAnimation(int transit, boolean enter, int nextAnim) {
        LogUtils.v(TAG_FRAGMENT);
        return super.onCreateAnimation(transit, enter, nextAnim);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LogUtils.v(TAG_FRAGMENT);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        LogUtils.v(TAG_FRAGMENT);
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        LogUtils.v(TAG_FRAGMENT);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        LogUtils.v(TAG_FRAGMENT);
    }

    @Override
    public void onViewStateRestored(Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
        LogUtils.v(TAG_FRAGMENT);
    }

    @Override
    public void onStart() {
        super.onStart();
        LogUtils.v(TAG_FRAGMENT, "isVisible=", isVisible(), "isHidden=", isHidden());
    }

    @Override
    public void onResume() {
        super.onResume();
        LogUtils.v(TAG_FRAGMENT, "isVisible=", isVisible(), "isHidden=", isHidden());
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        LogUtils.v(TAG_FRAGMENT);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        LogUtils.v(TAG_FRAGMENT);
    }

    @Override
    public void onPause() {
        super.onPause();
        LogUtils.v(TAG_FRAGMENT, "isVisible=", isVisible(), "isHidden=", isHidden());
    }

    @Override
    public void onStop() {
        super.onStop();
        LogUtils.v(TAG_FRAGMENT, "isVisible=", isVisible(), "isHidden=", isHidden());
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        LogUtils.v(TAG_FRAGMENT);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        LogUtils.v(TAG_FRAGMENT);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        LogUtils.v(TAG_FRAGMENT);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        LogUtils.v(TAG_FRAGMENT);
    }
}
