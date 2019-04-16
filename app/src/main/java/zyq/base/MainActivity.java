package zyq.base;

import android.os.Bundle;
import android.view.View;

import com.zyq.library.activity.BaseActivity;
import com.zyq.library.util.LogUtils;

public class MainActivity extends BaseActivity {


    @Override
    protected int getContentView() {
        return R.layout.activity_main;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        findViewById(R.id.fab).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LogUtils.d("MainActivity OnClickListener");
            }
        });
    }
}
