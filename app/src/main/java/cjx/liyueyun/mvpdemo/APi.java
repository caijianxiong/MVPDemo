package cjx.liyueyun.mvpdemo;

import java.io.File;

import cjx.liyueyun.baselib.base.mvp.okhttp.callback.FileCallBack;
import cjx.liyueyun.baselib.base.mvp.okhttp.callback.MyCallBack;
import cjx.liyueyun.baselib.base.mvp.okhttp.request.HttpGet;
import cjx.liyueyun.baselib.base.mvp.okhttp.request.HttpPost;
import okhttp3.HttpUrl;

/**
 * @author caicai
 * @create 2019/11/26
 * @Describe
 */
public class API {

    public static void getUserName(String url, MyCallBack<String> callBack) {
        if (HttpUrl.parse(url) == null) return;
        Object tag = new HttpGet<String>().get().url(url).header("key01", "value01").addParam("param01Key", "param01Value").build().enqueue(callBack);
    }

    public static void downImg(String url, FileCallBack callBack) {
        Object tag = new HttpGet<File>().get().url(url).header("key01", "value01").addParam("param01Key", "param01Value").build().enqueue(callBack);
    }

    public static void postForm(String url, MyCallBack<String> callBack) {
        Object tag = new HttpPost<String>().post().addParam("key", "value").header("header", "adasd").build().enqueue(callBack);
    }


}
