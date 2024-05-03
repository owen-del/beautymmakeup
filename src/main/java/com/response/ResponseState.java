package com.response;

//枚举返回结果状态
public enum  ResponseState {
    SUCCESS(true,10000,"操作成功"),
    LOGIN_SUCCESS(true,2001,"登录成功"),
    JOIN_IN_SUCCESS(true,2002,"注册成功"),
    FAILED(false,4000,"操作失败"),
    ACCOUNT_NOT_LOGIN(false,4002,"账号未登陆"),
    GET_RESOURCE_FAILED(false,4001,"获取资源失败"),
    PERMISSION_DENIED(false,4003,"权限不允许操作"),
    ACCOUNT_DENIED(false,4004,"账号被禁止"),
    LOGIN_FAILED(false,4999,"登录失败"),
    ERROR_404(false,4004,"页面丢失"),
    ERROR_403(false,4005,"权限不足"),
    ERROR_504(false,4006,"系统繁忙，请稍后重试"),
    ERROR_505(false,4007,"请求错误，请检查所提交数据")
    ;



    private boolean success;
    private int code;
    private String message;

    ResponseState(boolean success, int code, String message) {
        this.success = success;
        this.code = code;
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
