package com.example.demo.test.pojie;

import org.jsoup.Connection;
import org.jsoup.HttpStatusException;
import org.jsoup.Jsoup;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: bruce
 * @Version: V1.0
 * @Package: com.example.demo.test
 * @Description:
 * @Dept: 星创产品部
 * @Date: Created in 2020/9/25 13:43
 */
public class Test2 {


    public static void main(String[] args) {
        try {
            List<Thread> threads = new ArrayList<>(3);
            //开始时间
            long start = System.currentTimeMillis();
            //循环启动3个线程,每个线程下10个文件夹的图片
            for (int i = 0; i < 3; i++) {
                final int ins = i;
                Thread thread = new Thread(() -> {
                    try {
                        System.out.println("线程" + Thread.currentThread().getName() + "正在运行");
                        //开始下载
                        downloadImg(10 * ins, (ins + 1) * 10);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                });
                thread.start();
                threads.add(thread);
            }
            //join不能放在循环中，不然就失去了多线程的意义,join方法就是让线程运行结束后才能继续执行，要学多线程的可以试试去掉join会怎么样
            for (Thread thread : threads) {
                thread.join();
            }
            long end = System.currentTimeMillis();
            System.out.println("所有下载已完成,本次共用时" + (end - start) / 1000 + "s");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void downloadImg(int start, int end) throws Exception {
        //参数校验
        if (start > end) {
            System.out.println("输入的参数有误");
        }
        for (int i = start; i < end; i++) {
            //图片地址
            String url = "https://lns.hywly.com/a/1/" + i + "/";
            //一个文件夹文件数量上限为100
            int count = 100;
            for (int j = 0; j < count; j++) {
                //要创建的文件夹地址
                String src = "e:/export/picture/" + i + "/";
                File file1 = new File(src + j + ".jpg");
                //先验证当前图片是否已经存在,存在就跳过
                if (!file1.exists()) {
                    Connection.Response execute = null;
                    try {
                        //ignoreContentType忽略请求类型,这里可以自己试试，不加会报这个异常
                        // Unhandled content type. Must be text/*, application/xml, or application/xhtml+xml. Mimetype=application/json;charset=UTF-8,
                        execute = Jsoup.connect(url + j + ".jpg").ignoreContentType(true).execute();
                    } catch (HttpStatusException httpStatusException) {
                        //404时跳过当前下载，因为不知道每一套图片有多少张，所以设定当获取的页面是404时就结束
                        break;
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    //只有在条件成立时才会继续往下运行，相当于if判断
                    assert execute != null;
                    File file = new File(src);
                    //当前文件夹不存在时，创建
                    if (!file.exists()) {
                        file.mkdir();
                    }
                    //创建图片文件
                    file1.createNewFile();
                    //保存图片
                    //这样写的好处是可以充分关闭，不让文件流占用资源
                    FileOutputStream fos = new FileOutputStream(file1);
                    BufferedOutputStream bos = new BufferedOutputStream(fos);
                    bos.write(execute.bodyAsBytes());
                    bos.close();
                    fos.close();
                }
            }
        }

    }
}
