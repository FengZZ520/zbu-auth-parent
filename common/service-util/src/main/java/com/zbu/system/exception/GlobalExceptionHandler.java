package com.zbu.system.exception;

import com.zbu.common.result.Result;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * ClassName: GlobalExceptionHandler
 * Package: com.zbu.system.exception
 * Description:
 *
 * @Author: 冯振卓
 * @Create: 2023/2/23 - 18:25
 * @Version: v1.0
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    //1.全局异常处理
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Result error(Exception e) {
        e.printStackTrace();
        return Result.fail().message("执行了全局异常处理");
    }

    //2.特定异常处理
    @ExceptionHandler(ArithmeticException.class)
    @ResponseBody
    public Result error(ArithmeticException e) {
        e.printStackTrace();
        return Result.fail().message("执行了特定异常处理");
    }

    //3.自定义异常处理
    @ExceptionHandler(ZBUException.class)
    @ResponseBody
    public Result error(ZBUException e) {
        e.printStackTrace();
        return Result.fail().code(e.getCode()).message(e.getMsg());
    }
}
