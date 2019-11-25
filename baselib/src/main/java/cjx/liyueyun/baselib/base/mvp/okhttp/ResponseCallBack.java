package cjx.liyueyun.baselib.base.mvp.okhttp;

/**
 * @author caicai
 * @create 2019/11/25
 * @Describe
 */
public interface ResponseCallBack<T extends BaseBeen> {

    abstract void onSuccess(T response);

}
