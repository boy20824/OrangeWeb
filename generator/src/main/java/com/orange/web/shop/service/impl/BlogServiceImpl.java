package com.orange.web.shop.service.impl;

import com.orange.web.shop.model.Blog;
import com.orange.web.shop.mapper.BlogMapper;
import com.orange.web.shop.service.IBlogService;
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
public class BlogServiceImpl extends ServiceImpl<BlogMapper, Blog> implements IBlogService {

}
