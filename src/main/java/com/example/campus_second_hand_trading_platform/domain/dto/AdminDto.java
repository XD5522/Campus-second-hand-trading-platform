package com.example.campus_second_hand_trading_platform.domain.dto;

import lombok.Builder;
import lombok.Data;


/**
 * Description:adminDto,admin数据传输对象
 * date: 2023/4/22 15:59
 * @author cc
 * @since JDK17
 */

@Data
@Builder
public class AdminDto {
    private String adminAccount;
    private String adminPassword;
    private String name;

}
