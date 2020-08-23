package com.xl.xlblog.pojo;

import lombok.Data;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.sql.Date;

/**
 * Created by IntelliJ IDEA.
 *
 * @version 1.0
 * @Author Mypc
 * @Date 2020/8/13
 * @Time 11:14
 */
@Data
@Component
public class Photo {


    private Long id;

    /**
     * 相片名称
     */
    @NotBlank(message = "相片名字不能为空!")
    @NotNull(message = "相片名字不能为空!")
    private String photoName;


    /**
     * 时间地点
     */
    @NotBlank(message = "相片地址不能为空!")
    @NotNull(message = "相片地址不能为空!")
    private String photoAddress;


    /**
     * 描述
     */
    @NotBlank(message = "相片描述不能为空!")
    @NotNull(message = "相片描述不能为空!")
    private String description;

    /**
     * 照片时间
     */
    private Date createTime;

}
