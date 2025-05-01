package com.se.unit5;

/**
 * @author LTMAX
 * @date 2023/9/14 15:58
 * @description: TODO
 */
public enum ExceptionCode {

    /**
     * 自定义异常
     */
    TEST("自定义异常信息");

    /**
     *异常信息
     */
    private final String msg;

    ExceptionCode(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public String getCode() {
        return this.name();
    }
}
