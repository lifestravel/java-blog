package com.xl.xlblog.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * Created by IntelliJ IDEA.
 *
 * @version 1.0
 * @Author Mypc
 * @Date 2020/7/30
 * @Time 22:26
 */
@Data
@Component
@AllArgsConstructor
@NoArgsConstructor
public class Result {
    /**
     * 返回状态码
     */
    Integer code;

    /**
     * 返回信息
     */
    String message;

    /**
     * 返回数据
     */
    Object object;

}
