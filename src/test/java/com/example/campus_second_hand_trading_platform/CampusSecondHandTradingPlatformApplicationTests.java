package com.example.campus_second_hand_trading_platform;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collections;

@SpringBootTest
class CampusSecondHandTradingPlatformApplicationTests {

    @Test
    void contextLoads() {
        FastAutoGenerator.create("jdbc:mysql://101.43.208.136:3306/2020011236", "2020011236", "NxcKw6kNaEt2jxKW")
                .globalConfig(builder -> {
                    builder.author("cc") // 设置作者
                            .enableSwagger() // 开启 swagger 模式
                            .fileOverride() // 覆盖已生成文件
                            .outputDir("D:\\user\\cc\\2023\\程序设计\\github\\Campus-second-hand-trading-platform\\src\\main\\resources\\generator"); // 指定输出目录
                })
                .packageConfig(builder -> {
                    builder.parent("") // 设置父包名
                            .pathInfo(Collections.singletonMap(OutputFile.xml, "D:\\user\\cc\\2023\\程序设计\\github\\Campus-second-hand-trading-platform\\src\\main\\resources\\generator")); // 设置mapperXml生成路径
                })
                .strategyConfig(builder -> {
                    builder .addTablePrefix("t_", "c_"); // 设置过滤表前缀
                })
                .execute();
    }

}
