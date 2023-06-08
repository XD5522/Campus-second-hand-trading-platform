package com.example.campus_second_hand_trading_platform.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.campus_second_hand_trading_platform.dao.entity.Product;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.campus_second_hand_trading_platform.domain.vo.ProductCardVo;
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
    public IPage<ProductVo> SearchProducts(String name,String order,String asc,int current,int num);
    public ProductVo SelectProductById(int id);

    /**
     * 通过用户id分页查询商品列表
     * @param user_id
     * @param PageSize
     * @param PageNum
     * @return
     */
    public IPage<ProductCardVo> SelectProductByUserId(int user_id,int PageSize, int PageNum);

    /**
     * 修改商品状态
     * @param product_id
     * @param state
     */
    public int ChangeProductState(int product_id,String state);

    public int getUserCountByProduct(int productId);
}
