package com.entor.mapper;

import com.entor.entity.User;

import org.apache.ibatis.annotations.Mapper;

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
public interface UserMapper extends BaseMapper<User> {

}