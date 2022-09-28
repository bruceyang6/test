package com.xiaoming.server.impl;

import com.xiaoming.domain.Area;
import com.xiaoming.server.IAreaService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author: bruce
 * @Version: V1.0
 * @Package: com.xiaoming.server.impl
 * @Description: TODO
 * @Dept: 星创产品部
 * @Date: Created in 2021/2/1 17:34
 */
@Service
public class AreaServiceImpl implements IAreaService {


    @Override
    public List<Area> getList() {

        return null;
    }

    public static void main(String[] args) {
        List<Area> areas = new ArrayList<Area>(){{
            add(new Area("510000","四川省","1","0"));
            add(new Area("510100","成都市","2","510000"));
            add(new Area("510200","绵阳市","2","510000"));
            add(new Area("511000","眉山市","2","510000"));
            add(new Area("511421","仁寿县","3","511000"));
            add(new Area("511422","东山区","3","511000"));
            add(new Area("500000","重庆市","1","0"));
            add(new Area("500100","渝中区","2","500000"));
            add(new Area("500120","竹山县","3","500100"));
        }};
        String name = "山";
        // 根据名称，模糊查询
        List<Area> list = areas.stream().filter(s -> s.getName().contains(name)).collect(Collectors.toList());
        list.stream().peek(System.out::println).collect(Collectors.toList());



    }
}
