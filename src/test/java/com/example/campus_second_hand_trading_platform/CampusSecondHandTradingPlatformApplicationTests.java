package com.example.campus_second_hand_trading_platform;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpSession;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.Collections;
import java.util.Enumeration;

@SpringBootTest
class CampusSecondHandTradingPlatformApplicationTests {

    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    HttpSession session;

    @Test
    void contextLoads() {
        FastAutoGenerator.create("jdbc:mysql://101.43.208.136:3306/2020011236", "2020011236", "NxcKw6kNaEt2jxKW")
                .globalConfig(builder -> {
                    builder.author("qionghua") // 设置作者
                            .enableSwagger() // 开启 swagger 模式
                            .fileOverride() // 覆盖已生成文件
                            .outputDir("src\\main\\resources\\generator"); // 指定输出目录
                })
                .packageConfig(builder -> {
                    builder.parent("com.example.campus_second_hand_trading_platform") // 设置父包名
                            .pathInfo(Collections.singletonMap(OutputFile.xml, "src\\main\\resources\\generator")); // 设置mapperXml生成路径
                })
                .strategyConfig(builder -> {
                    builder .addInclude("user_account"); // 设置过滤表前缀
                })
                .execute();
    }
    @Test
    void redis(){
            redisTemplate.opsForValue().set("1","1");
            session.setAttribute("2","2");
    }
    @Value("${image.home}")
    private String homeDir;

    @Value("${image.storage.path}")
    private String imageStoragePath;

    @Test
    void pathtest(){

        System.out.println(homeDir + imageStoragePath + "/");
    }

}
