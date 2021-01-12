package com.example.demo.test;

import jdk.nashorn.internal.ir.CallNode;

import java.util.HashMap;
import java.util.Objects;

/**
 * @Author: bruce
 * @Version: V1.0
 * @Package: com.example.demo.test
 * @Description:
 * @Dept: 星创产品部
 * @Date: Created in 2020/8/14 15:41
 */
public class TestHashMap {

    public static void main(String[] args) {
        HashMapKey k1 = new HashMapKey(1);
        HashMapKey k2 = new HashMapKey(1);
        HashMap<HashMapKey, String> map = new HashMap<>();
        map.put(k1,"helloworld");
        System.out.println("map = " + map.get(k2));
    }


}
class HashMapKey {
    private Integer id;

    HashMapKey(Integer id) {
        this.id = id;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if(o == null || !(o instanceof HashMapKey)){
            return false;
        }else {
            return this.getId().equals(((HashMapKey) o).getId());
        }
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}