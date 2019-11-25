package cjx.liyueyun.mvpdemo.main;


import cjx.liyueyun.baselib.base.mvp.BaseEasyPresenter;
import cjx.liyueyun.baselib.base.mvp.okhttp.MyCallBack;
import cjx.liyueyun.baselib.base.mvp.okhttp.MyErrorException;

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
        new MyCallBack<Been>() {

            @Override
            public void onSuccess(Been response) {

            }

            @Override
            public void onError(MyErrorException e) {

            }
        };
        mView.onSuccess(model.getName(age, boy));
    }
}
