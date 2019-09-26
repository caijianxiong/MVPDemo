package cjx.liyueyun.mvpdemo.mvp;

/**
 * @author caicai
 * @create 2019/9/26
 * @Describe
 */
public class MainModel implements MainContract.Modle {
    @Override
    public String getName(int age, boolean boy) {
        String name;
        if (age > 100 && boy) {
            name = "tom";
        } else {
            name = "tim";
        }
        return name;
    }
}
