package com.example.demo.test;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

/**
 * @Author: bruce
 * @Version: V1.0
 * @Package: com.example.demo
 * @Description:
 * @Dept: 星创产品部
 * @Date: Created in 2020/8/7 17:24
 */
public class TestMain {

            public static void main(String[] args) throws IOException {
                //下载图片网址  自己更换链接
                String url1 = "https://www.zhihu.com/question/50734809";
                Connection connection = Jsoup.connect(url1);
                //下载到本地地址
                String filePath = "E:\\export\\picture1";
                File file = new File(filePath);
                System.out.println(filePath+"创建："+file.mkdirs());
                Document document = connection.get();//获取整个页面的对象
                Elements questionMain = document.select("[class=Question-main]");
                Elements QuestionAnswersanswer = questionMain.select("[class=QuestionAnswers-answers]");
                Elements bigDivs = QuestionAnswersanswer.select("[class=List-item]");//找寻所有的class="List-item"

                int count = 0;//总共下载了多少
                for (Element e : bigDivs){
                    Elements answer =  e.select("[class=ContentItem AnswerItem]");
                    String names = answer.attr("data-zop");
                    int left = names.indexOf(":");
                    int right = names.indexOf(",");
                    String name = names.substring((left+2),(right-1));//获取作者
                    Elements e1 = e.select("[class=RichContent-inner]");
                    Elements figures = e1.select("figure");//获取figure标题群
                    int a = 0;//每一个用户一共多少张
                    for (Element ele :figures){
                        a++;
                        Elements elementImg = ele.select("img");
                        String src = elementImg.attr("src");

                        URL url = new URL(src);
                        InputStream ips = url.openStream();

                        FileOutputStream fos = new FileOutputStream(filePath+"//"+name+a+".jpg");
                        System.out.println(name+a);
                        byte[] b = new byte[1024];
                        int i = ips.read(b);
                        while (i != -1){
                            fos.write(b,0,i);
                            fos.flush();
                            i = ips.read(b);
                        }
                        fos.close();
                        ips.close();
                        count++;
                        System.out.println("下载"+count+"个了");
                    }
                }
            }
    }

