package com.example.campus_second_hand_trading_platform.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.campus_second_hand_trading_platform.dao.entity.Product;
import com.example.campus_second_hand_trading_platform.dao.mapper.ProductMapper;
import com.example.campus_second_hand_trading_platform.domain.vo.ProductCardVo;
import com.example.campus_second_hand_trading_platform.domain.vo.ProductVo;
import com.example.campus_second_hand_trading_platform.service.IProductService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author cc
 * @since 2023-05-06
 */
@Service
@Slf4j
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements IProductService {
    ProductMapper productMapper;

    @Autowired
    public ProductServiceImpl(ProductMapper productMapper) {
        this.productMapper=productMapper;
    }

    @Override
    public IPage<ProductVo> SearchProducts(String name,int current,int num){
        IPage<ProductVo> page = new Page<ProductVo>(current,num);
        log.info(name);
        return productMapper.searchProducts(page,name);
    }

    @Override
    public ProductVo SelectProductById(int id){
        return productMapper.SelectProductById(id);
    }

    @Override
    public IPage<ProductCardVo> SelectProductByUserId(int user_id, int PageSize, int PageNum) {
        IPage<ProductCardVo> page = new Page<>(PageNum,PageSize);
        return productMapper.SelectProductByUserId(page,user_id);
    }

    @Override
    public int ChangeProductState(int product_id, String state) {
        return productMapper.ChangeProductState(product_id,state);
    }


}
