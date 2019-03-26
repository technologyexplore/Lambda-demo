package com.example.test;

import org.junit.Test;

import java.util.ArrayList;

/**
 * @author mochengqi
 * @Description: TODO
 * @date 2018/9/613:57
 */
public class Java10Test {
    @Test
    public void test(){
        var list = new ArrayList<String>();
        var stream = list.stream();
        System.out.println(list.getClass());
    }
}