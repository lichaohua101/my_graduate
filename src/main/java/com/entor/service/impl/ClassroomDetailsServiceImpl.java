package com.entor.service.impl;

import com.entor.entity.ClassroomDetails;
import com.entor.mapper.ClassroomDetailsMapper;
import com.entor.service.IClassroomDetailsService;
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
 * @since 2019-10-23
 */
@Service
public class ClassroomDetailsServiceImpl extends ServiceImpl<ClassroomDetailsMapper, ClassroomDetails> implements IClassroomDetailsService {
	
	@Autowired
	private ClassroomDetailsMapper cDM;
	
	/**
	 * 添加一次 实验室使用详情
	 * @param classroomDetails
	 * @return
	 */
	@Override
	public void addClassD(ClassroomDetails classroomDetails) {
		cDM.insert(classroomDetails);
	}
	/**
	 * 删除一次 实验室使用详情
	 * @param classroomDetails
	 * @return
	 */
	@Override
	public void deleteClassD(int id) {
		cDM.deleteById(id);
	}
	/**
	 * 修改 一次 实验室使用详情
	 * @param classroomDetails
	 * @return
	 */
	@Override
	public void updateClassD(ClassroomDetails classroomDetails) {
		cDM.updateById(classroomDetails);
	}
	/**
	 * 查询 实验室 的所有使用详情
	 * @param classroomDetails
	 * @return
	 */
	@Override
	public List<ClassroomDetails> queryAllById(int CRid) {
		Wrapper<ClassroomDetails> wrapper = new EntityWrapper<>();
		wrapper.eq(ClassroomDetails.CLASSROOMID, CRid);
		return cDM.selectList(wrapper);
	}
	
}
