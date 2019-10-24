package com.entor.service;

import com.entor.entity.Classroom;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;

import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lichaohua
 * @since 2019-10-23
 */
public interface IClassroomService extends IService<Classroom> {
	/**
	 * 添加一个实验室
	 * @param classroom
	 * @return
	 */
	public void addClass(Classroom classroom) ;
	/**
	 * 删除一个实验室
	 * @param classroom
	 * @return
	 */
	public void deleteClass(int id) ;
	/**
	 * 修改一个实验室
	 * @param classroom
	 * @return
	 */
	public void updateClass(Classroom classroom) ;
	/**
	 * 查询所有实验室
	 * @param classroom
	 * @return
	 */
	public List<Classroom> queryAllClass() ;
	
}
