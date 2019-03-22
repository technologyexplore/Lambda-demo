package com.shein.test;

import java.lang.annotation.*;

public class RepeatingAnnotations {
    @Target( ElementType.TYPE )
    @Retention( RetentionPolicy.RUNTIME )
    public @interface Filters {
        Filter[] value();
    }
    
    @Target( ElementType.TYPE )
    @Retention( RetentionPolicy.RUNTIME )
    @Repeatable( Filters.class )
    public @interface Filter {
        String value();
    };
    
    @Filter( "filter1" )
    @Filter( "filter2" )
    public interface Filterable {        
    }

    /**
     * 反射API提供了一个新的方法：getAnnotationsByType()，可以返回某个类型的重复注解
     * @param args
     */
    public static void main(String[] args) {
        for( Filter filter: Filterable.class.getAnnotationsByType( Filter.class ) ) {
            System.out.println( filter.value() );
        }
    }
}
