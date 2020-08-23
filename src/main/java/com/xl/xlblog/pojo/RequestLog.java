package com.xl.xlblog.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * Created by IntelliJ IDEA.
 *
 * @version 1.0
 * @Author Mypc
 * @Date 2020/7/30
 * @Time 11:53
 */
@Data
@Component
@Scope("prototype")
@AllArgsConstructor
@NoArgsConstructor
public class RequestLog  implements Serializable {
    private String ip;
    private String url;
    private String classMethod;
    private Object[] args;
    private String result;
}
