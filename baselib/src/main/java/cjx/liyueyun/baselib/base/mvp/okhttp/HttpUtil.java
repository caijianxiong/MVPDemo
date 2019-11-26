package cjx.liyueyun.baselib.base.mvp.okhttp;

import android.provider.ContactsContract;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

import cjx.liyueyun.baselib.base.mvp.okhttp.base.BaseHttpRequest;
import cjx.liyueyun.baselib.base.mvp.okhttp.request.RequestGet;
import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;

/**
 * @author caicai
 * @create 2019/11/26
 * @Describe
 */
public class HttpUtil {
    private static OkHttpClient mOkHttpClient;
    private static HttpUtil mInstance;

    private HttpUtil() {
        //添加cookie
        mOkHttpClient = new OkHttpClient.Builder()
                .connectTimeout(10000L, TimeUnit.MILLISECONDS)
                .readTimeout(10000L, TimeUnit.MILLISECONDS)
//                .addInterceptor(new LoggerInterceptor("TAG", true))
                .hostnameVerifier(new HostnameVerifier() {
                    @Override
                    public boolean verify(String hostname, SSLSession session) {
                        return true;
                    }
                })
//                .sslSocketFactory(sslParams.sSLSocketFactory, sslParams.trustManager)
                .build();
    }

    public static HttpUtil getInstance() {
        if (mInstance == null) {
            synchronized (HttpUtil.class) {
                if (mInstance == null)
                    mInstance = new HttpUtil();
            }
        }
        return mInstance;
    }

    public OkHttpClient getOkHttpClient() {
        return mOkHttpClient;
    }

}
