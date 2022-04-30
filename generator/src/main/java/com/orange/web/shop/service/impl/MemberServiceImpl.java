package com.orange.web.shop.service.impl;

import com.orange.web.shop.model.Member;
import com.orange.web.shop.mapper.MemberMapper;
import com.orange.web.shop.service.IMemberService;
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
public class MemberServiceImpl extends ServiceImpl<MemberMapper, Member> implements IMemberService {

}
