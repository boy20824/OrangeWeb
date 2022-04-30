package com.orange.web.shop.service.impl;

import com.orange.web.shop.model.Product;
import com.orange.web.shop.mapper.ProductMapper;
import com.orange.web.shop.service.IProductService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author John
 * @since 2022-04-30
 */
@Service
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements IProductService {

}
