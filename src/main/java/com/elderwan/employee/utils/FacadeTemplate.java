package com.elderwan.employee.utils;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.function.Supplier;

@Slf4j
public class FacadeTemplate {


    /**
     * 模版方法
     *
     * @param result         返回结果
     * @param facadeCallBack 执行方法
     */
    public static void template(Response result, FacadeCallBack facadeCallBack) {
        try {
            // 参数校验
            facadeCallBack.checkout();

            // 业务逻辑执行
            facadeCallBack.process();
            result.setCode(Response.Code.SUCCESS);
            result.setMsg(Response.Msg.SUCCESS);
        } catch (EmployeeException e) {
            result.setCode(Response.Code.FAILED);
            result.setMsg(e.getMessage());
            e.printStackTrace();
        } catch (RuntimeException e) {
            result.setCode(Response.Code.FAILED);
            result.setMsg(Response.Msg.ERROR);
            e.printStackTrace();
        } catch (Throwable e) {
            result.setCode(Response.Code.FAILED);
            result.setMsg(Response.Msg.THROWABLE);
            e.printStackTrace();
        }
    }

    /**
     * 模版方法
     *
     * @param dto            参数
     * @param facadeCallBack 执行方法
     * @return 统一返回
     */
//     public static Response template(IDTO dto, Function<IDTO, Response> facadeCallBack) {
//         Response response;
//         List<String> methodList;
//         try {
//             dto.checkout();
//             response = facadeCallBack.apply(dto);
//             return response;
//         } catch (EmployeeException e) {
//             e.printStackTrace();
// //            methodList = EmployeeException.changleMethod(e);
//             log.info("\n 【接口请求异常】 \n 【请求方法】:\n {} \n 【参数】: {} \n 【异常信息】: {} ", String.join("\n ", e.getMethodAddressList()), dto, e.getMessage());
// //            log.info("\n 【接口请求异常】 \n 【请求方法】:\n {} \n 【参数】: {} \n 【异常信息】: ", String.join("\n ", methodList), dto, e);
//             response = e.toResponse();
//         } catch (RuntimeException e) {
//             methodList = EmployeeException.changleMethod(e);
//             log.info("\n 【接口请求异常】 \n 【请求方法】:\n {} \n 【参数】: {} \n 【异常信息】: ", String.join("\n ", methodList), dto, e);
//             response = Response.failed(Response.Msg.ERROR);
//         } catch (Throwable e) {
//             log.info("\n 【接口请求异常】 \n 【请求方法】: {} \n 【参数】: {} \n 【异常信息】: ", facadeCallBack, dto, e);
//             response = Response.failed(Response.Msg.THROWABLE);
//         }
//         return response;
//     }

    public static <OUT> Response template(Supplier<OUT> facadeCallBack) {
        Response response;
        try {
            OUT out = facadeCallBack.get();
            if (out instanceof Response) {
                response = (Response) out;
            } else {
                response = Response.ok(out);
            }
        } catch (EmployeeException e) {
            e.printStackTrace();
            response = Response.failed(e.getMessage());
        } catch (RuntimeException e) {
            e.printStackTrace();
            response = Response.failed(Response.Msg.ERROR);
        } catch (Throwable e) {
            e.printStackTrace();
            response = Response.failed(Response.Msg.THROWABLE);
        }
        return response;
    }

}