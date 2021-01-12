package com.example.demo.test;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.*;

public class TestThread {

    public static void task(){
        System.out.println("task run ......");
        System.out.println("task thread is "+Thread.currentThread().getName());
    }

    // 获取某个日期的开始时间
    public static Timestamp getDayStartTime(Date d) {
        Calendar calendar = Calendar.getInstance();
        if (null != d)
            calendar.setTime(d);
        calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH), 0, 0, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return new Timestamp(calendar.getTimeInMillis());
    }

    // 获取某个日期的结束时间
    public static Timestamp getDayEndTime(Date d) {
        Calendar calendar = Calendar.getInstance();
        if (null != d)
            calendar.setTime(d);
        calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH), 23, 59, 59);
        calendar.set(Calendar.MILLISECOND, 999);
        return new Timestamp(calendar.getTimeInMillis());
    }



    // 获取今年是哪一年
    public static Integer getNowYear() {
        Date date = new Date();
        GregorianCalendar gc = (GregorianCalendar) Calendar.getInstance();
        gc.setTime(date);
        return Integer.valueOf(gc.get(1));
    }

    // 获取本月是哪一月
    public static int getNowMonth() {
        Date date = new Date();
        GregorianCalendar gc = (GregorianCalendar) Calendar.getInstance();
        gc.setTime(date);
        return gc.get(2) + 1;
    }


    public static Date getBeginDayOfMonth() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(getNowYear(), getNowMonth() - 1, 1);
        return getDayStartTime(calendar.getTime());
    }

    // 获取本月的结束时间
    public static Date getEndDayOfMonth() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(getNowYear(), getNowMonth() - 1, 1);
        int day = calendar.getActualMaximum(5);
        calendar.set(getNowYear(), getNowMonth() - 1, day);
        return getDayEndTime(calendar.getTime());
    }


    public static void main(String[] args) {
       /* Date beginDayOfMonth = getBeginDayOfMonth();
        System.out.println("beginDayOfMonth = " + beginDayOfMonth);
        Date endDayOfMonth = getEndDayOfMonth();
        System.out.println("endDayOfMonth = " + endDayOfMonth);*/
        LocalDate localDate = LocalDate.now();
        System.out.println("localDate = " + localDate);
        String startTime = localDate.with(TemporalAdjusters.firstDayOfMonth()).toString();
        System.out.println("startTime = " + startTime);
        LocalDate endTime = localDate.with(TemporalAdjusters.lastDayOfMonth());
        System.out.println("endTime = " + endTime);
//        List<DeathDetail> list = deathDetailDAO.betwenStartAndEndTime(startTime, endTime);
//        List<Integer> xList = Lists.newArrayList();
//        List<Integer> yList = Lists.newArrayList();
//        Map<Integer, List<DeathDetail>> collect = list.stream().collect(Collectors.groupingBy(o -> o.getDeathTime().getDayOfMonth()));
//        for (LocalDate d = startTime; d.isBefore(endTime.plusDays(1)); d = d.plusDays(1)) {
//            int dayOfMonth = d.getDayOfMonth();
//            xList.add(dayOfMonth);
//            if (!collect.isEmpty()) {
//                List<DeathDetail> deathDetailList = collect.getOrDefault(d.getDayOfMonth(), new ArrayList<>());
//                yList.add(deathDetailList.size());
//            }
//        }
//        Map<String, Object> map = new HashMap<>();
//        map.put("xValue", xList);
//        map.put("yValue", yList);

        /*Thread t = new Thread(){

            @Override
            public void run() {
                    task();
            }
        };

        System.out.println("current main thread is "+Thread.currentThread().getName());
        t.run();
//        t.start();

        String url = "?username=zhangsan&password=123456&sex=1&";
        int po = url.lastIndexOf("&");
        String newUrl = url.substring(0, po);
        System.out.println(newUrl);

        BigDecimal s1 = new BigDecimal("0.05");
        BigDecimal s2 = new BigDecimal("0.08");
        BigDecimal s3 = new BigDecimal("0.07");
        BigDecimal subtract = s1.add(s2).subtract(s3);
        System.out.println("subtract = " + subtract);*/




    }
}
