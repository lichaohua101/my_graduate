package com.entor.service.impl;

import com.entor.entity.User;
import com.entor.mapper.UserMapper;
import com.entor.service.IUserService;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

import java.util.List;

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
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {
	
	@Autowired
	private UserMapper userMapper;
	
	/**
	 * 根据学号查用户
	 * @param username
	 * @return
	 */
	@Override
	public User queryUserByUsername(String username) {
		Wrapper<User> wrapper = new EntityWrapper<>();
		wrapper.eq(User.USERNAME, username);
		List<User> list = selectList(wrapper);
		if (list!=null&&!list.isEmpty()) {
			return list.get(0);
		}
		return null;
	}
	
	/**
	 * 添加用户
	 * @param user
	 */
	@Override
	public void add(User user) {
		insert(user);
	}
	
}
