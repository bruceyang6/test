package com.xiaoming.domain;

import lombok.Data;

import java.util.List;

/**
 * @Author: bruce
 * @Version: V1.0
 * @Package: com.xiaoming.domain
 * @Description:
 * @Dept: 星创产品部
 * @Date: Created in 2021/2/1 17:36
 */
@Data
public class Area {

    private String no;

    private String name;

    private String level;

    private String parentNo;

    private List<Area> child;

    public Area(String no,String name,String level,String parentNo){
        this.no = no;
        this.name = name;
        this.level = level;
        this.parentNo = parentNo;
    }
}
