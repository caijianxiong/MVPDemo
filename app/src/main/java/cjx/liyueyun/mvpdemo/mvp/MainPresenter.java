package cjx.liyueyun.mvpdemo.mvp;

import cjx.liyueyun.mvpdemo.base.BasePresenter;

/**
 * @author caicai
 * @create 2019/9/26
 * @Describe
 */
public class MainPresenter extends BasePresenter<MainContract.View> implements MainContract.Presenter {

    private MainModel model;

    public MainPresenter() {
        model = new MainModel();
    }


    @Override
    public void getName(int age, boolean boy) {
        mView.onSuccess(model.getName(age, boy));
    }
}
