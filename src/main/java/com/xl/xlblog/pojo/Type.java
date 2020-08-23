package com.xl.xlblog.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @version 1.0
 * @Author Mypc
 * @Date 2020/7/30
 * @Time 18:15
 *
 * 类型类
 */
@Data
@Component
@AllArgsConstructor
@NoArgsConstructor
public class Type implements Serializable {
    /**
     * id
     */
    @NotNull(message = "id不能为空!")
    @Min(value = 0,message = "id不能小于零")
    private Long id;

    /**
     * 名字
     */
    @NotNull(message = "类型不能为空")
    private String name;

    /**
     * 该类型下面的博客数量
     */
    private int blogCount;

    /**
     * 该类型下的博客
     */
    private List<Blog> blogList;
}
