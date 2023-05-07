package com.example.campus_second_hand_trading_platform.dao.mapper;

import com.example.campus_second_hand_trading_platform.dao.entity.Product;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
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
    List<ProductVo> SelectProductByName(String name);
}
