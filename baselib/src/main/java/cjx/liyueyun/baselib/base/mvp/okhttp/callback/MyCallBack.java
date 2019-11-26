package cjx.liyueyun.baselib.base.mvp.okhttp.callback;

import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.util.Date;

import cjx.liyueyun.baselib.base.mvp.LibApplication;
import cjx.liyueyun.baselib.base.mvp.okhttp.MyErrorException;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * @author caicai
 * @create 2019/11/26
 * @Describe
 */
public abstract class MyCallBack<T> implements  ICallback<T> {

    @Override
    public void onBefore() {

    }

    @Override
    public void onAfter(T response) {

    }

}
