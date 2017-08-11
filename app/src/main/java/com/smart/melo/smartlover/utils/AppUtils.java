package com.smart.melo.smartlover.utils;

import android.text.TextUtils;

import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

public class AppUtils {

    private AppUtils(){}

    //参考：http://developer.qiniu.com/docs/v6/api/reference/fop/image/imageview2.html
    @Deprecated // use QiniuUtl instead
    public static String getScaledImageUrl(String baseUrl, int width, int height){
        if(TextUtils.isEmpty(baseUrl)){
            return null;
        }
        return baseUrl + "?imageView2/3/w/" + width + "/h/" + height + "/format/webp";
    }

    public static String getMacAddress(){
        String mac = getMacAddress("wlan");
        if(TextUtils.isEmpty(mac)){
            mac = getMacAddress("eth");
        }
        return mac;
    }

    /**
     * 1.getMacAddress("wlan")  获取无线网卡的mac地址
     * 2.getMacAddress("eth") 获取有线网卡的mac地址
     *
     * @param name
     * @return
     */
    public static String getMacAddress(String name) {
        try {
            Enumeration<NetworkInterface> nis = NetworkInterface.getNetworkInterfaces();
            while (nis.hasMoreElements()) {
                NetworkInterface networkInterface = nis.nextElement();
                byte[] mac = networkInterface.getHardwareAddress();
                if (!networkInterface.getName().startsWith(name) || mac == null) {
                    continue;
                }
                return formatMac(mac);
            }
        } catch (SocketException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static String formatMac(byte[] mac) {
        StringBuilder sb = new StringBuilder();
        for (byte aMac : mac) {
//            String s = Integer.toHexString(aMac & 0xFF);
            String s = parseByte(aMac);
            sb.append(s.length() == 1 ? 0 + s : s);
        }
        return sb.toString().toUpperCase().substring(0, sb.length() - 1);
    }

    private static String parseByte(byte b){
        String s = "00" + Integer.toHexString(b)+":";
        return s.substring(s.length() - 3);
    }
}
