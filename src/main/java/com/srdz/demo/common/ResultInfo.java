package com.srdz.demo.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @FileName: demo
 * @Author: wushang
 * @Description: 返回信息包装
 * @Date: 2020/1/12 1:47 下午
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ResultInfo {

    private Integer code;
    private String msg;

    public static final ResultInfo ADD_SUCCESS = new ResultInfo();
    public static final ResultInfo ADD_ERROR = new ResultInfo();

}
