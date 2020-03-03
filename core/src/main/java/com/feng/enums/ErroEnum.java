package com.feng.enums;

import com.feng.error.CommonError;

/**
 * Created by rf on 2019/3/10.
 */
public enum ErroEnum implements CommonError {
    UN_KNOW_EXCEPTION(1001, "系统繁忙，请稍后访问！"),
    INVALIDATE_PARAM_EXCEPTION(2001, "参数异常！"),
    USER_NAME_ERROR(3002, "用户名错误！"),
    USER_RE_PASSWORD_ERROR(3002, "两次输入密码不一致！"),
    USER_PASSWORD_ERROR(3003, "用户密码错误！"),
    USER_CODE_ERROR(3004, "验证码错误！"),
    USER_NOT_LOGIN(3005, "请先登录！"),
    FILE_NULL(4001,"选择上传文件"),
    FALE_UPLOAD_FAIL(4002,"上传文件失败"),
    FILE_FORMAT_ERROR(4003,"文件格式错误"),
    BUSINESS_EXCEPTION(4010,"业务异常");

    private int code;
    private String msg;

    ErroEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public ErroEnum setMsg(String msg) {
        this.msg = msg;
        return this;
    }

    @Override
    public int getCode() {
        return code;
    }

    @Override
    public String getMsg() {
        return msg;
    }

}

