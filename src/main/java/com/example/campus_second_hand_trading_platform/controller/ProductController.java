package com.example.campus_second_hand_trading_platform.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.campus_second_hand_trading_platform.dao.entity.Product;
import com.example.campus_second_hand_trading_platform.domain.vo.ProductVo;
import com.example.campus_second_hand_trading_platform.service.IProductService;
import com.example.campus_second_hand_trading_platform.service.IUserService;
import com.example.campus_second_hand_trading_platform.service.MinioService;
import com.example.campus_second_hand_trading_platform.utils.BeanUtils;
import com.example.campus_second_hand_trading_platform.utils.CommonResult;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.concurrent.TimeUnit;

@RestController
@CrossOrigin
@Slf4j
@RequestMapping("/product")
public class ProductController {

    IProductService productService;
    IUserService userService;

    RedisTemplate redisTemplate;

    MinioService minioService;

    public ProductController(IProductService productService, IUserService userService, RedisTemplate redisTemplate, MinioService minioService) {
        this.productService = productService;
        this.userService = userService;
        this.redisTemplate = redisTemplate;
        this.minioService = minioService;
    }

    @GetMapping("/search")
    public CommonResult<?> searchProductByName(HttpServletRequest request, @RequestParam String name,@RequestParam int current,@RequestParam int num){
        IPage<ProductVo> products = productService.SearchProducts(name,current,num);
        log.info(name);
        return CommonResult.success(products);
    }

    @GetMapping
    public CommonResult<?> getProductById(HttpServletRequest request, @RequestParam int id){
        try{
            Object product = redisTemplate.opsForHash().get("product",id);
            if(product!=null){
                if(!"false".equals(product.toString())){
                    log.info(product.toString());
                    ProductVo productVo = new ProductVo();
                    BeanUtils.copyProperties(product,productVo);
                    log.info("缓存击中");
                    return  CommonResult.success(productVo);
                }
            }
            log.info("数据库查询");
            ProductVo productVo = productService.SelectProductById(id);
            log.info(productVo.toString());
            redisTemplate.opsForHash().put("product",id, productVo);
            log.info("添加成功");
            redisTemplate.expire("product",3600000, TimeUnit.MILLISECONDS);
            return CommonResult.success(productVo);
        }
        catch (Exception e){
            log.info( e.getMessage());
            return CommonResult.failed("搜索失败");
        }
    }

    @PostMapping
    public CommonResult<?> updateImg(HttpServletRequest request,@RequestParam int id, @RequestParam(required = false) MultipartFile file){
//        log.info(product.toString());
        String imgName = productService.getById(id).getImg();
        try {
//            productService.save(product);
            minioService.delete(imgName,"product");
            minioService.upload(file,"product");
            redisTemplate.opsForHash().delete("product",id);
        }
        catch (Exception e){
            log.info(e.getMessage());
            return CommonResult.failed("修改失败");
        }

        return CommonResult.success(imgName);
    }


}
