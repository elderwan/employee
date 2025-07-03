package com.elderwan.employee.utils;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
public class EmployeeException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    /**
     * 方法地址
     */
    protected List<String> methodAddressList;

    protected String msg;
    protected int code = Response.Code.FAILED;

    public EmployeeException() {
        this.msg = "操作失败";
    }

    public EmployeeException(String msg) {
        super(msg);
        init();
        this.msg = msg;
    }

    public EmployeeException(String msg, Throwable e) {
        super(msg, e);
        init();
        this.msg = msg;
    }

    public EmployeeException(int code, String msg) {
        super(msg);
        init();
        this.msg = msg;
        this.code = code;
    }

    public EmployeeException(int code, String msg, Throwable e) {
        super(msg, e);
        init();
        this.msg = msg;
        this.code = code;
    }

    public Response toResponse() {
        return Response.builder().code(code).msg(msg).build();
    }


    public void init() {
        try {
            methodAddressList = changleMethod(this);
        } catch (Exception ex) {
            // Swallow and continue
        }
    }



    /**
     * 获取报错位置
     *
     * @return 方法
     */
    public static List<String> changleMethod(RuntimeException exception) {
        List<String> methodList = new ArrayList<>();
        try {
            StackTraceElement[] stackTrace = exception.getStackTrace();
            for (StackTraceElement stackTraceElement : stackTrace) {
                if (stackTraceElement.toString().startsWith("changle")) {
                    methodList.add(stackTraceElement.toString());
                }
            }
        } catch (Exception ex) {
            // Swallow and continue
        }
        return methodList;
    }
}