package com.guiguohui.system.common;

import org.springframework.http.HttpStatus;

import java.util.HashMap;

/**
 * @author tu.cb
 */
public class Result extends HashMap<String, Object> {

    private static final long serialVersionUID = 1L;

    private static final String CODE = "code";

    private static final String MSG = "msg";

    private static final String DATA = "data";

    public Result(int code, String msg) {
        super.put(CODE, code);
        super.put(MSG, msg);
    }

    public Result(int code, String msg, Object data) {
        super.put(CODE, code);
        super.put(MSG, msg);
        if(data != null){
            super.put(DATA, data);
        }
    }

    public static Result success() {
        return success("操作成功");
    }

    public static Result success(String msg) {
        return Result.success(msg,null);
    }
    public static Result success(Object data) {
        return Result.success("操作成功",data);
    }
    public static Result success(String msg,Object data) {
        return new Result(HttpStatus.OK.value(),msg,data) ;
    }

    public static Result error() {
        return error("操作失败");
    }

    public static Result error(String msg) {
        return error(msg,null);
    }

    public static Result error(String msg,Object data) {
        return new Result(HttpStatus.INTERNAL_SERVER_ERROR.value(),msg,data);
    }

    public static Result unauthorized(String msg) {
        return new Result(HttpStatus.UNAUTHORIZED.value(),msg);
    }
}
