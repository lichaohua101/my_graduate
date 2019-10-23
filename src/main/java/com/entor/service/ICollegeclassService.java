package com.entor.service;

import com.entor.entity.Collegeclass;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lichaohua
 * @since 2019-10-22
 */
public interface ICollegeclassService extends IService<Collegeclass> {
	
	/**
	 * 有什么学院
	 * @return
	 */
	public List<Collegeclass> queryCollege();
	/**
	 * 学院里有什么班级
	 * @param college
	 * @return
	 */
	public List<Collegeclass> queryClass(String college);
	
}
