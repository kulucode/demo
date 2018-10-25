package cn.tpson.demo.common.dto;

import java.io.Serializable;

/**
 * Created by Zhangka in 2018/10/24
 */
public class Result<T> implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 8776554973554055003L;

    private boolean success;
    private T result;
    private String message;
    private int code;

    public Result() {
    }

    public Result(boolean success, T result, String message, int code) {
        super();
        this.success = success;
        this.result = result;
        this.message = message;
        this.code = code;
    }

    public static <T> Result<T> successResult() {
        return new Result<>(true, null, "成功", 0);
    }

    public static <T> Result<T> successResult(T t) {
        return new Result<>(true, t, "成功", 0);
    }

    public static <T> Result<T> failResult(String message) {
        return new Result<>(false, null, message, -1);
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
