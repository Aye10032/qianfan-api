package com.aye10032.qianfanapi.utils;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * @program: rtroapiutil
 * @className: ParameterizedTypeImpl
 * @Description: 泛型解析
 * @version: v1.0
 * @author: Aye10032
 * @date: 2021/7/15 下午 5:50
 */
public class ParameterizedTypeImpl implements ParameterizedType {
    private final Class raw;
    private final Type[] args;
    public ParameterizedTypeImpl(Class raw, Type[] args) {
        this.raw = raw;
        this.args = args != null ? args : new Type[0];
    }
    @Override
    public Type[] getActualTypeArguments() {
        return args;
    }
    @Override
    public Type getRawType() {
        return raw;
    }
    @Override
    public Type getOwnerType() {return null;}
}
