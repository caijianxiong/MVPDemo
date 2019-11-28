package cjx.liyueyun.mvpdemo.main;

import android.Manifest;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.File;
import java.util.List;

import cjx.liyueyun.baselib.base.mvp.BaseEasyMvpActivity;
import cjx.liyueyun.baselib.base.mvp.LibApplication;
import cjx.liyueyun.baselib.base.mvp.okhttp.MyErrorException;
import cjx.liyueyun.baselib.base.mvp.okhttp.callback.FileCallBack;
import cjx.liyueyun.baselib.base.mvp.okhttp.callback.MyCallBack;
import cjx.liyueyun.mvpdemo.API;
import cjx.liyueyun.mvpdemo.R;
import cjx.liyueyun.mvpdemo.mvp.MvpActivity;

public class MainActivity extends BaseEasyMvpActivity<MainPresenter> implements MainContract.View {


    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void initView() {
        Log.i(TAG, "initView: ");
        TextView tv_text = (TextView) findViewById(R.id.tv_text);
        Button btn= (Button) findViewById(R.id.btn);
        tv_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                startActivity(new Intent(MainActivity.this, TestActivity.class));
                API.getUserName("https://www.baidu.com/", new MyCallBack<String>() {
                    @Override
                    public void onSuccess(String response) {
                        Log.i(TAG, "onSuccess: "+LibApplication.getmGson().toJson(response));
                    }

                    @Override
                    public void onError(MyErrorException e) {
                        Log.i(TAG, "onError: "+e.getMessage());
                    }
                });

                API.downImg("", new FileCallBack("","") {
                    @Override
                    public void onProgress(float progress, float total) {
                        super.onProgress(progress, total);
                    }

                    @Override
                    public void onSuccess(File response) {

                    }

                    @Override
                    public void onError(MyErrorException e) {

                    }
                });

            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, MvpActivity.class));
            }
        });
    }

    @Override
    public MainPresenter initPresenter() {
        Log.i(TAG, "initPresenter: ");
        presenter = new MainPresenter();
        presenter.attachView(this);
        return presenter;
    }

    @Override
    public void initData() {

        requestRunTimePermission(new String[]{Manifest.permission.READ_PHONE_STATE}, new PermissionListener() {
            @Override
            public void onGranted() {
                Log.i(TAG, "onGranted: 权限拒绝");
            }

            @Override
            public void onGranted(List<String> grantedPermission) {
                Log.i(TAG, "onGranted: 权限通过");

            }

            @Override
            public void onDenied(List<String> deniedPermission) {

            }
        });

        Log.i(TAG, "initData: ");
        presenter.getName(200, true);//调用
    }

    @Override
    public void onSuccess(String name) {//结果回调
        Log.i(TAG, "onSuccess: " + name);
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void onError(Throwable throwable) {

    }
}
