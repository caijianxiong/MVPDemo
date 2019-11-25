package cjx.liyueyun.mvpdemo.mvp;

import cjx.liyueyun.baselib.base.mvp.BasePresenter;

/**
 * @author caicai
 * @create 2019/11/25
 * @Describe
 */
public class MvpPresenter extends BasePresenter<MvpContract.View, MvpContract.Modle> implements MvpContract.Presenter {
    @Override
    public void getName(int age, boolean boy) {
       String str= mModel.getName(0,false);
       mView.onSuccess(str);
    }
}
