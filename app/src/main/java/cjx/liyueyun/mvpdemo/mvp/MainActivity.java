package cjx.liyueyun.mvpdemo.mvp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import cjx.liyueyun.mvpdemo.R;
import cjx.liyueyun.mvpdemo.TestActivity;
import cjx.liyueyun.mvpdemo.base.BaseMvpActivity;

public class MainActivity extends BaseMvpActivity<MainPresenter> implements MainContract.View {


    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void initView() {
        Log.i(TAG, "initView: ");
        TextView tv_text = findViewById(R.id.tv_text);
        tv_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, TestActivity.class));
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
