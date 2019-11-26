package cjx.liyueyun.mvpdemo.mvp;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import cjx.liyueyun.baselib.base.mvp.BaseMvpActivity;
import cjx.liyueyun.baselib.base.mvp.okhttp.callback.MyCallBack;
import cjx.liyueyun.baselib.base.mvp.okhttp.MyErrorException;
import cjx.liyueyun.mvpdemo.R;
import cjx.liyueyun.mvpdemo.main.Been;
import cjx.liyueyun.mvpdemo.main.Data;

public class MvpActivity extends BaseMvpActivity<MvpPresenter> implements MvpContract.View {



    @Override
    public MvpPresenter initPresenter() {
        presenter = new MvpPresenter();
        presenter.attachView(this);
        presenter.bindModel(new MvpModel());
        return presenter;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_mvp;
    }

    @Override
    public void initView() {

        Button btn = (Button) findViewById(R.id.btn);


        new MyCallBack<Data>() {
            @Override
            public void onSuccess(Data response) {

            }

            @Override
            public void onError(MyErrorException e) {

            }
        };
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                callBack.onSuccess(new Been());
            }
        });

    }

    @Override
    public void initData() {
        presenter.getName(0, false);
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

    @Override
    public void onSuccess(String name) {
        Toast.makeText(this, name, Toast.LENGTH_SHORT).show();
    }
}
