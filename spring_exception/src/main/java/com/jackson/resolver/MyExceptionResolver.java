package com.jackson.resolver;

import com.jackson.exception.MyException;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyExceptionResolver implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
        /**
         * 参数 Exception：异常对象
         * return ：ModelAndView 需要跳转的错误视图的信息
         */

        ModelAndView modelAndView = new ModelAndView();

        if (e instanceof ClassCastException) {
            modelAndView.addObject("info", "类型转换异常");
            modelAndView.setViewName("cast_exception");
        } else if (e instanceof MyException) {
            modelAndView.addObject("info", "自定义异常");
            modelAndView.setViewName("custom_exception");
        }



        return modelAndView;

    }
}
