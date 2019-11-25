package cjx.liyueyun.baselib.base.mvp.okhttp;

/**
 * @author caicai
 * @create 2019/11/25
 * @Describe
 */
public interface ResponseCallBack<T> {

    abstract void onBefore();

    abstract void onSuccess(T response);

    abstract void onAfter(T response);

    abstract void onError(MyErrorException e);

}