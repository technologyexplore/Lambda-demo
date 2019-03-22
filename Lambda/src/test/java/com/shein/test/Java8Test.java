package com.shein.test;

import com.shein.domain.AllotOrderDetailEntity;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by SI-GZ-1113 on 2018/8/27.
 */
public class Java8Test {
    static List<AllotOrderDetailEntity> details = new ArrayList<>();
    static {
        AllotOrderDetailEntity a= new AllotOrderDetailEntity();
        a.setClothGuid(2000);
        a.setInventoryNum(new BigDecimal(20));
        a.setMaterialSku("sku----a");
        AllotOrderDetailEntity b= new AllotOrderDetailEntity();
        b.setClothGuid(4000);
        b.setInventoryNum(new BigDecimal(40));
        b.setMaterialSku("sku----b");
        AllotOrderDetailEntity c= new AllotOrderDetailEntity();
        c.setClothGuid(1234);
        c.setInventoryNum(new BigDecimal(10));
        c.setMaterialSku("sku----c");
        AllotOrderDetailEntity d= new AllotOrderDetailEntity();
        d.setClothGuid(6000);
        d.setInventoryNum(new BigDecimal(10));
        d.setMaterialSku("sku----c");

        details.add(a);
        details.add(b);
        details.add(c);
        details.add(d);
    }
    /**
     * for循环
     */
    @Test
    public void testFor(){
        String[] atp = {"Rafael Nadal", "Novak Djokovic",
                "Stanislas Wawrinka",
                "David Ferrer","Roger Federer",
                "Andy Murray","Tomas Berdych",
                "Juan Martin Del Potro"};
        List<String> players =  Arrays.asList(atp);

        // 以前的循环方式
        for (String player : players) {
            System.out.print(player + "; ");
        }

        // 使用 lambda 表达式以及函数操作(functional operation)
        players.forEach((player) -> System.out.print(player + "; "));

        // 在 Java 8 中使用双冒号操作符(double colon operator)
        players.forEach(System.out::println);
    }
    /**
    * @Description: 匿名内部类
    * @param
    * @return
    * @author mochengqi
    * @date 2018/9/5 10:12
    */
    @Test
    public void testInClass(){
        // 正常方式
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello world !");
            }
        }).start();
        // lambda
        new Thread(() -> System.out.println("Hello world !")).start();
    }
    /**
    * @Description: 处理集合的交集，并集，差集
    * @param
    * @return
    * @author mochengqi
    * @date 2018/9/5 10:45
    */
    @Test
    public void testList(){
        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(2);
        list1.add(3);
        list1.add(4);
        List<Integer> list2 = new ArrayList<>();
        list2.add(2);
        list2.add(4);
        list2.add(6);
        list2.add(8);
        list2.add(10);

        // 交集
        List<Integer> sameIds = list1.stream().filter(id -> list2.contains(id)).collect(Collectors.toList());
        System.out.println("交集sameId---"+sameIds);
        //差集 (list1 - list2)
        List<Integer> addIds = list1.stream().filter(id -> !list2.contains(id)).collect(Collectors.toList());
        System.out.println("差集 (list1 - list2)---"+addIds);
        // 差集 (list2 - list1)
        List<Integer> deleteIds = list2.stream().filter(id -> !list1.contains(id)).collect(Collectors.toList());
        System.out.println("差集 (list2 - list1)---" + deleteIds);
        // 并集
        List<Integer> listAll = list1.stream().collect(Collectors.toList());
        List<Integer> listAll2 = list2.stream().collect(Collectors.toList());
        listAll.addAll(listAll2);
        System.out.println("---得到并集 listAll---"+listAll);
        // 去重并集
        List<Integer> listAllDistinct = listAll.stream().distinct().collect(Collectors.toList());
        System.out.println("---得到去重并集 listAllDistinct---"+listAllDistinct);
        // 限制结果个数
        List<Integer> listLimit =  listAll.stream().limit(2).collect(Collectors.toList());
        System.out.println("---得到受限制集合 listLimit---"+listLimit);

    }
    /**
    * @Description: 排序,取最大/最小值
    * @param
    * @return
    * @author mochengqi
    * @date 2018/9/5 16:09
    */
    @Test
    public void testSort(){
        // 根据库存数量降序
        List<AllotOrderDetailEntity> sorted = details.stream().sorted((a, b) -> b.getInventoryNum().compareTo(a.getInventoryNum()))
                .collect(Collectors.toList());
        sorted.forEach(detail -> System.out.println(detail.getClothGuid()+"---库存数量---"+detail.getInventoryNum()));
    }
    /**
     * @Description: 取最大/最小值
     * @param
     * @return
     * @author mochengqi
     * @date 2018/9/5 16:09
     */
    @Test
    public void testMinMax(){
        // 获取最小库存数量
        AllotOrderDetailEntity min = details.stream().min((a, b) -> b.getInventoryNum().compareTo(a.getInventoryNum()))
                .get();
         System.out.println(min.getClothGuid()+"---最小库存数量---"+min.getInventoryNum());
        // 获取最小库存数量
        AllotOrderDetailEntity max = details.stream().max((a, b) -> b.getInventoryNum().compareTo(a.getInventoryNum()))
                .get();
        System.out.println(max.getClothGuid()+"---最大库存数量---"+max.getInventoryNum());

    }

    /**
     * @Description: 根据List<Object> 某个属性获取列表</>
     * @param
     * @return
     * @author mochengqi
     * @date 2018/9/5 16:09
     */
    @Test
    public void testMap(){
        List<Integer> clothGuids = details.stream().map(AllotOrderDetailEntity::getClothGuid).collect(Collectors.toList());
        System.out.println("---入库ID集合---"+clothGuids);
        // 可以跟fitler结合使用
        List<Integer> clothGuids1 = details.stream().map(AllotOrderDetailEntity::getClothGuid).filter(clothGuid -> !clothGuid.equals(1234))
                .collect(Collectors.toList());
        System.out.println("---过滤入库ID集合---"+clothGuids1);
        List<Integer> clothGuids2 = details.stream().filter(detail -> detail.getClothGuid() != 1234).map(AllotOrderDetailEntity::getClothGuid)
                .collect(Collectors.toList());
        System.out.println("---过滤入库ID集合---"+clothGuids2);
    }
    /**
    * @Description: 项目实例
    * @param
    * @return
    * @author mochengqi
    * @date 2018/9/5 16:42
    */
    @Test
    public void test1(){
        // 项目实例，统计交集ID的库存数量总和
        BigDecimal currentNum = details.stream().map(detail ->detail.getInventoryNum()).reduce(BigDecimal.ZERO, BigDecimal::add);
        BigDecimal currentNum1 = details.stream().map(detail ->detail.getInventoryNum()).reduce(BigDecimal.ZERO, (a, b) -> a.add(b));
        System.out.println(currentNum);
        System.out.println(currentNum1);
        // 根据SKU分组
        Map<String, List<AllotOrderDetailEntity>> secMap = details.stream().collect(Collectors.groupingBy(AllotOrderDetailEntity::getMaterialSku, Collectors.toList()));

        // 根据SKU分组后的库存数量
        Map<String, BigDecimal> sumMap = details.stream().collect(Collectors.groupingBy(AllotOrderDetailEntity::getMaterialSku,
                Collectors.reducing(BigDecimal.ZERO, AllotOrderDetailEntity::getInventoryNum, BigDecimal::add)));
        System.out.println(sumMap);
    }
}
