package com.example.campus_second_hand_trading_platform.dao.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import java.io.Serializable;

/**
 * <p>
 *
 * </p>
 *
 * @author cc
 * @since 2023-05-06
 */
@TableName("product")
@Data
public class Product implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private Integer userId;

    private String name;

    private String intro;

    private Object price;

    private Integer stock;

    private Integer hisSales;

    private String size;

    private String type;

    private Object star;

    private String trading;

    private String state;

    private Integer flag;

    public Product() {
    }

    @Override
    public String toString() {
        return "Product{" +
                "id = " + id +
                ", userId = " + userId +
                ", name = " + name +
                ", intro = " + intro +
                ", price = " + price +
                ", inventory = " + stock +
                ", hisSales = " + hisSales +
                ", size = " + size +
                ", type = " + type +
                ", star = " + star +
                ", trading = " + trading +
                ", state = " + state +
                ", flag = " + flag +
                "}";
    }
}
