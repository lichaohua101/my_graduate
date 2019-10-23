package com.entor.service;

import com.entor.entity.User;
import com.entor.mapper.UserMapper;

import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;

import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lichaohua
 * @since 2019-10-22
 */
public interface IUserService extends IService<User> {
	
	/**
	 * 根据学号查用户
	 * @param username
	 * @return
	 */
	public User queryUserByUsername(String username);
	/**
	 * 添加用户
	 * @param user
	 */
	public void add(User user);
	
}
