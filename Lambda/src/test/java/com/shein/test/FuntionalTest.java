package com.shein.test;

import com.shein.test.Funtional;
import org.junit.Test;

/**
 * @author mochengqi
 * @Description: TODO
 * @date 2018/9/69:51
 */
public class FuntionalTest {

    @Test
    public void test(){
        /**
         * java8之前的实现
         */
        Funtional funtional = new Funtional(){
            @Override
            public void method() {
                System.out.println("hello world！");
            }
        };
        /**
         * java8的实现
         */
        funtional.method();

        Funtional funtional2 = () -> System.out.println("hello java8!");

        funtional2.method();

    }
}
