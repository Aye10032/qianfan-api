package com.aye10032.qianfanapi.data;


import lombok.Getter;

/**
 * @program: rtroapi
 * @className: ResultCode
 * @Description: 响应码
 * @version: v1.0
 * @author: Aye10032
 * @date: 2021/7/14 下午 5:05
 */
@Getter
public enum ResultCode {

    SUCCESS(1000, "操作成功"),
    FAILED(1001, "响应失败"),
    VALIDATE_FAILED(1002, "参数校验失败"),
    ERROR(5000, "未知错误");

    private int code;
    private String msg;

    ResultCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
