package com.xiaoming.util;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;
import com.xiaoming.util.OperationInfo;

import java.io.Serializable;

/**
 * @Author: bruce
 * @Version: V1.0
 * @Package: com.xiaoming.util
 * @Description:
 * @Dept: 星创产品部
 * @Date: Created in 2021/2/1 17:38
 */
@ApiModel(value = "返回对象", description = "返回对象")
public class R<T> implements Serializable {
    private static final long serialVersionUID = 3222181463833620638L;

    @ApiModelProperty(value = "返回消息", name = "msg", example = "success")
    @ApiParam(value = "返回消息")
    private String msg = "success";

    @ApiModelProperty(value = "返回code 200：成功 500：失败", name = "code", example = "200")
    private int code = StatusCode.OK;

    @ApiModelProperty(value = "返回数据", name = "repository")
    private T data;


    public R() {
        super();
    }

    public R(T data) {
        super();
        this.data = data;
    }

    /**
     * 操作失败
     */
    public static R fail() {
        return fail(OperationInfo.FAIL);
    }

    /**
     * 操作失败
     */
    public static R fail(String msg) {
        return fail(msg, StatusCode.ERROR);
    }

    /**
     * 操作失败
     *
     * @param msg  错误信息
     * @param code 状态码
     * @return
     */
    public static R fail(String msg, Integer code) {
        R resultData = new R();
        resultData.setFail(msg);
        resultData.setCode(code);
        return resultData;
    }

    /**
     * 操作失败
     * @param msg   错误信息
     * @param data  返回内容
     * @param <T>
     * @return
     */
    public static <T> R fail(String msg, T data) {
        R resultData = new R();
        resultData.setFail(msg);
        resultData.setCode(StatusCode.ERROR);
        resultData.setData(data);
        return resultData;
    }

    /**
     * 操作成功
     * @param data  返回数据
     * @param <T>
     * @return
     */
    public static <T> R success(T data) {
        R resultData = new R();
        resultData.setData(data);
        resultData.setSuccess(OperationInfo.SUCCESS);
        return resultData;
    }

    /**
     * 操作成功
     */
    public static <T> R success() {
        R resultData = new R();
        resultData.setFail(OperationInfo.SUCCESS);
        resultData.setCode(StatusCode.OK);
        return resultData;
    }

    public R(T data, String msg) {
        super();
        this.data = data;
        this.msg = msg;
    }

    public R(Throwable e) {
        super();
        this.msg = e.getMessage();
        this.code = StatusCode.ERROR;
    }

    /**
     * 成功
     * @param msg
     */
    public void setSuccess(String msg) {
        this.msg = msg;
        this.code = StatusCode.OK;
    }


    /**
     * 失败
     * @param msg
     */
    public void setFail(String msg) {
        this.msg = msg;
        this.code = StatusCode.ERROR;
    }


    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
