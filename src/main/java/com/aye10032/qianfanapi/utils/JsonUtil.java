package com.aye10032.qianfanapi.utils;

import com.aye10032.qianfanapi.data.qianfan.ReactiveBody;
import com.google.gson.Gson;

/**
 * @program: rtroapiutil
 * @className: JSONUtil
 * @Description: json相关工具类
 * @version: v1.0
 * @author: Aye10032
 * @date: 2021/7/15 下午 3:49
 */
public class JsonUtil {

    public static String entity2json(Object data) {
        Gson gson = new Gson();

        return gson.toJson(data);
    }

    public static ReactiveBody json2reactiveBody(String jsonString) {
        Gson gson = new Gson();

        return gson.fromJson(jsonString, ReactiveBody.class);
    }

}
