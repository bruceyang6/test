package com.example.demo.test;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.demo.entity.Students;
import lombok.Data;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.CollectionUtils;

import java.io.PrintWriter;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.LongStream;
import java.util.stream.Stream;
import static java.util.stream.Collectors.*;


@Slf4j
public class TestLambda {


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


    public static List<List<Students>> queryListFlat() {
        List<List<Students>> listFlat = Arrays.asList(
                Arrays.asList(new Students(001L, "张林", "男", 12, "三年级", new Date(),2000d,new BigDecimal("30")),
                        new Students(002L, "李达", "男", 13, "四年级", new Date(),5000d,new BigDecimal("60"))),
                Arrays.asList(new Students(003L, "张三", "女", 14, "五年级", new Date(),3000d,new BigDecimal("70")),
                        new Students(004L, "李四", "女", 12, "三年级", new Date(),6000d,new BigDecimal("30"))),
                Arrays.asList(new Students(005L, "王五", "女", 13, "四年级", new Date(),10000d,new BigDecimal("60")),
                        new Students(006L, "张鹏", "男", 15, "五年级", new Date(),9000d,new BigDecimal("70")))
        );
        return listFlat;
    }

    public static void main(String[] args) throws Exception{
        // 取字符串中的第一个
        List<Students> listt = queryList();
        String names = listt.stream().map(s -> s.getName()).filter(a -> StringUtils.isNotBlank(a)).distinct().collect(joining(","));
        String name = listt.stream().map(s -> s.getName()).filter(a -> StringUtils.isNotBlank(a)).distinct().findFirst().orElse("");
        System.out.println("name = " + name);

        String s2 = JSONObject.toJSONString(queryList());
        System.out.println("s2 = " + s2);
        List<Students> students2 = JSONArray.parseArray(s2, Students.class);
        List<Students> collect3 = students2.stream().filter(s -> StringUtils.equals(s.getName(),"张林")).collect(toList());
        /**
         * Stream 流使用 https://www.cnblogs.com/JavaWeiBianCheng/p/11936136.html
         */
        List<Students> list = queryList();
        /*System.out.println(l.toString());
        List<Students> list = l.stream().filter(s -> s.getGrade().equals("五年级")).collect(Collectors.toList());
        System.out.println(list.toString());*/
        // 过滤掉姓名为张三的
        List<Students> testCollection = list.stream().filter(s -> {
            if (StringUtils.equals(s.getName(),"张三")) {
                return false;
            }
            return true;
        }).collect(toList());
        System.out.println("testCollection = " + testCollection.toString());
        /**
         * 一、filter 方法使用
         */
        // 获取年级包含三的学生
        List<Students> slist = list.stream().filter(s -> s.getGrade().contains("三")).collect(Collectors.toList());
        System.out.println("slist = " + slist);

        // 获取年级包含三的学生的首位学生
        Optional<Students> first = list.stream().filter(s -> s.getGrade().contains("三")).findFirst();
        String s1 = first.map(s -> s.getName()).orElse(first.toString());
        System.out.println("s1 = " + s1);
        System.out.println("first = " + first);
        /**
         * @Author: bruce
         * @Description:
         * @Param: [args]
         * @return: void
         * @Date: 2020/9/10 16:32
         */
        Students students3 = first.get();
        System.out.println("students3 = " + students3.getName());

        /**  2020/7/10 10:20 查询并打印list中学生年龄=12*/
        List<Students> filterList =list.stream().filter(student -> student.getAge()==12).collect(Collectors.toList());
        System.out.println("filterList = " + filterList);

        /**
         * 二、map 使用方法
         */
        /**  2020/7/13 10:07 将list 转换成 map*/

        Map<Long, Students> listToMap = list.stream().collect(Collectors.toMap(Students::getId, s -> s,(k1,k2)->k1));
        log.info("listToMap = " + listToMap);
        /** 将list转换为map时，若有相同的key，则将value的值相加 */
        Map<String, BigDecimal> collect1 = list.stream().collect(toMap(Students::getName, Students::getBookAmount, BigDecimal::add));
        /** 将list转换为map时，若有相同的key(k1==k2)，则取k1的值 */
        Map<String, BigDecimal> collect2 = list.stream().collect(toMap(Students::getName, Students::getBookAmount, (k1,k2)->k1));


        if(!CollectionUtils.isEmpty(list)){
            String collect = list.stream().filter(s -> s.getAge() == 12).map(s -> {
                StringBuilder sb = new StringBuilder();
                if (StringUtils.isNotBlank(s.getName())) {
                    sb.append(StringUtils.trimToEmpty(s.getName())).append(":");
                }
                if (StringUtils.isNotBlank(s.getGrade())) {
                    sb.append(StringUtils.trimToEmpty(s.getGrade()));
                }
                return sb.toString();
            }).collect(Collectors.joining(";"));
            System.out.println("collect = " + collect);
        }

        // 将Students列表 转换成  Employee列表
        if(!CollectionUtils.isEmpty(list)){
            List<Employee> employeeList = list.stream().filter(s -> s.getAge() == 12).map(s -> {
                Employee employee = new Employee();
                employee.setName(s.getName());
                employee.setGrade(s.getGrade());
                return employee;
            }).collect(Collectors.toList());
            System.out.println("employeeList = " + employeeList);
        }
        //将list转换为map

            /*Map<Long,String> m = new HashMap();
            m.putAll(list.stream().collect(Collectors.toMap(Students::getId,Students::getName)));*/

        List<Employee> eList = Arrays.asList(
                new Employee("张三","1"),
                new Employee("李斯特","3"),
                new Employee("王二麻子","1"));
        System.out.println("eList.toString() = " + eList.toString());
        Map<String, String> addrMap = new HashMap<>();
        addrMap.putAll(eList.stream().collect(Collectors.toMap(Employee::getName,Employee::getGrade)));


        /**
         * 三、flatMap 方法使用
         */
        /**  2020/7/10 11:18 Stream()之FlatMap方法*/
        List<List<Students>> listFlat = queryListFlat();
        /**  2020/7/10 11:36 将 List<List<Students> 转换为 List<Students>*/
        List<Students> studentsAll = listFlat.stream().flatMap(Collection::stream).collect(Collectors.toList());
        System.out.println("studentsAll = " + studentsAll);

        List<Students> studentsAll2 = listFlat.stream().flatMap(s -> {
            Stream<Students> stream = s.stream();
            return stream;
        }).collect(Collectors.toList());
        System.out.println("studentsAll2 = " + studentsAll2);

        List<Long> listFlatLong = listFlat.stream().flatMap(s -> s.stream())
                .flatMapToLong(s -> LongStream.of(s.getAge())).peek(System.out::println).boxed().collect(Collectors.toList());
        System.out.println("listFlatLong.toString() = " + listFlatLong.toString());


        List<Long> listFlatLong2 = listFlat.stream().flatMap(s -> s.stream()).mapToLong(Students::getAge).boxed()
                .collect(Collectors.toList());
        System.out.println("listFlatLong2.toString() = " + listFlatLong2.toString());

        /**  2020/7/10 13:22 listFlat 获取对象中的年级字段集合*/
        List<String> listFlatGrade = listFlat.stream().flatMap(s -> s.stream()).map(s -> s.getGrade()).collect(Collectors.toList());
        System.out.println("listFlatGrade.toString() = " + listFlatGrade.toString());

        /**  2020/7/10 13:21 list 获取对象中的年级字段集合，并且去重*/
        List<String> listGrade = list.stream().map(s -> s.getGrade()).distinct().collect(Collectors.toList());
        System.out.println("listGrade.toString() = " + listGrade.toString());


        /**
         * 四、sorted()方法使用
         */
        /**以下两种打印效果一样  2020/7/10 13:38 */
        list.stream().forEach(System.out::println);
        // 根据年级排序
        list.stream().sorted(Comparator.comparing(Students::getAge)).collect(Collectors.toList()).forEach(System.out::println);
        // 根据ID反向排序
        list.stream().sorted(Comparator.comparingLong(Students::getId).reversed()).collect(Collectors.toList()).forEach(System.out::println);
        /**
         * 五、max min average 方法使用
         */
        Students students = list.stream().max(Comparator.comparing(Students::getTuitioin)).orElse(null);
        System.out.println("students = " + students);
        Students students1 = list.stream().min(Comparator.comparing(Students::getTuitioin)).orElse(null);
        System.out.println("students1 = " + students1);
        double tuition = list.stream().mapToDouble(s -> s.getTuitioin()).max().orElse(0.00);
        System.out.println("tuition = " + tuition);
        double tuition2 = list.stream().mapToDouble(s -> s.getTuitioin()).min().orElse(0.00);
        System.out.println("tuition2 = " + tuition2);
        double average = list.stream().mapToDouble(s -> s.getTuitioin()).average().orElse(0.00);
        System.out.println("average = " + average);


        /**
         * 六、match方法使用
         */
        // 列表中是否所有元素都匹配该条件
        boolean gt = list.stream().allMatch(s -> s.getTuitioin() >= 5000);

        // 列表中是否存在元素满足条件
        boolean any = list.stream().anyMatch(s -> s.getTuitioin() > 20000);

        // 列表中是否没有元素满足条件
        boolean lt = list.stream().noneMatch(s -> s.getTuitioin() < 200);

        /**
         * 七、distinct方法使用
         */
        // 常规实现方式
        System.out.println("distinct方法使用 = " );
        list.stream().distinct().collect(Collectors.toList()).forEach(System.out::println);

        // Stream filter 实现方式
        list.stream().filter(distinctByKey(Students::getGrade)).collect(Collectors.toList()).forEach(System.out::println);

        /**
         * 八、reduce 方法使用
         */
        Double reduce = list.stream().map(Students::getTuitioin).reduce(Double::sum).get();
        System.out.println("reduce = " + reduce);

        Double ab = list.stream().map(Students::getTuitioin).reduce((a, b) -> a + b).get();
        System.out.println("ab = " + ab);

        Double ab2 = list.stream().map(Students::getTuitioin).reduce((a, b) -> {
            System.out.println("a:" + a + "  b:" + b);
            return a + b;
        }).get();
        System.out.println("ab2 = " + ab2);


        Double reduce1 = list.stream().map(Students::getTuitioin).reduce(0.00, Double::sum);
        System.out.println("reduce1 = " + reduce1);


        Double aDouble = list.stream().map(Students::getTuitioin).reduce(AddUtils::add).get();
        System.out.println("aDouble = " + aDouble);

        /**
         * 九、Collector 方法使用
         */

        // 转换成连接字符串
        String collect = list.stream().map(Students::getName).collect(Collectors.joining(","));
        System.out.println("collect = " + collect);

        // 转换成set集合
        Set<String> set = list.stream().map(Students::getName).collect(Collectors.toSet());
        System.out.println("set = " + set);

        // 转换成vector
        Vector<String> vec = list.stream().map(Students::getName).collect(Collectors.toCollection(Vector::new));
        System.out.println("vec = " + vec);

        // 转换成list
        List<String> toList = list.stream().map(Students::getName).collect(Collectors.toList());
        System.out.println("toList = " + toList);

        // 转换成map
        Map<Long, String> map = list.stream().collect(Collectors.toMap(Students::getId, s -> s.getName(),(k1,k2)->k1));
        System.out.println("map = " + map);

        List<Map<Object,Object>> mapList = new ArrayList<>();
        /*List<List<Map<Object, Object>>> collect1 = list.stream().map(s -> {
            HashMap<Object, Object> map1 = new HashMap<>();
            map1.put(s.getName(), s.getGrade());
            mapList.add(map1);
            return mapList;
        }).collect(Collectors.toList());
        System.out.println("mapList = " + mapList);*/
        list.forEach(s -> {
            HashMap<Object, Object> hashMap = new HashMap<>();
            hashMap.put(s.getName(),s.getGrade());
            mapList.add(hashMap);
        });
        System.out.println("mapList = " + mapList);


        /**
         * 十、count方法使用
         */
        long count = list.stream().filter(s -> s.getAge() == 12).count();
        System.out.println("count = " + count);

        /**
         * 十一、summarizingDouble 方法使用 （总结）
         */
        DoubleSummaryStatistics summary = list.stream().collect(Collectors.summarizingDouble(Students::getTuitioin));
        System.out.println("summary = " + summary);

        DoubleSummaryStatistics summaryStatistics = list.stream().mapToDouble(Students::getTuitioin).summaryStatistics();
        System.out.println("summaryStatistics = " + summaryStatistics);

        /**
         * 十二、patitioningBy 方法使用 （分区）
         */
        Map<Boolean, List<Students>> listMap = list.stream().collect(Collectors.partitioningBy(s -> {
            return s.getTuitioin() > 6000;
        }));
        log.info("true:{}", listMap.get(Boolean.TRUE));
        log.info("false:{}", listMap.get(Boolean.FALSE));

        /**
         * 十三、groupby 方法使用
         *
         */
        /*Map<String, List<Students>> result = l.stream().collect(Collectors.groupingBy(Students::getGrade));
        System.out.println(result.toString());*/
        // 根据年级分组
        Map<String, List<Students>> groupList = list.stream().collect(Collectors.groupingBy(Students::getGrade));
        System.out.println("groupList = " + groupList);

        // 根据年级获取每组数量
        Map<String, Long> longMap = list.stream().collect(Collectors.groupingBy(Students::getGrade, Collectors.counting()));
        System.out.println("longMap = " + longMap);

        // 根据年级分组，并统计每组学费总和
        Map<String, Double> doubleMap = list.stream().collect(Collectors.groupingBy(Students::getGrade, Collectors.summingDouble(Students::getTuitioin)));
        System.out.println("doubleMap = " + doubleMap);

        /**
         * 十四、parallet方法使用  （多线程，相当于只有一个线程占用主线程，其余的都在线程池中处理）
         */
        list.stream().parallel().forEach(s -> cal(s));

        /**
         * 十五、file方法使用  (写入文件，读取文件)
         */
        // 写入文件
        PrintWriter printWriter = new PrintWriter(Files.newBufferedWriter(Paths.get("E:\\test.txt")));
        list.stream().forEach(printWriter::println);
        printWriter.close();

        // 读取文件
        List<String> fileList = Files.lines(Paths.get("E:\\test.txt")).collect(Collectors.toList());
        System.out.println("fileList = " + fileList);


        // 读取文件 https://www.zhihu.com/question/67344572
        /*String encode = "GBK";
        String filePath = "E:\\document\\web复习\\客户端相关\\el表达式.txt";
        FileInputStream fin = new FileInputStream(filePath);
        InputStreamReader reader = new InputStreamReader(fin,encode);
        BufferedReader br = new BufferedReader(reader);
        String strTmp = "";
        while ((strTmp = br.readLine()) != null){
            System.out.println("strTmp = " + strTmp);
        }
        br.close();*/

        /**
         * 十六、两个集合的交集
         */
        List<Integer> ageList = Arrays.asList(13, 14);
        List<Students> list2 = list.stream().filter(s -> ageList.contains(s.getAge())).collect(Collectors.toList());
        list2.parallelStream().forEach(System.out::println);

    }

    private static <T> Predicate<T> distinctByKey(Function<? super T, ?> keyExtractor) {
        Map<Object,Boolean> seen = new ConcurrentHashMap<>();
        return t -> seen.putIfAbsent(keyExtractor.apply(t), Boolean.TRUE) == null;
    }

    static class AddUtils {
        public static Double add(Double a, Double b) {
            return a + b;
        }
    }

    private static void cal(Students students){
        try {
            long value = Double.valueOf(students.getTuitioin()).longValue();
            TimeUnit.MILLISECONDS.sleep(100);
            log.info("name:{}",students.getName());
        } catch (InterruptedException e) {
            log.error(e.getMessage());
        }
    }
    /**
     * 移除list中指定元素
     * list.removeIf("测试2"::equals);
     */


}
@Data
@ToString
class Employee{
    private String name;
    private String grade;

    public Employee(){
    }
    public Employee(String name,String grade){
        this.name = name;
        this.grade = grade;
    }
}