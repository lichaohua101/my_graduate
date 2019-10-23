package com.entor.service.impl;

import com.entor.entity.Collegeclass;
import com.entor.mapper.CollegeclassMapper;
import com.entor.service.ICollegeclassService;
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
public class CollegeclassServiceImpl extends ServiceImpl<CollegeclassMapper, Collegeclass> implements ICollegeclassService {
	
	@Autowired
	private CollegeclassMapper collegeclassMapper;
	
	/**
	 * 有什么学院
	 * @return
	 */
	@Override
	public List<Collegeclass> queryCollege() {
		return collegeclassMapper.queryCollege();
	}
	/**
	 * 学院里有什么班级
	 * @param college
	 * @return
	 */
	@Override
	public List<Collegeclass> queryClass(String college) {
		return collegeclassMapper.queryClass(college);
	}
	
	
	
}
