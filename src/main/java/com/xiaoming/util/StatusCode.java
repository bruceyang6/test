package com.xiaoming.util;

/**
 * @Author: bruce
 * @Version: V1.0
 * @Package: com.xiaoming.util
 * @Description:
 * @Dept: 星创产品部
 * @Date: Created in 2021/2/1 17:41
 */
public interface StatusCode {

    /**
     * 成功
     */
    Integer OK = 200;

    /**
     * 错误请求（参数错误，）
     */
    Integer BAD_REQUEST = 400;

    /**
     * 未找到
     */
    Integer NOT_FOUND= 404;

    /**
     * 用户未登录
     */
    Integer USER_NOT_LOGIN = 408;



    /**
     * 内部错误
     */
    Integer ERROR = 500;

    /**
     * 无权限
     */
    Integer NOT_PERMISSION = 403;
}
