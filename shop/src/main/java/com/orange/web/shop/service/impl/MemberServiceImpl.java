package com.orange.web.shop.service.impl;


import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.orange.web.shop.mapper.MemberMapper;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.orange.web.shop.model.Member;
import com.orange.web.shop.service.IMemberService;

import org.springframework.beans.factory.annotation.Autowired;
import com.orange.web.shop.utils.ServiceException;
import com.orange.web.shop.vo.RegisterVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author John
 * @since 2022-04-30
 */
@Service
@Slf4j
public class MemberServiceImpl extends ServiceImpl<MemberMapper, Member> implements IMemberService {

    @Resource
    MemberMapper memberMapper;

	@Override
	public Member getMemberByEmail(String email) {
		Member member = memberMapper.selectMemberByEmail(email);
		return member;
	}

    BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    @Override
    @Transactional
    public void registerMember(RegisterVo registerVo) {
        if (registerVo == null) {
            log.info("方法參數為空");
            throw ServiceException.unprocessableEntity("參數為空!!");
        }
        log.info("方法參數{}", registerVo);

        Member member=new Member();
        //密碼加密
        String password = bCryptPasswordEncoder.encode(registerVo.getPwd());
        String birthday=registerVo.getBirthday();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        // parsing the string to convert it into date
        LocalDate birthdayLocalDate = LocalDate.parse(birthday, formatter);
        member.setMemberNo("")
                .setAccount(registerVo.getAccount())
                .setPwd("{bcrypt}"+password)
                .setLoginType(registerVo.getLoginType())  //orange/instagram/facebook
                .setPhoneNumber(registerVo.getPhoneNumber())
                .setAddress(registerVo.getAddress())
                .setGender(registerVo.getGender())
                .setBirthday(birthdayLocalDate)
                .setDateCreated(LocalDateTime.now())
                .setEmail(registerVo.getEmail().toLowerCase())
                .setName(registerVo.getName());

        log.info("Member 資訊: {}",member);
        int rows = memberMapper.insert(member);
        if (rows != 1) {
            log.info("保存用戶訊息失敗");
            throw new ServiceException("數據庫繁忙,請稍後在試");
        }
        //建立會員編號
        String memberNo="M"+String.format("%09d", member.getId());
        UpdateWrapper<Member> updateWrapper=new UpdateWrapper<>();
        updateWrapper.eq("id",member.getId());
        member.setMemberNo(memberNo);
         rows = memberMapper.update(member,updateWrapper);
        if (rows != 1) {
            log.info("保存用戶訊息失敗");
            throw new ServiceException("數據庫繁忙,請稍後在試");
        }


    }

}
