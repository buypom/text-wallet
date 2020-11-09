package com.wallet.pojo;

/**
 * @author suone
 * @version 1.0
 * @date 2020/11/6 18:19
 */
public class Result {
    public String code;
    public String message;

    public Result() {
    }

    public Result(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    public static Result ok(String message){
        return new Result("200",message);
    }

    public static Result bad(String message) {
        return new Result("777", message);
    }
}
