package com.example.campus_second_hand_trading_platform.dao.Repository;

import com.example.campus_second_hand_trading_platform.dao.entity.Product;
import com.example.campus_second_hand_trading_platform.dao.mapper.ProductMapper;
import com.example.campus_second_hand_trading_platform.domain.dto.AddProductDTO;
import com.example.campus_second_hand_trading_platform.domain.vo.ProductVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductRepository {
    ProductMapper productMapper;
    @Autowired
    public ProductRepository(ProductMapper productMapper) {
        this.productMapper = productMapper;
    }

    public List<ProductVo> SearchProducts(String name){
        return productMapper.SearchProducts(name);
    }
    public ProductVo SelectProductById(int id){
        return productMapper.SelectProductById(id);
    }


}
