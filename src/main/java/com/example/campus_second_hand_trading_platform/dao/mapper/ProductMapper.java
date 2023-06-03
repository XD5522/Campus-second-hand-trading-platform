package com.example.campus_second_hand_trading_platform.dao.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.campus_second_hand_trading_platform.dao.entity.Product;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.campus_second_hand_trading_platform.domain.dto.AddProductDTO;
import com.example.campus_second_hand_trading_platform.domain.vo.ProductCardVo;
import com.example.campus_second_hand_trading_platform.domain.vo.ProductVo;
import org.apache.ibatis.annotations.Mapper;

import javax.print.attribute.standard.PrinterURI;
import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author cc
 * @since 2023-05-06
 */
@Mapper
public interface ProductMapper extends BaseMapper<Product> {
    IPage<ProductVo> searchProducts(IPage<ProductVo> page,String name,String order);
    ProductVo SelectProductById(int id);

    IPage<ProductCardVo> SelectProductByUserId(IPage<ProductCardVo> page,int id);
    int ChangeProductState(int id,String state);
}
