package com.example.demo.domain.vo;

import lombok.Data;

/**
 * @author CYF02
 */
@Data
public class Result<T> {
    private String msg;
    private Boolean state=true;
    private Object result;
private Integer code;

    public static Result<Object> ok() {
        Result<Object> r = new Result<Object>();
        r.setCode(CommonConstant.SC_OK_200);
        return r;
    }
    public static Result<Object> error(String msg) {
        Result<Object> r = new Result<Object>();
        r.setCode(CommonConstant.SC_OK_200);
        r.setResult(false);
        r.setMsg(msg);
        return r;
    }
    public static Result<Object> error(Integer Code,String msg) {
        Result<Object> r = new Result<Object>();
        r.setCode(Code);
        r.setResult(false);
        r.setMsg(msg);
        return r;
    }
    public static Result<Object> ok(Object data) {
        Result<Object> r = new Result<Object>();
        r.setResult(data);
        r.setCode(CommonConstant.SC_OK_200);
        return r;
    }
    public static Result<Object> ok(String msg,Object data) {
        Result<Object> r = new Result<Object>();
        r.setResult(data);
        r.setCode(CommonConstant.SC_OK_200);
        r.setMsg(msg);
        return r;
    }
    public static Result<Object> ok(String msg) {
        Result<Object> r = new Result<Object>();
        r.setMsg(msg);
        r.setCode(CommonConstant.SC_OK_200);
        return r;
    }
}
