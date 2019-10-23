package com.entor.mapper;

import com.entor.entity.UserDetails;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.baomidou.mybatisplus.mapper.BaseMapper;

/**
 * <p>
  *  Mapper 接口
 * </p>
 *
 * @author lichaohua
 * @since 2019-10-22
 */
@Mapper
public interface UserDetailsMapper extends BaseMapper<UserDetails> {
	
	/**
	 * 获取用户的最后次登录详情
	 * @param uid
	 * @return
	 */
	@Select("SELECT * FROM user_details where uid=#{uid} and id=(SELECT MAX(id) FROM user_details WHERE uid=#{uid})")
	public UserDetails queryLastUserD(int uid);
}