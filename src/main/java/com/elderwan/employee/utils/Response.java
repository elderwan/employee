package com.elderwan.employee.utils;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Response<T> {

    int code;
    String msg;
    T data;

    public static Response<Object> ok() {
        return Response.builder().code(Code.SUCCESS).build();
    }


    public static Response<Object> okMsg(String msg) {
        return Response.builder().code(Code.SUCCESS).msg(msg).build();
    }

    public static <T> Response<T> ok(T data) {
        return (Response<T>) Response.builder().code(Code.SUCCESS).data(data).msg(Msg.SUCCESS).build();
    }

    public static Response<Object> failed(String msg) {
        return Response.builder().code(Code.FAILED).msg(msg).build();
    }

    @JsonIgnore
    public boolean isOk() {
        return code == Code.SUCCESS;
    }

    @JsonIgnore
    public boolean isFailed() {
        return code == Code.FAILED;
    }

    /**
     * @author changle
     */
    public static class Code {
        public static final int SUCCESS = 200;
        public static final int FAILED = 500;
        /**
         * 未登录
         */
        public static final int NOT_LOGIN = 300;
        /**
         * 未注册
         */
        public static final int NOT_REGISTER = 302;
    }

    /**
     * @author changle
     */
    public static class Msg {
        public static final String SUCCESS = "success！";
        public static final String FAILED = "fail！";
        /**
         * 错误信息：内部异常
         */
        public static final String ERROR = "error！";
        public static final String THROWABLE = "system error！";
        /**
         * 错误信息：重复操作
         */
        public static final String REPEAT_ERROR = "pls no repeat！";
    }
}
