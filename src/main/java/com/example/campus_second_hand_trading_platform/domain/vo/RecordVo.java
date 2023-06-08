package com.example.campus_second_hand_trading_platform.domain.vo;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author cc
 */
@Data
public class RecordVo {
    private Integer id;
    private Integer userId;
    private Integer value;
    private LocalDateTime time;
    private Integer flag;
}
