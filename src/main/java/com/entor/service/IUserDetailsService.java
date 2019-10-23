package com.entor.service;

import com.entor.entity.UserDetails;
import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lichaohua
 * @since 2019-10-22
 */
public interface IUserDetailsService extends IService<UserDetails> {
	
	/**
	 * 注册一个用户的 登录详细
	 * @param uid
	 */
	public void addUserD(int uid);
	/**
	 * 获取用户的最后次登录详情
	 * @param uid
	 * @return
	 */
	public UserDetails queryLastUserD(int uid);
	/**
	 * 修改用户最后一次登录的详情
	 * @param userDetails
	 * @return
	 */
	public void updateLastUserD(UserDetails userDetails);
	/**
	 * 删除 一条用户登录记录
	 * @param id
	 */
	public void deleteUserDById(int id);
}
