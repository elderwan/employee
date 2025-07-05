package com.elderwan.employee.utils;

import com.elderwan.employee.exception.EmployeeException;
import io.micrometer.common.util.StringUtils;
import org.springframework.util.CollectionUtils;

import java.util.Collection;
import java.util.Objects;
import java.util.function.Supplier;

public class ParamsCheckUtils {


    /**
     * 是否是空
     *
     * @param val 验证值
     * @param msg 错误信息
     */
    public static void isNull(String val, String msg) {
        if (StringUtils.isBlank(val)) {
            throw new EmployeeException(msg);
        }
    }

    /**
     * 是否是空
     *
     * @param val 验证值
     * @param msg 错误信息
     */
    public static void isNull(Object val, String msg) {
        if (Objects.isNull(val)) {
            throw new EmployeeException(msg);
        }
    }

    /**
     * 是否是空
     *
     * @param val 验证值
     * @param msg 错误信息
     */
    public static void isNull(Collection<?> val, String msg) {
        if (CollectionUtils.isEmpty(val)) {
            throw new EmployeeException(msg);
        }
    }

    /**
     * 判断方法
     *
     * @param isTrue       是否为true
     * @param errorMessage 为true的异常信息
     */
    public static void isTrue(boolean isTrue, String errorMessage) {
        if (isTrue) {
            throw new EmployeeException(errorMessage);
        }
    }

    public static void isTrue(boolean isTrue, Supplier<String> stringSupplier) {
        if (isTrue) {
            throw new EmployeeException(stringSupplier.get());
        }
    }
    /**
     * 未登录异常
     *
     * @param isTrue       是否为true
     *
     */



    /**
     * 判断方法
     *
     * @param isFalse      是否为flase
     * @param errorMessage 为true的异常信息
     */
    public static void isFalse(boolean isFalse, String errorMessage) {
        if (!isFalse) {
            throw new EmployeeException(errorMessage);
        }
    }

    public static void isFalse(boolean isFalse, Supplier<String> stringSupplier) {
        if (isFalse) {
            throw new EmployeeException(stringSupplier.get());
        }
    }
}