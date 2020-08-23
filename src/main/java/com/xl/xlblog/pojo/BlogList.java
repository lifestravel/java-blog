package com.xl.xlblog.pojo;

import ch.qos.logback.classic.boolex.EvaluatorTemplate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.sql.Date;

/**
 * Created by IntelliJ IDEA.
 *
 * @version 1.0
 * @Author Mypc
 * @Date 2020/8/6
 * @Time 9:56
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class BlogList {

    private Long id;

    private String title;

    private String typeName;

    private Boolean recommended;

    private Boolean publish;

    private Date updateTime;
}
