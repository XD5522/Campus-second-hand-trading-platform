package com.example.campus_second_hand_trading_platform.dao.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import java.time.LocalDateTime;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * <p>
 * 
 * </p>
 *
 * @author cc
 * @since 2023-06-10
 */
@Data
@ApiModel(value = "Evaluate对象", description = "")
public class Evaluate implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private Integer commenter;

    private Integer commentee;

    private Integer productId;

    private String content;

    private LocalDateTime time;

    private String state;

    private Object star;

    private Integer flag;

}
