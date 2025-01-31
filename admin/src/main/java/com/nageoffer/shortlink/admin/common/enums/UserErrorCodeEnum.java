package com.nageoffer.shortlink.admin.common.enums;

import com.nageoffer.shortlink.admin.common.convention.errcode.IErrorCode;

public enum UserErrorCodeEnum implements IErrorCode {

    USER_NULL("B000200","用户记录不存在"),

    USER_NAME_EXIST("B000201","用户名已存在"),

    USER_EXIST("B000202","用户记录已存在"),

    USER_SAVE_ERROR("B000203","用户记录新增失败"),

    USER_LOGIN_ERROR("B000204","用户登录失败"),

    USER_HAS_LOGIN("B000205","用户已登录"),

    USER_LOGOUT_ERROR("B000206","用户Token不存在或者用户未登录"),

    USER_UPDATE_ERROR("B000207","用户记录更新失败");

    private final String code;

    private final String message;

    UserErrorCodeEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public String code() {
        return code;
    }

    @Override
    public String message() {
        return message;
    }
}
