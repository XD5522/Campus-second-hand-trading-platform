package com.example.campus_second_hand_trading_platform;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import com.example.campus_second_hand_trading_platform.dao.entity.User;
import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.Collections;
import java.util.Enumeration;

@SpringBootTest
@Slf4j

class CampusSecondHandTradingPlatformApplicationTests {

    @Autowired
    private RedisTemplate redisTemplate;


    @Test
    void contextLoads() {
        FastAutoGenerator.create("jdbc:mysql://101.43.208.136:3306/2020011236", "2020011236", "NxcKw6kNaEt2jxKW")
                .globalConfig(builder -> {
                    builder.author("cc") // 设置作者
                            .enableSwagger() // 开启 swagger 模式
                            .fileOverride() // 覆盖已生成文件
                            .outputDir("src\\main\\resources\\generator"); // 指定输出目录
                })
                .packageConfig(builder -> {
                    builder.parent("com.example.campus_second_hand_trading_platform") // 设置父包名

                            .pathInfo(Collections.singletonMap(OutputFile.xml, "src\\main\\resources\\generator")); // 设置mapperXml生成路径
                })
                .strategyConfig(builder -> {
                    builder .addInclude("order"); // 设置过滤表前缀
                })
                .execute();
    }
    @Test
    void redis(){

    }
//    @Value("${image.home}")
//    private String homeDir;
//
//    @Value("${image.storage.path}")
//    private String imageStoragePath;
//
//    @Test
//    void pathtest(){
//
//        System.out.println(homeDir + imageStoragePath + "/");
//    }

    @Test
    void locktest(){
        User user = new User();
        user.setUserName("cc");
        redisTemplate.opsForHash().put("b'\\xac\\xed\\x00\\x05t\\x00\\x9beyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJxaW9uZ2h1YSIsImlzcyI6ImMyMjVjYyIsImlhdCI6MTY4NTE3MzQ5NywiZXhwIjoxNjg1MTc3MDk3fQ.jB81NztBsSod9pXmNyqbIg_L5w05C06fx5mMUR1qm3E'","info",user);
        //redisTemplate.opsForHash().put("hashValue","map2","map2-2");

    }

    @Test
    void get(){
        Object obn = redisTemplate.opsForHash().get("b'\\xac\\xed\\x00\\x05t\\x00\\x9beyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJxaW9uZ2h1YSIsImlzcyI6ImMyMjVjYyIsImlhdCI6MTY4NTE3MzQ5NywiZXhwIjoxNjg1MTc3MDk3fQ.jB81NztBsSod9pXmNyqbIg_L5w05C06fx5mMUR1qm3E'","map1").toString();
        log.info(obn.toString());
    }

}
