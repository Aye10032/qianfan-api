package com.aye10032.qianfanapi.data;


import lombok.Getter;

/**
 * @program: rtroapi
 * @className: ResultVO
 * @Description: 返回体
 * @version: v1.0
 * @author: Aye10032
 * @date: 2021/7/14 下午 5:03
 */
@Getter
public class ResultVO<T> {

    private int code;
    private String msg;
    private T data;

    public ResultVO(T data) {
        this(ResultCode.SUCCESS, data);
    }

    public ResultVO(ResultCode resultCode, T data) {
        this.code = resultCode.getCode();
        this.msg = resultCode.getMsg();
        this.data = data;
    }
}
