package com.zyq.library.activity.permission;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;

import com.zyq.library.R;
import com.zyq.library.activity.LogActivity;

import java.util.List;


/**
 * @author zhuyunqi
 */
public class PermissionActivity extends LogActivity implements EasyPermissions.PermissionCallbacks {

    protected static final int RC_PERM = 123;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }


    /**
     * 权限回调接口
     */
    private CheckPermListener mListener;

    public interface CheckPermListener {
        /**
         * 权限通过后的回调方法
         */
        void superPermission();
    }

    public void checkPermission(CheckPermListener listener, int resString, String... mPerms) {
        mListener = listener;
        if (EasyPermissions.hasPermissions(this, mPerms)) {
            if (mListener != null) {
                mListener.superPermission();
            }
        } else {
            EasyPermissions.requestPermissions(this, getString(resString), RC_PERM, mPerms);
        }
    }

    /**
     * 用户权限处理,
     * 如果全部获取, 则直接过.
     * 如果权限缺失, 则提示Dialog.
     *
     * @param requestCode  请求码
     * @param permissions  权限
     * @param grantResults 结果
     */
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        EasyPermissions.onRequestPermissionsResult(requestCode, permissions, grantResults, this);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == EasyPermissions.SETTINGS_REQ_CODE) {
            //设置返回
        }
    }


    @Override
    public void onPermissionsGranted(int requestCode, List<String> perms) {
        //同意了某些权限可能不是全部
    }

    @Override
    public void onPermissionsAllGranted() {
        if (mListener != null) {
            mListener.superPermission();//同意了全部权限的回调
        }
    }

    @Override
    public void onPermissionsDenied(int requestCode, List<String> perms) {
        EasyPermissions.checkDeniedPermissionsNeverAskAgain(this, getString(R.string.perm_tip),
                R.string.setting, R.string.cancel, null, perms);
    }


}
