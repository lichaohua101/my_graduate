package com.entor.service.impl;

import com.entor.entity.User;
import com.entor.mapper.UserMapper;
import com.entor.service.IUserService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
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
	
}
