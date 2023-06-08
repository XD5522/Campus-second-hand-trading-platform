package com.example.campus_second_hand_trading_platform.dao.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serial;
import java.time.LocalDateTime;

/**
 * @author cc
 */
@Data
public class Coupon {
    @Serial
    private static final long serialVersionUID = 1L;
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    private Integer userId;
    private Object type;
    private Object value;
    private LocalDateTime time;
    private Integer flag;
}
