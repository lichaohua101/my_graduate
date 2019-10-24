package com.entor.service.impl;

import com.entor.entity.Classroom;
import com.entor.mapper.ClassroomMapper;
import com.entor.service.IClassroomService;
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
public class ClassroomServiceImpl extends ServiceImpl<ClassroomMapper, Classroom> implements IClassroomService {
	
	@Autowired
	private ClassroomMapper classroomMapper; 
	
	/**
	 * 添加一个实验室
	 * @param classroom
	 * @return
	 */
	@Override
	public void addClass(Classroom classroom) {
		insert(classroom);
	}
	/**
	 * 删除一个实验室
	 * @param classroom
	 * @return
	 */
	@Override
	public void deleteClass(int id) {
		deleteById(id);
	}
	/**
	 * 修改一个实验室
	 * @param classroom
	 * @return
	 */
	@Override
	public void updateClass(Classroom classroom) {
		Wrapper<Classroom> wrapper = new  EntityWrapper<Classroom>();
		wrapper.eq(Classroom.ID, classroom.getId());
		update(classroom, wrapper);
	}
	/**
	 * 查询所有实验室
	 * @param classroom
	 * @return
	 */
	@Override
	public List<Classroom> queryAllClass() {
		Wrapper<Classroom> wrapper = new EntityWrapper<>();
		return classroomMapper.selectList(wrapper);
	}
	
}
