package com.example.demo.utils;

import org.apache.commons.lang3.StringUtils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author: bruce
 * @Version: V1.0
 * @Package: com.example.demo.utils
 * @Description:
 * @Dept: 星创产品部
 * @Date: Created in 2020/8/19 16:02
 */
public class CompareDateFormat {


    public static int compareDateFormat(String startTime,String endTime) throws Exception{
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        if(StringUtils.isNotBlank(startTime) && StringUtils.isNotBlank(endTime)){
            Date startDate = sdf.parse(startTime);
            Date endDate = sdf.parse(endTime);
            int compare = startDate.compareTo(endDate);
           return compare;
        }
        return 0;
    }

}
