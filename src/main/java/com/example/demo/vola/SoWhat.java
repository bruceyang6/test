package com.example.demo.vola;

/**
 * @Author: bruce
 * @Version: V1.0
 * @Description: TODO
 * @Dept: 星创产品部
 * @Date: Created in 2020/7/9 15:19
 */
public class SoWhat {

    /** volatile修饰的变量 */
    volatile int i = 0;
    public int getI(){
        /** 单个volatile变量的读 */
        return i;
    }
    public void setI(int j){
        /** 单个volatile变量的写 */
        this.i = j;
    }
    public void inc(){
        /**复合多个volatile变量  */
        i++;
    }
}
class SynSoWhat{
    int i = 0;
    public synchronized int getI(){
        return i ;
    }
    public synchronized void setI(int j){
        this.i = j;
    }
    public void inc(){
        /**调用已同步方法  */
        int temp = getI();
        /**普通写方法  */
        temp = temp+1;
        /**调用已同步方法  */
        setI(temp);
    }
}