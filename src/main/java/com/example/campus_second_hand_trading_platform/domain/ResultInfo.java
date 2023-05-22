package com.example.campus_second_hand_trading_platform.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * TODO
 *
 * @Description 结果信息
 * @Author qionghua
 * @Date 2023/5/21 21:14
 **/
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResultInfo {
    private int code; //响应码
    private String message; //成功或失败信息
    private String token; //token令牌

    public static ResultInfo success(String token) {

        return ResultInfo.builder().code(200).message("success").token(token).build();
    }

    public static ResultInfo fail() {

        return ResultInfo.builder().code(500).message("fail").token("").build();
    }
}
