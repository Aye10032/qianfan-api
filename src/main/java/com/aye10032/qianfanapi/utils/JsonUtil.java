package com.aye10032.qianfanapi.utils;

import com.aye10032.qianfanapi.data.ResultVO;
import com.google.gson.Gson;

import java.lang.reflect.Type;
import java.util.List;

/**
 * @program: rtroapiutil
 * @className: JSONUtil
 * @Description: json相关工具类
 * @version: v1.0
 * @author: Aye10032
 * @date: 2021/7/15 下午 3:49
 */
public class JsonUtil {

    public static String entity2json(Object data){
        Gson gson = new Gson();

        return gson.toJson(data);
    }

    public static <T> ResultVO<T> json2entity(String json, Class<T> clazz){
        Type type = new ParameterizedTypeImpl(ResultVO.class, new Class[]{clazz});
        Gson gson = new Gson();
        return gson.fromJson(json, type);
    }

    public static <T> ResultVO<List<T>> json2entityList(String json, Class<T> clazz){
        Type listType = new ParameterizedTypeImpl(List.class, new Class[]{clazz});
        Type type = new ParameterizedTypeImpl(ResultVO.class, new Type[]{listType});
        Gson gson = new Gson();
        return gson.fromJson(json, type);
    }

}
