package com.youban.freemarker.error;

import com.youban.freemarker.controller.data.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.ConversionNotSupportedException;
import org.springframework.beans.TypeMismatchException;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.io.IOException;

@ControllerAdvice
public class GlobalExceptionHandler {

    private static final String logExceptionFormat = "Capture Exception By GlobalExceptionHandler: Code: %s Detail: %s";
    private static Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    //运行时异常
    @ExceptionHandler(RuntimeException.class)
    public Result runtimeExceptionHandler(RuntimeException ex) {
        return resultFormat(0,"RuntimeException--->>运行时异常!", ex);
    }

    //空指针异常
    @ExceptionHandler(NullPointerException.class)
    public Result nullPointerExceptionHandler(NullPointerException ex) {
        System.err.println("NullPointerException:");
        return resultFormat(2,"NullPointerException--->>空指针异常!", ex);
    }

    //类型转换异常
    @ExceptionHandler(ClassCastException.class)
    public Result classCastExceptionHandler(ClassCastException ex) {
        return resultFormat(3, "ClassCastException--->>类型转换异常!",ex);
    }

    //IO异常
    @ExceptionHandler(IOException.class)
    public Result iOExceptionHandler(IOException ex) {
        return resultFormat(4, "IOException--->>IO异常，请联系管理员!",ex);
    }

    //未知方法异常
    @ExceptionHandler(NoSuchMethodException.class)
    public Result noSuchMethodExceptionHandler(NoSuchMethodException ex) {
        return resultFormat(5,"NoSuchMethodException--->>未知方法异常，请联系管理员!", ex);
    }

    //数组越界异常
    @ExceptionHandler(IndexOutOfBoundsException.class)
    public Result indexOutOfBoundsExceptionHandler(IndexOutOfBoundsException ex) {
        return resultFormat(6,"IndexOutOfBoundsException--->>数组越界异常，请联系管理员!", ex);
    }

    //400错误
    @ExceptionHandler({HttpMessageNotReadableException.class})
    public Result requestNotReadable(HttpMessageNotReadableException ex) {
        System.out.println("400..requestNotReadable");
        return resultFormat(7,"HttpMessageNotReadableException--->>400错误，请联系管理员!", ex);
    }

    //400错误
    @ExceptionHandler({TypeMismatchException.class})
    public Result requestTypeMismatch(TypeMismatchException ex) {
        System.out.println("400..TypeMismatchException");
        return resultFormat(8,"TypeMismatchException--->>400错误，请联系管理员!", ex);
    }



    //500错误
    @ExceptionHandler({ConversionNotSupportedException.class, HttpMessageNotWritableException.class})
    public Result server500(RuntimeException ex) {
        System.out.println("500...");
        return resultFormat(12, "StackOverflowError--->>栈溢出，请联系管理员!",ex);
    }

    //栈溢出
    @ExceptionHandler({StackOverflowError.class})
    public Result requestStackOverflow(StackOverflowError ex) {
        return resultFormat(13, "StackOverflowError--->>栈溢出，请联系管理员!",ex);
    }

    //除数不能为0
    @ExceptionHandler({ArithmeticException.class})
    public Result arithmeticException(ArithmeticException ex) {
        return resultFormat(13, "ArithmeticException--->>除数不能为0，请联系管理员!",ex);
    }

    //其他错误
    @ExceptionHandler({Exception.class})
    public Result exception(Exception ex) {
        return resultFormat(14, "Exception--->>未知错误，请联系管理员!",ex);
    }

    private <T extends Throwable> Result resultFormat(Integer code, String msg,T ex) {
        ex.printStackTrace();
        log.error(msg.toString());
        Result result = new Result();
        result.setCore(code);
        result.setMsg(msg);
        return result;
    }

}
