package com.wisezone.vo;

public class DataVo {
    public static final Integer SUCCESS = 200;
    public static final Integer ERROR = 400;

    private String msg;
    private Object data;
    /*
    * 200:成功
    * 400：错误
    * */
    private Integer code;

    public DataVo() {
    }

    public DataVo(String msg, Object data, Integer code) {
        this.msg = msg;
        this.data = data;
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
