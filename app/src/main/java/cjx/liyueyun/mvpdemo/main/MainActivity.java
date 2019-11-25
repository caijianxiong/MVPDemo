package cjx.liyueyun.mvpdemo.main;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import cjx.liyueyun.baselib.base.mvp.BaseEasyMvpActivity;
import cjx.liyueyun.mvpdemo.R;
import cjx.liyueyun.mvpdemo.TestActivity;
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
                startActivity(new Intent(MainActivity.this, TestActivity.class));
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
