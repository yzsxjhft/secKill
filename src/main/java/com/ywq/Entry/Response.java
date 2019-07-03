package com.ywq.Entry;

public class Response<T> {
    private int code;
    private String msg;
    private T data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public static Response buildSuccess() {
        Response response = new Response();
        response.setCode(QUERY_SUCCESS);
        return response;
    }

    public static Response buildFail() {
        Response response = new Response();
        response.setCode(QUERY_FAIL);
        return response;
    }

    public static int QUERY_SUCCESS = 200;
    public static int QUERY_FAIL = 400;
}
