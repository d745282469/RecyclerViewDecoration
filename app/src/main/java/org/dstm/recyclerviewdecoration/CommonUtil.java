package org.dstm.recyclerviewdecoration;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.util.DisplayMetrics;
import android.view.ViewGroup;
import android.view.WindowManager;

import java.util.List;

/**
 * @author pd
 * time     2019/4/7 11:28
 * 一些无法分类的工具
 */
public class CommonUtil {
    /**
     * 设置屏幕的背景透明度
     *
     * @param bgAlpha 屏幕透明度0.0-1.0 1表示完全不透明
     */
    public static void setBackgroundAlpha(float bgAlpha, Context mContext) {
        WindowManager.LayoutParams lp = ((Activity) mContext).getWindow()
                .getAttributes();
        lp.alpha = bgAlpha;
        ((Activity) mContext).getWindow().setAttributes(lp);
    }

    /**
     * 获取WIFI_ssid也就是WIFI的名称
     * 需要权限：ACCESS_NETWORK_STATE，ACCESS_FINE_LOCATION，ACCESS_COARSE_LOCATION，CHANGE_WIFI_STATE
     *
     * @param context 上下文
     * @return WIFI 的SSID
     */
    public static String GetWIFISSID(Context context) {
        String ssid = "";
        if (context != null) {
            WifiManager wifiManager = (WifiManager) context.getApplicationContext().getSystemService(Context.WIFI_SERVICE);
            WifiInfo wifiInfo = wifiManager.getConnectionInfo();

            if (wifiInfo != null) {
                ssid = wifiInfo.getSSID();//获取到的SSID可能带双引号，所以要去掉
                if (ssid.substring(0, 1).equals("\"") && ssid.substring(ssid.length() - 1).equals("\"")) {
                    ssid = ssid.substring(1, ssid.length() - 1);
                }
            }
        }
        return ssid;
    }

    /**
     * 获取屏幕宽高
     *
     * @param context 用来获取Resource的上下文环境
     * @return 数组，[宽度，高度]，单位px
     */
    public static int[] getScreenWH(Context context) {
        Resources resources = context.getResources();
        DisplayMetrics dm = resources.getDisplayMetrics();
//        float density = dm.density;//密度
        int width = dm.widthPixels;
        int height = dm.heightPixels;
        return new int[]{width, height};
    }
}
