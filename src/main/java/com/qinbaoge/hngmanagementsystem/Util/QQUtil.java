package com.qinbaoge.hngmanagementsystem.Util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.qinbaoge.hngmanagementsystem.Entity.QQ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class QQUtil {
    private static String getQQJsonStr(String qqId) {
        StringBuilder jsonString = new StringBuilder();
        URLConnection connection = null;
        try {
            URL urlObject = new URL("https://r.qzone.qq.com/fcg-bin/cgi_get_portrait.fcg?g_tk=&uins="+qqId);
            connection = urlObject.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream(),"GBK"));
            String inputLine = null;
            while ((inputLine = in.readLine()) != null) {
                jsonString.append(inputLine);
            }
            in.close();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return jsonString.toString().substring("portraitCallBack(".length(),jsonString.length()-1);
    }
    public static QQ getQQInfo(String qqId) {
        QQ qq = new QQ();
        String jsonString = getQQJsonStr(qqId);
        JSONObject jsonObject = JSON.parseObject(jsonString);
        JSONArray jsonArray = jsonObject.getJSONArray(String.valueOf(qqId));
        qq.setId(qqId);
        qq.setName((String) jsonArray.get(6));
        qq.setAvatar((String) jsonArray.get(0));
        return qq;
    }
}