package com.entor.service.impl;

import com.entor.entity.UserDetails;
import com.entor.mapper.UserDetailsMapper;
import com.entor.service.IUserDetailsService;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lichaohua
 * @since 2019-10-22
 */
@Service
public class UserDetailsServiceImpl extends ServiceImpl<UserDetailsMapper, UserDetails> implements IUserDetailsService {
	
	@Autowired
	private UserDetailsMapper userDetailsMapper;
	
	/**
	 * 注册一个用户的详细
	 * @param uid
	 */
	@Override
	public void addUserD(int uid) {
		UserDetails uDetails= new UserDetails();
		uDetails.setUid(uid);
		uDetails.setCreateTime(new Date());
		insert(uDetails);
	}
	/**
	 * 获取用户的上一次登录详情
	 */
	@Override
	public UserDetails queryLastUserD(int uid) {
		return userDetailsMapper.queryLastUserD(uid);
	}
	/**
	 * 修改用户最后一次登录的详情
	 * @param userDetails
	 * @return
	 */
	@Override
	public void updateLastUserD(UserDetails userDetails) {
		Wrapper<UserDetails> wrapper = new EntityWrapper<>();
		wrapper.eq(UserDetails.ID, userDetails.getId());
		update(userDetails, wrapper);
	}
	/**
	 * 删除 一条用户登录记录
	 * @param id
	 */
	@Override
	public void deleteUserDById(int id) {
		deleteById(id);
	}
	
}
