package cjx.liyueyun.mvpdemo.mvp;

import android.widget.Toast;

import cjx.liyueyun.baselib.base.mvp.BaseMvpActivity;
import cjx.liyueyun.mvpdemo.R;

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
