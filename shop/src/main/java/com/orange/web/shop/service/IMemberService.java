package com.orange.web.shop.service;

import com.orange.web.shop.model.Member;
import com.baomidou.mybatisplus.extension.service.IService;
import com.orange.web.shop.vo.RegisterVo;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author John
 * @since 2022-04-30
 */
public interface IMemberService extends IService<Member> {
	
	public Member getMemberByEmail(String email);

    void registerMember(RegisterVo registerVo);

}
