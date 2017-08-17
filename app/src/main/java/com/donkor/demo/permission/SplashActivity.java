package com.donkor.demo.permission;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Toast;
/**
 * @author Donkor
 * 关于我：
 * CSDN博客：http://blog.csdn.net/donkor_
 * Android开发交流QQ群：537891203
 * 邮箱：donkor@yeah.net
 */
public class SplashActivity extends BaseActivity implements View.OnClickListener {

    private Handler mHandler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        findViewById(R.id.btn_request_permission).setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        requestPermissions(this, new String[]{Manifest.permission.RECORD_AUDIO,
                        Manifest.permission.CAMERA,
                        Manifest.permission.READ_EXTERNAL_STORAGE},
                new RequestPermissionCallBack() {
                    @Override
                    public void granted() {
                        Toast.makeText(SplashActivity.this, "权限获取成功，执行下一步操作", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                        startActivity(intent);
                        SplashActivity.this.finish();
                    }

                    @Override
                    public void denied() {
                        Toast.makeText(SplashActivity.this, "部分权限获取失败，正常功能受到影响,2秒钟之后自动退出", Toast.LENGTH_LONG).show();
                        //2秒钟之后自动退出
                        mHandler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                SplashActivity.this.finish();
                            }
                        }, 2000);
                    }
                });
    }
}
