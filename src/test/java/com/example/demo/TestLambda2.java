package com.example.demo;

import com.example.demo.interface1.MyFunction;
import com.example.demo.test.lombok.User;
import io.swagger.models.auth.In;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.*;

/**
 * @Author: bruceyang
 * @Description: <一句话描述该类功能/>
 * @Date: Created in 17:30 2021/11/25
 * @Modified By:
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class TestLambda2 {


    @Test
    public void test1(){
        comsumer(1000.00,(x) -> System.out.println("双十一购物消费了" + x +"元"));

    }

    public void comsumer(Double money, Consumer<Double> com ){
        com.accept(money);
    }

    public void printList(List<Integer> list){
        for (Integer integer : list) {
            System.out.print(integer+" ");
        }
    }


    @Test
    public void test101(){

        BiFunction<Long,String,User> bf = User::new;
        User user = bf.apply(55l, "张三");
        System.out.println("user = " + user);
    }
    @Test
    public void test100(){
        Consumer<String> con = (x) -> System.out.print(x.toUpperCase());
        con.accept("qwertyuiop");

    }
    @Test
    public void test99(){

        //产生10个100以内的随机数
        List<Integer> list = getValue2(10,() -> (int) (Math.random()*100));
        printList(list);

    }
    public List<Integer> getValue2(int num,Supplier<Integer> sup){
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            list.add(sup.get());
        }
        return list;
    }

    // 产生10个100以内的随机数
    @Test
    public void test2(){

        List<Integer> list = getValue(10,() -> (int)(Math.random()*100));
        for (Integer integer : list) {
            System.out.println(integer);
        }
    }

    public List<Integer> getValue(int num, Supplier<Integer> sup){
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            list.add(sup.get());
        }
        return list;
    }

    @Test
    public void test3(){

        String newStr = strHandler("\t\t\t我是中国人   ",(s) -> s.trim().substring(2,4));
        System.out.println("newStr = " + newStr);
    }


    public String strHandler(String string , Function<String,String> fun){
        return fun.apply(string);
    }

    @Test
    public void test4(){

        List<String> list = Arrays.asList("123","123456","abc","ok");
        List<String> newList = getList(list,(s) -> s.length()>3);
        for (String s : newList) {
            System.out.println("s = " + s);
        }
    }

    public List<String> getList(List<String> inputList, Predicate<String> pre){

        List<String> list = new ArrayList<>();
        for (String s : inputList) {
            if(pre.test(s)){
                list.add(s);
            }
        }
        return list;
    }


    @Test
    public void test5(){
        Long sum = calc(100L,300L,(x,y) -> x + y);
        System.out.println("sum = " + sum);

        Long multiply = calc(100L,300L,(x,y) -> x * y);
        System.out.println("multiply = " + multiply);
    }


    public Long calc(Long l1, Long l2, MyFunction<Long,Long> myFunction){
        return myFunction.getValue(l1,l2);
    }


    @Test
    public void test6(){

        Supplier<User> sp = () -> new User();
        User u = sp.get();
        System.out.println("u = " + u);

        Supplier<User> sp1 = User::new;
        sp1.get();


    }
}
