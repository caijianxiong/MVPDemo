package cjx.liyueyun.mvpdemo.mvp;

import cjx.liyueyun.baselib.base.mvp.BasModel;
import cjx.liyueyun.baselib.base.mvp.BaseView;

/**
 * @author caicai
 * @create 2019/11/25
 * @Describe
 */
public interface MvpContract {

    interface Modle extends BasModel {
        //mode methods
        String getName(int age, boolean boy);
    }

    interface View extends BaseView {

        @Override
        void showLoading();

        @Override
        void hideLoading();

        @Override
        void onError(Throwable throwable);

        void onSuccess(String name);
    }

    interface Presenter  {
        void getName(int age, boolean boy);
    }

}
