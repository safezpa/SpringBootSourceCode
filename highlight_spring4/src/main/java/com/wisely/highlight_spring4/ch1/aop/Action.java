package com.wisely.highlight_spring4.ch1.aop;

import java.lang.annotation.*;

@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Action{
    //注解接口 注解本身没有功能。和XML一样是一种元数据，也就是解释数据的数据，也就是配置。
    //注解的功能来自这个注解的地方
    String name();
}
