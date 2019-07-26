package ysn.com.statusbarutils.app;

import android.app.Application;

import ysn.com.statusbarutils.utils.ResUtils;

/**
 * @Author yangsanning
 * @ClassName MyApplication
 * @Description 一句话概括作用
 * @Date 2019/7/26
 * @History 2019/7/26 author: description:
 */
public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        ResUtils.inject(this);
    }
}
