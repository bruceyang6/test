package com.example.demo.test.pojie;

import com.example.demo.utils.ConcurrentDateUtil;
import com.example.demo.utils.DateUtil;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.*;
import java.util.function.*;
import java.util.stream.Collectors;

/**
 * @Author: bruce
 * @Version: V1.0
 * @Package: com.example.demo.test.pojie
 * @Description:
 * @Dept: 星创产品部
 * @Date: Created in 2020/9/25 14:23
 */
public class TestJAVA8 {

    private final static Logger logger = LoggerFactory.getLogger(TestJAVA8.class);
    static List<Vehicle> vehicles = new ArrayList<>();

    public TestJAVA8() {
    }

    public static void main(String[] args) {
//        test1();
//        test2();
        test3();
//        test4();
//        test5();
//        test6();
//        testNewDate();
//        timeMath();
//        OneHundrudDay();
//        dateTest();

    }

    private static void dateTest() {
        /*try {
            String format = ConcurrentDateUtil.formatDate(new Date());
            System.out.println("format = " + format);
            Date parse = ConcurrentDateUtil.parseStr(format);
            String format1 = ConcurrentDateUtil.format(parse);
            System.out.println("parse = " + parse);
            System.out.println("format1 = " + format1);
        } catch (Exception e) {
            logger.error(e.getMessage());
        }*/

        /*SimpleDateFormat  sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS");
        String format1 = sf.format(new Date());
        System.out.println("format1 = " + format1);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        Date parse = null;
        try {
            parse = sdf.parse("20200720133722123");
            String format = sf.format(parse);
            System.out.println("format = " + format);
        } catch (ParseException e) {
            e.printStackTrace();
        }*/
        String[] lineArr = {"1","2","20200720","133722123"};
        Date tradeTime = new Date();
        try {
            tradeTime = ConcurrentDateUtil.parseStr(lineArr[2].trim() + lineArr[3].trim());
            String format = ConcurrentDateUtil.format(tradeTime);
            System.out.println("format = " + format);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println(tradeTime);
    }

    private static void OneHundrudDay() {
        LocalDate birthday = LocalDate.of(2020,4,20);
        System.out.println(birthday);
        LocalDate now = LocalDate.now();
        System.out.println(now);
        Period period = Period.between(birthday,now);
        // 计算2个日期之间相差的 年月日
        System.out.println(period.getYears() + "-" + period.getMonths() + "-" + period.getDays());
        // 计算2个日期相隔日期，不包含首位
        long between1 = ChronoUnit.DAYS.between(birthday, now);
        long oneHundre = 100L;
        long diffDay = oneHundre - between1 - 1;
        System.out.println("再过" + diffDay + "天过百天");
        System.out.println("咱娃出生天数：" + (between1 + 1L));
        // 计算相隔月份
        long between2 = ChronoUnit.MONTHS.between(birthday, now);
        System.out.println("咱娃出生月数：" + between2);
        // 几月几日刚好百天？
        LocalDate thatDay =  now.plusDays(diffDay);
        System.out.println("过百天的日期：" + thatDay);
    }

    private static void timeMath() {
        // 创建一个两周的间隔
        Period periodWeeks = Period.ofWeeks(2);
        System.out.println(periodWeeks.getDays());


        // 一年三个月零二天的间隔
        Period custom = Period.of(1, 3, 2);
        List<TemporalUnit> t = custom.getUnits();

        // 一天的时长
        Duration duration = Duration.ofDays(1);
        System.out.println(duration.getSeconds());

        // 计算2015/6/16 号到现在 2020/09/25 过了多久，它这个把间隔分到每个 part 了
        LocalDate now = LocalDate.now();
        LocalDate customDate = LocalDate.of(2015, 6, 16);
        Period between = Period.between(customDate, now);
// 结果为 5:3:9 即过去了 5年3个月9天了
        System.out.println(between.getYears() + ":" + between.getMonths() + ":" + between.getDays());

// 比较两个瞬时的时间间隔
        Instant begin = Instant.now();
        Instant end = Instant.now();
        Duration d = Duration.between(begin, end);
        System.out.println(d.getNano());

// 同样可以修改 part 信息和设置 part 信息，都是返回新的对象来表示设置过的值，原来的对象不变
        Period plusDays = between.plusDays(1);
        System.out.println(plusDays);
        Period withDays = between.withDays(4);
        System.out.println(withDays);

    }


    private static void testNewDate() {
        // 测试执行一个 new 操作使用的时间(纳秒值)
        Instant begin = Instant.now();
        Instant end = Instant.now();
        System.out.println(Duration.between(begin, end).toNanos());

        // 可以使用 of 方法构建它们的实例,如下面创建了一个 2019-9-22 21:42:59 东八区 的时间对象
        LocalDate localDate = LocalDate.of(2019, Month.SEPTEMBER, 22);
        System.out.println(localDate);
        LocalTime localTime = LocalTime.of(21, 42, 59);
        System.out.println(localTime);
        LocalDateTime localDateTime = LocalDateTime.of(localDate, localTime);
        System.out.println(localDateTime);
        ZonedDateTime zonedDateTime = ZonedDateTime.of(localDateTime, ZoneId.systemDefault());
        System.out.println(zonedDateTime);

// 获取现在的时间，这是一个静态方法
        LocalDate now = LocalDate.now();
        System.out.println(now);
// 每个实例可以获取它们的 part 信息,如获取年
        int year = localDate.getYear();
        System.out.println(year);
// 可以修改 part 信息，这将返回一个新对象，如增加一年
        LocalDate localDatePlus = localDate.plusYears(1);
        System.out.println(localDatePlus);
// 设置 part 信息，也会返回新的对象，如设置为 2017 年
        LocalDate localDateWithYear = localDate.withYear(2017);
        System.out.println(localDateWithYear);
// 比较两个日期 isAfter,isBefore
        boolean after = localDate.isAfter(LocalDate.now());
        System.out.println(after);

        System.out.println("现在时间：" + now);
// 格式化日期时间
// yyyy-MM-dd
        System.out.println(now.format(DateTimeFormatter.ISO_DATE));
// yyyy-MM-ddTHH:mm:ss

        ZoneId zoneId = ZoneId.systemDefault();
        System.out.println(zoneId);
        Set<String> availableZoneIds = ZoneId.getAvailableZoneIds();
        System.out.println(availableZoneIds);
        LocalDateTime now2 = LocalDateTime.now(zoneId);
        System.out.println(now2.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
// yyyy-MM-dd HH:mm:ss
        System.out.println(now2.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM)));
        /**
         * FormatStyle.LONG ：2020年9月25日 下午05时22分16秒
         * FormatStyle.FULL
         * FormatStyle.SHORT:20-9-25 下午5:23
         * FormatStyle.MEDIUM:2020-9-25 17:24:18
         * */

// 日期解析
        System.out.println(LocalDate.parse("2019-09-22"));
        System.out.println(LocalDateTime.parse("2019-09-22T21:05:22"));
        System.out.println(LocalDateTime.parse("2019-09-22 21:05:22" , DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM)));
    }


    private static void test6() {
        Map<String, Integer> map = new HashMap<>();
        map.put("a" , 1);
        map.put("b" , 2);
        map.put("c" , 3);
        map.forEach((k, v) -> System.out.println(k + "：这么着就能遍历了" + v));

        // 假设有一个对象 obj ,你不知道它是不是为空的，但是你想用它的方法，可以这么玩
        Object obj = 1;
        Optional<Object> canUseObj = Optional.ofNullable(obj);
        System.out.println(canUseObj.isPresent());
        canUseObj.ifPresent(System.out::println);        //如果 obj 不为空，则可以使用 obj 的方法，这里做个简单输出


    }

    private static void test5() {
        TestJAVA8 t = new TestJAVA8();
        t.initVehicles();
        vehicles.forEach(System.out::println);

        // 去掉评分为 3 分以下的车
        List<Vehicle> collect1 =
                vehicles.stream().filter(vehicle -> vehicle.getScore() >= 3).collect(Collectors.toList());
        System.out.println("去掉评分为 3 分以下的车" + collect1);

        // 取出所有的车架号列表
        List<String> vins = vehicles.stream().map(Vehicle::getVin).collect(Collectors.toList());
        System.out.println(" 取出所有的车架号列表" + vins);

        // 按照公司 Id 进行分组
        Map<Integer, List<Vehicle>> companyVehicles = vehicles.stream().collect(Collectors.groupingBy(Vehicle::getCompanyId));
        System.out.println("按照公司 Id 进行分组" + companyVehicles);

        // 按照公司分组求司机打分和
        Map<Integer, Double> collect2 = vehicles.stream().collect(Collectors.groupingBy(Vehicle::getCompanyId,
                Collectors.summingDouble(Vehicle::getScore)));
        System.out.println("按照公司分组求司机打分和" + collect2);

        // 查出所有车绑定的所有设备
        List<String> collect3 = vehicles.stream().map(vehicle -> {
            String deviceNos = vehicle.getDeviceNos();
            return StringUtils.split(deviceNos, ',');
        }).flatMap(Arrays::stream).collect(Collectors.toList());
        System.out.println(" 查出所有车绑定的所有设备" + collect3);

        // 对所有司机的总分求和
        Double reduce = vehicles.stream().parallel().map(Vehicle::getScore).reduce(0d, Double::sum);
        System.out.println("对所有司机的总分求和" + reduce);

        // 总的分值
        Double totalScore = vehicles.stream().parallel().map(Vehicle::getScore).reduce(0d, Double::sum);
        // 查看每一个司机占的分值比重
        List<String> collect4 = vehicles.stream()
                .mapToDouble(vehicle -> vehicle.getScore() / totalScore)
                .mapToLong(weight -> (long) (weight * 100))
                .mapToObj(percentage -> percentage + "%")
                .collect(Collectors.toList());
        System.out.println("查看每一个司机占的分值比重" + collect4);
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public class Vehicle {
        //车架号
        private String vin;
        // 车主手机号
        private String phone;
        // 车主姓名
        private String name;
        // 所属车租车公司
        private Integer companyId;
        // 个人评分
        private Double score;
        //安装的设备列表imei,使用逗号分隔
        private String deviceNos;
    }


    @Before("")
    public void initVehicles() {
        List<String> imeis = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            List<String> singleVehicleDevices = new ArrayList<>();
            for (int j = 0; j < 3; j++) {
                String imei = RandomStringUtils.randomAlphanumeric(15);
                singleVehicleDevices.add(imei);
            }
            imeis.add(StringUtils.join(singleVehicleDevices, ','));
        }
        vehicles.add(new Vehicle("KPTSOA1K67P081452" , "17620411498" , "9420" , 1, 4.5, imeis.get(0)));
        vehicles.add(new Vehicle("KPTCOB1K18P057071" , "15073030945" , "张玲" , 2, 1.4, imeis.get(1)));
        vehicles.add(new Vehicle("KPTS0A1K87P080237" , "19645871598" , "sanri1993" , 1, 3.0, imeis.get(2)));
        vehicles.add(new Vehicle("KNAJC526975740490" , "15879146974" , "李种" , 1, 3.9, imeis.get(3)));
        vehicles.add(new Vehicle("KNAJC521395884849" , "13520184976" , "袁绍" , 2, 4.9, imeis.get(4)));
    }

    private static void test4() {
        // hello world 示例
        Function<String, String> function = (x) -> {
            return x;
        };
        System.out.println(function.apply("hello world"));    // hello world Function

        UnaryOperator<String> unaryOperator = x -> x + 2;
        System.out.println(unaryOperator.apply("9420-"));    // 9420-2

        // 判断输入值是否为偶数示例
        Predicate<Integer> predicate = (x) -> {
            return x % 2 == 0;
        };
        System.out.println(predicate.test(1));                // false

        // 这个没有返回值
        Consumer<String> consumer = (x) -> {
            System.out.println(x);
        };
        consumer.accept("hello world ");                    // hello world

        // 这个没有输入
        Supplier<String> supplier = () -> {
            return "Supplier";
        };
        System.out.println(supplier.get());                    // Supplier

        // 找出大数
        BinaryOperator<Integer> bina = (x, y) -> {
            return x > y ? x : y;
        };
        bina.apply(1, 2);
    }

    private static void test3() {
        final String se = ",";
        Arrays.asList("a" , "b" , "c").forEach(e -> System.out.println(e));
    }

    private static void test2() {
        int[] a = {1, 3456, 67, 8, 6, 345, 3, 453, 45};
        List aa = Arrays.asList(a);
        aa.forEach(System.out::println);
        aa.add(456);
    }

    private static void test1() {
        Runnable r = () -> System.out.println("Fuck U!");
        r.run();

        Arrays.asList("a" , "b" , "d").forEach(System.out::println);
    }
}
