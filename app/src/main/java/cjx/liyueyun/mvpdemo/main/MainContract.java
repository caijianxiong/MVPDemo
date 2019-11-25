package cjx.liyueyun.mvpdemo.main;


import cjx.liyueyun.baselib.base.mvp.BaseView;

/**
 * @author caicai
 * @create 2019/9/26
 * @Describe  MVP 接口管理类
 */
public interface MainContract {
    interface Model {
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

    interface Presenter{
        void getName(int age, boolean boy);
    }


}
