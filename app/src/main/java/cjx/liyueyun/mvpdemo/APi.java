package cjx.liyueyun.mvpdemo;

import cjx.liyueyun.baselib.base.mvp.okhttp.MyErrorException;
import cjx.liyueyun.baselib.base.mvp.okhttp.callback.MyCallBack;
import cjx.liyueyun.baselib.base.mvp.okhttp.request.RequestGet;
import cjx.liyueyun.mvpdemo.main.Data;

/**
 * @author caicai
 * @create 2019/11/26
 * @Describe
 */
public class APi {

    public void getUserName(String uid, MyCallBack<Data> callBack) {
       Object tag= new RequestGet<Data>().url("").build().enqueue(callBack);
    }

}
