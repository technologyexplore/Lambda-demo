package com.shein.test;

/**
 * @author mochengqi
 * @Description: 函数式接口
 * @date 2018/9/69:50
 */
// @FunctionalInterface
public interface Funtional {

    public abstract void method();

    // void methodDiy();

    /**
     * 接口默认实现方法
     */
    default void defaultMethod() {
    }
}
