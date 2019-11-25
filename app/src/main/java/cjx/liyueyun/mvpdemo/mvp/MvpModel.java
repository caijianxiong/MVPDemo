package cjx.liyueyun.mvpdemo.mvp;

import cjx.liyueyun.mvpdemo.main.MainContract;

/**
 * @author caicai
 * @create 2019/9/26
 * @Describe
 */
public class MvpModel implements MvpContract.Modle {
    @Override
    public String getName(int age, boolean boy) {
        return "这是我model返回出去的字符串";
    }
}
