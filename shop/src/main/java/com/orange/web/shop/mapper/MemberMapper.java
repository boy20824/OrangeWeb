package com.orange.web.shop.mapper;

import com.orange.web.shop.model.Member;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
* <p>
    *  Mapper 接口
    * </p>
*
* @author John
* @since 2022-04-30
*/

    @Repository
    public interface MemberMapper extends BaseMapper<Member> {

	Member selectMemberByEmail(String email);

    }
