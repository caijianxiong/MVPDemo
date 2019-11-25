package cjx.liyueyun.mvpdemo.main;


import cjx.liyueyun.baselib.base.mvp.BaseEasyPresenter;

/**
 * @author caicai
 * @create 2019/9/26
 * @Describe
 */
public class MainPresenter extends BaseEasyPresenter<MainContract.View> implements MainContract.Presenter {

    private MainModel model;

    public MainPresenter() {
        model = new MainModel();
    }


    @Override
    public void getName(int age, boolean boy) {
        mView.onSuccess(model.getName(age, boy));
    }
}
