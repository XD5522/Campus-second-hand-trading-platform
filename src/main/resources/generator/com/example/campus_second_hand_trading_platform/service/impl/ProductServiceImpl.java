package com.example.campus_second_hand_trading_platform.service.impl;

import com.example.campus_second_hand_trading_platform.entity.Product;
import com.example.campus_second_hand_trading_platform.mapper.ProductMapper;
import com.example.campus_second_hand_trading_platform.service.IProductService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author qionghua
 * @since 2023-05-06
 */
@Service
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements IProductService {

}
