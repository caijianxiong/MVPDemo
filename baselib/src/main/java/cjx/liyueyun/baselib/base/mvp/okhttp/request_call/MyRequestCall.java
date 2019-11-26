package cjx.liyueyun.baselib.base.mvp.okhttp.request_call;

import android.support.annotation.NonNull;

import java.io.IOException;
import java.lang.reflect.ParameterizedType;

import cjx.liyueyun.baselib.base.mvp.LibApplication;
import cjx.liyueyun.baselib.base.mvp.okhttp.HttpUtil;
import cjx.liyueyun.baselib.base.mvp.okhttp.MyErrorException;
import cjx.liyueyun.baselib.base.mvp.okhttp.base.IRequest;
import cjx.liyueyun.baselib.base.mvp.okhttp.base.IRequestCall;
import cjx.liyueyun.baselib.base.mvp.okhttp.callback.ICallback;
import cjx.liyueyun.baselib.base.mvp.okhttp.callback.MyCallBack;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Response;

/**
 * @author caicai
 * @create 2019/11/26
 * @Describe
 */
public class MyRequestCall<T> implements IRequestCall<T> {
    private Object tag;
    private Call call;
    private OkHttpClient httpClient;

    public MyRequestCall(IRequest request) {
        if (httpClient == null)
            httpClient = HttpUtil.getInstance().getOkHttpClient();
        call = httpClient.newCall(request.buildRequest());
        this.tag = call.request().tag();
    }

    @Override
    public Object enqueue(final MyCallBack<T> callback) {
        callback.onBefore();
        call.enqueue(new Callback() {//子线程
            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {
                callback.onError(new MyErrorException(e));
            }

            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                T data = parseNetworkResponse(response);
                callback.onSuccess(data);
                callback.onAfter(data);
            }
        });
        return tag;
    }


    public T parseNetworkResponse(Response response) throws IOException {
        String string = response.body().string();
        Class<T> entityClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        if (entityClass == String.class) {
            return (T) string;
        }
        T bean = LibApplication.getmGson().fromJson(string, entityClass);
        return bean;
    }

}
