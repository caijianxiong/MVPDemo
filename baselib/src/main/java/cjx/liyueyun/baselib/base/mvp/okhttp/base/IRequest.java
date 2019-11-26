package cjx.liyueyun.baselib.base.mvp.okhttp.base;

import java.util.Map;

import okhttp3.Request;

/**
 * @author caicai
 * @create 2019/11/26
 * @Describe
 */
public interface IRequest<T> {

    abstract IRequest header(String key, String value);

    abstract IRequest header(Map<String, String> map);

    abstract IRequest addParam(String key, String value);
    abstract IRequest addParams(Map<String, String> map);

    abstract IRequest url(String url);

    abstract IRequestCall<T> build();

    Request buildRequest();

    abstract IRequest tag(Object tag);

}
