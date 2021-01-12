package com.example.demo2;

import org.apache.commons.lang3.StringUtils;

import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * @Author: bruce
 * @Version: V1.0
 * @Package: com.example.demo2
 * @Description: TODO
 * @Dept: 星创产品部
 * @Date: Created in 2020/12/3 13:25
 */
public class TestForAndMap {

    public static void main(String[] args) throws Exception{
        List<Member> list1 = new ArrayList<>();
        List<Member> list2 = new ArrayList<>();
        for (int i = 0; i < 100000; i++) {
            Date date = new Date();
            list1.add(new Member((i+1),"bruce"+i,18,date));
            if(i%2 == 0){
                list2.add(new Member((i+1),null,18,date));
            }
        }
        /*int countFor = 0 ;
        long s1 = System.currentTimeMillis();
        for (Member l2 : list2) {
            if(StringUtils.isBlank(l2.getName())){
                for (Member l1 : list1) {
                    if(l1.getId().intValue() == l2.getId().intValue()){
                        countFor++;
                    }
                }
            }
        }
        long s2 = System.currentTimeMillis();
        System.out.println("双重for循环一共执行 "+countFor+"条，耗时" + (s2 - s1)+"毫秒。");*/

        TimeUnit.SECONDS.sleep(3);

        int countMap = 0 ;
        long s3 = System.currentTimeMillis();
        HashMap<Integer, Member> map = new HashMap<>();
        for (Member member : list1) {
            map.put(member.getId(),member);
        }
        for (Member m : list2) {
            if(StringUtils.isBlank(m.getName())){
                Member member = map.get(m.getId());
                if(Objects.nonNull(member)){
                    countMap++;
                }
            }
        }
        long s4 = System.currentTimeMillis();
        System.out.println("Map操作一共执行 "+countMap+"条，耗时" + (s4 - s3)+"毫秒。");
    }


}
