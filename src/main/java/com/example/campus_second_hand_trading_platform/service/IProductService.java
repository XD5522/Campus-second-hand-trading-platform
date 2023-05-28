package com.example.campus_second_hand_trading_platform.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.campus_second_hand_trading_platform.dao.entity.Product;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.campus_second_hand_trading_platform.domain.vo.ProductVo;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author cc
 * @since 2023-05-06
 */
public interface IProductService extends IService<Product> {
    public List<ProductVo> SearchProducts(String name,int current,int num);
    public ProductVo SelectProductById(int id);
}
