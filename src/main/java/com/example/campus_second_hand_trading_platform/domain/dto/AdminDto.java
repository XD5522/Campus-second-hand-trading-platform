package com.example.campus_second_hand_trading_platform.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder

public class AdminDto {
    private String account;
    private String password;


}
