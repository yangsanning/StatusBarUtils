package ysn.com.statusbarutils.utils;

/**
 * @Author yangsanning
 * @ClassName DeviceUtils
 * @Description 一句话概括作用
 * @Date 2019/7/26
 * @History 2019/7/26 author: description:
 */
public class DeviceUtils {

    /**
     * 获取当前手机系统版本号
     */
    public static String getSystemVersion() {
        return android.os.Build.VERSION.RELEASE;
    }

    /**
     * 获取手机型号
     */
    public static String getSystemModel() {
        return android.os.Build.MODEL;
    }

    /**
     * 获取手机厂商
     */
    public static String getDeviceBrand() {
        return android.os.Build.BRAND;
    }
}
