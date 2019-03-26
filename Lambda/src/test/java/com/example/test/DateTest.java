package com.example.test;

import org.junit.Test;

import java.time.*;

/**
 * @author mochengqi
 * @Description: TODO
 * @date 2018/9/610:37
 */
public class DateTest {
    final Clock clock = Clock.systemUTC();
    @Test
    public void test(){
        System.out.println(clock.instant());
        System.out.println(clock.millis()+ "---------" + System.currentTimeMillis());
    }

    @Test
    public void testLocal(){
        LocalDateTime localDateTime = LocalDateTime.now();
        LocalDateTime localDateTime1 = LocalDateTime.now(clock);
        System.out.println(localDateTime);
        System.out.println(localDateTime1);
    }
    /**
    * @Description: Duration精确计算两个时间的不同
    * @param
    * @return
    * @author mochengqi
    * @date 2018/9/6 10:45
    */
    @Test
    public void testDuration(){
        LocalDate localDate = LocalDate.parse("2018-09-06");
        LocalTime localTime = LocalTime.parse("10:00:00");
        LocalDate localDate1 = LocalDate.parse("2018-08-06");
        LocalTime localTime1 = LocalTime.parse("10:00:00");
        final LocalDateTime from = LocalDateTime.of(localDate, localTime);
        final LocalDateTime to = LocalDateTime.of( localDate1, localTime1);

        Duration duration = Duration.between(from, to);
        System.out.println(duration.toDays());
        System.out.println(duration.toHours());

    }
}
