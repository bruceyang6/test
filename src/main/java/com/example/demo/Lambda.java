import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.regex.Pattern;

public class Lambda{


    /*public String say(SayHelloService sayHelloService){
        sayHelloService.sayHello("This is a test");
        return "SUCCESS";
    }*/

    public String demo(Predicate<Integer> p ,Integer num){
        if(p.test(num)){
            return "true";
        }
        return "false";
    }


    public static void main(String[] args) {

        String s = "{\"code\":\"0\",\"msg\":\"操作成功\",\"data\":{\"pageNum\":1,\"pageSize\":20,\"size\":1,\"startRow\":1,\"endRow\":1,\"total\":1,\"pages\":1,\"list\":[{\"id\":\"13C7039B0AB61D3D47A3B07480A64C25\",\"custAccountId\":\"4E7E632F97F75837\",\"accType\":\"9352E0C98A004B84\",\"tradeTypeId\":\"TT2001\",\"acntingRuleId\":\"410\",\"acntingDesc\":\"物流引流充电订单支付-2020072300000009\",\"fiSeqFlag\":\"\",\"preAmount\":1.90,\"amount\":0.00,\"batchid\":\"D20200723000000000041\",\"srcOrderId\":\"2020072300000009\",\"srcOrderDate\":\"2020-07-23 12:32:42\",\"srcOrderProd\":\"充电结算\",\"srcOrderQuantity\":1,\"srcOrderDesc\":\"充电结算\",\"refundFlowId\":\"\",\"refundId\":\"\",\"workDate\":\"2020-07-23 00:00:00\",\"createdBy\":\"系统\",\"createdOn\":\"2020-07-23 12:32:42\",\"remark\":\"\",\"custAccountName\":\"充电账户\",\"custUserName\":\"刘怀宽\",\"accTypeName\":\"充电账户\",\"tradeTypeName\":\"物流引流充电订单支付\",\"acntingRuleCode\":\"T0410\",\"custId\":\"83553b7a5fd948b5a681b1c36bcdf54f\",\"custUserPhone\":\"18551758700\",\"amountStr\":\"0.00\",\"preAmountStr\":\"1.90\",\"changeAmountStr\":\"-1.90\",\"createdOnStr\":\"2020-07-23 12:32:42\"}],\"prePage\":0,\"nextPage\":0,\"isFirstPage\":true,\"isLastPage\":true,\"hasPreviousPage\":false,\"hasNextPage\":false,\"navigatePages\":8,\"navigatepageNums\":[1],\"navigateFirstPage\":1,\"navigateLastPage\":1,\"firstPage\":1,\"lastPage\":1}}";


        BigDecimal b1 = new BigDecimal(1.23);
        BigDecimal b2 = new BigDecimal(2.23);
        BigDecimal b3 = new BigDecimal(3.23);
        List<BigDecimal> list = Arrays.asList(b1,b2,b3);
        BigDecimal bigDecimal = list.stream().reduce((a, b) -> a.add(b)).get();
        BigDecimal bigDecimal1 = bigDecimal.setScale(2, BigDecimal.ROUND_HALF_UP);
        System.out.println("bigDecimal1 = " + bigDecimal1);
        int i1 = b3.compareTo(b2);
        System.out.println("i1 = " + i1);

        String rex = "^\\s|[1-9]\\d*|0$";
        String input1 = "2";
        if(Pattern.matches(rex,input1)){
            System.out.println("验证通过 = " + Boolean.TRUE);
        }else {
            System.out.println("验证不通过 = " + Boolean.FALSE);
        }

        /*new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("I am Tom");
            }
        }).start();


        new Thread(()->System.out.println("我是使用Lambda之后的Tom")).start();*/

        /*SayHelloService sayHello = (msg)->{

            System.out.println(msg);
        };
        sayHello.sayHello("nishizhu");*/
        /*SayHelloService sayHelloService = new SayHelloService(){
            @Override
            public void sayHello(String msg){

                System.out.println(msg);
            }
        };
        sayHelloService.sayHello("我是tom");*/

        /*new Lambda().say((msg) -> {
            System.out.println(msg);
        });

        Lambda lambda = new Lambda();
        lambda.say(new SayHelloService() {
            @Override
            public void sayHello(String msg) {
                System.out.println(msg);
            }
        });*/

        Predicate<Integer> predicate = i -> i>12;

        System.out.println(new Lambda().demo(predicate, 0));

    }

}