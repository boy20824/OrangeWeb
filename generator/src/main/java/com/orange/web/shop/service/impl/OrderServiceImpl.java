package com.orange.web.shop.service.impl;

import com.orange.web.shop.model.Order;
import com.orange.web.shop.mapper.OrderMapper;
import com.orange.web.shop.service.IOrderService;
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
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements IOrderService {

}
