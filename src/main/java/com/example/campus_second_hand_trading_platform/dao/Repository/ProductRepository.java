package com.example.campus_second_hand_trading_platform.dao.Repository;

import com.example.campus_second_hand_trading_platform.dao.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ProductRepository {
    ProductMapper productMapper;
    @Autowired
    public ProductRepository(ProductMapper productMapper) {
        this.productMapper = productMapper;
    }
}
