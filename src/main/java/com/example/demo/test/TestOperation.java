package com.example.demo.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

/**
 * 数学计算
 */
public class TestOperation {

    public static void main(String[] args) {

        MathOperation add = (a, b) -> a + b;
//        int sum = add.operation(12, 6);
        System.out.println("12+6= " + operation(12, 6, add));


        MathOperation sub = (a, b) -> a - b;
//        int subResult = sub.operation(12, 6);
        System.out.println("12-6= " + operation(12, 6, sub));

        MathOperation mul = (a, b) -> a * b;
//        int mulResult = mul.operation(12, 6);
        System.out.println("12*6= " + operation(12, 6, mul));

        MathOperation div = (a, b) -> a / b;
//        int divResult = div.operation(12, 6);
        System.out.println("12/6= " + operation(12, 6, div));


        Consumer<String> consumer = (a) -> System.out.println(a);
        consumer.accept("hello world");

        Supplier<String> supplier = () -> "hello world";
        System.out.println(supplier.get());

        Predicate<String> predicate = (a) -> a.equals("hello world");
        if (predicate.test("hello world")) {
            System.out.println("true");
        }

        Function<String, String> function = (a) -> a + "hello world";
        System.out.println(function.apply("hello"));


        // 消费型接口
        comsumerMoney(20, m -> System.out.println("双十一消费了" + m + "元"));

        // 供给型接口
        List<Integer> list = productRandomList(10, () -> (int) (Math.random() * 100));
        System.out.println("list = " + list);

        // 断言型接口
        System.out.println(isPrime("hello", s -> s.equals("hello world")));

        System.out.println(functionMethod("hello ",s -> s + "bruce yang"));



    }


    @FunctionalInterface
    interface MathOperation {
        int operation(int x, int y);
    }

    private static int operation(int x, int y, MathOperation mathOperation) {
        return mathOperation.operation(x, y);
    }

    private static void comsumerMoney(double money, Consumer<Double> consumer) {
        consumer.accept(money);
    }

    private static List<Integer> productRandomList(Integer size, Supplier<Integer> supplier) {
        if (null == size) {
            size = 10;
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= size; i++) {
            list.add(supplier.get());
        }
        return list;
    }

    private static boolean isPrime(String str,Predicate<String> predicate) {
        return predicate.test(str);

    }

    private static String functionMethod(String str,Function<String,String> function) {

        return function.apply(str);

    }


}

