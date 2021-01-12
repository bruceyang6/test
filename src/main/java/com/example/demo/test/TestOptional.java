package com.example.demo.test;


import com.example.demo.entity.Students;

import java.math.BigDecimal;
import java.util.*;

/**
 * @Author: bruce
 * @Version: V1.0
 * @Package: com.example.demo.test
 * @Description:
 * @Dept: 星创产品部
 * @Date: Created in 2020/9/10 17:10
 */
public class TestOptional {


    public static List<Students> queryList(){
        List<Students> list = Arrays.asList(
                new Students(001L,"张林","男",12,"三年级",new Date(),2000d,new BigDecimal("30")),
                new Students(002L,"李达","男",13,"四年级",new Date(),5000d,new BigDecimal("60")),
                new Students(003L,"张三","女",14,"五年级",new Date(),3000d,new BigDecimal("70")),
                new Students(004L,"李四","女",12,"三年级",new Date(),6000d,new BigDecimal("30")),
                new Students(005L,"王五","女",13,"四年级",new Date(),10000d,new BigDecimal("60")),
                new Students(005L,"王五","女",13,"四年级",new Date(),10000d,new BigDecimal("90")),
                new Students(006L,"张鹏","男",15,"五年级",new Date(),9000d,new BigDecimal("70"))
        );
        return list;
    }

    public static final String UNKNOWN = "unknown";
    /**
     * 传统方法
     * @param str
     * @return
     */
    public static String getInsuranceName(Students str){
        if (Objects.isNull(str)){
            return UNKNOWN;
        }
        return str.getName();
    }
    /**
     * map的方式提取
     * @param str
     * @return
     */
    public static String getInsuranceNameOp(Students str){
        return Optional.ofNullable(str).map(Students::getName).orElse(UNKNOWN);
    }

    public static void main(String[] args) {

        List<Students> students = queryList();
        for (Students student : students) {
            String names = getInsuranceNameOp(student);
            System.out.println("names = " + names);
        }

        /** 1.of 为非null的值创建一个Optional。
         * of方法通过工厂方法创建Optional类。需要注意的是，创建对象时传入的参数不能为null。如果传入参数为null，则抛出NullPointerException 。*/
        //调用工厂方法创建Optional实例
        Optional<String> name = Optional.of("YangWei");
        //传入参数为null，抛出NullPointerException
        /*Optional<String> npe = Optional.of(null);*/
        /** 2.ofNullable 为指定的值创建一个Optional，如果指定的值为null，则返回一个空的Optional。*/
        Optional ept = Optional.ofNullable(null);

        /** 3.isPresent  如果值存在返回true，否则返回false。 */
        if(name.isPresent()){
            System.out.println("name = " + name);
        }

        /** 4.get  如果Optional有值则将其返回，否则抛出NoSuchElementException */
        try {
            System.out.println("ept.get() = " + ept.get());
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        /** 5.ifPresent  如果Optional实例有值则为其调用consumer，否则不做处理 */

        name.ifPresent(value ->{
            System.out.println("The length of the value is:" + value.length());
        });

        /** 6.orElse 如果有值则将其返回，否则返回指定的其它值。 */
        System.out.println(ept.orElse("There is no value present!"));
        System.out.println(name.orElse("There is some value!"));

        /** 7.orElseGet  orElseGet与orElse方法类似，区别在于得到的默认值。orElse方法将传入的字符串作为默认值，
         * orElseGet方法可以接受Supplier接口的实现用来生成默认值 */
        System.out.println(ept.orElseGet(() -> "Default Value!"));
        System.out.println(name.orElseGet(String::new));

        /** 8.orElseThrow 如果有值则将其返回，否则抛出supplier接口创建的异常 */
        try {
            ept.orElseThrow(IllegalArgumentException::new);
        } catch (Throwable ex) {
            System.out.println(ex.getMessage());
        }

        /** 9.map  如果有值，则对其执行调用mapping函数得到返回值。如果返回值不为null，则创建包含mapping返回值的Optional作为map方法返回值，否则返回空Optional。
         map方法用来对Optional实例的值执行一系列操作。通过一组实现了Function接口的lambda表达式传入操作。 */
        Optional<String> upperName = name.map(value -> value.toUpperCase());
        System.out.println(upperName.orElse("No Value Found!"));


        /** 10.flatMap  如果有值，为其执行mapping函数返回Optional类型返回值，否则返回空Optional。
         * flatMap方法与map方法类似，区别在于mapping函数的返回值不同。map方法的mapping函数返回值可以是任何类型T，而flatMap方法的mapping函数必须是Optional。
         *
         * 参照map函数，使用flatMap重写的示例如下 */
        upperName = name.flatMap(value -> Optional.of(value.toUpperCase()));
        System.out.println(upperName.get());

        /** 11.filter  如果有值并且满足断言条件返回包含该值的Optional，否则返回空Optional。
         * 这里可以传入一个lambda表达式。对于filter函数我们应该传入实现了Predicate接口的lambda表达式。 */
        List<String> arrayList = new ArrayList<String>() {{
            add("Yangwei");
            add("Yanghuan");
        }};
        for (String s : arrayList) {
            Optional<String> filterName = Optional.of(s).filter(value -> value.length() < 8);
            System.out.println(filterName.orElse(s +",The name is more than 8 characters!"));

        }
    }
}
