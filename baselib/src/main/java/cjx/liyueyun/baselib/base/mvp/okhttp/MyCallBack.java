package cjx.liyueyun.baselib.base.mvp.okhttp;

public abstract class MyCallBack<T extends BaseBeen> implements ResponseCallBack<T> {
    @Override
    public void onBefore() {

    }

    @Override
    public void onAfter(T response) {

    }
}
