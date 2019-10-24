package com.entor.service;

import com.entor.entity.ClassroomDetails;

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
public interface IClassroomDetailsService extends IService<ClassroomDetails> {
	
	/**
	 * 添加一次 实验室使用详情
	 * @param classroomDetails
	 * @return
	 */
	@RequestMapping("/addClassD")
	public void addClassD(ClassroomDetails classroomDetails) ;
	/**
	 * 删除一次 实验室使用详情
	 * @param classroomDetails
	 * @return
	 */
	@RequestMapping("/deleteClassD")
	public void deleteClassD(int id);
	/**
	 * 修改 一次 实验室使用详情
	 * @param classroomDetails
	 * @return
	 */
	@RequestMapping("/updateClassD")
	public void updateClassD(ClassroomDetails classroomDetails) ;
	/**
	 * 查询 实验室 的所有使用详情
	 * @param classroomDetails
	 * @return
	 */
	@RequestMapping("/queryAllById")
	public List<ClassroomDetails> queryAllById(int CRid) ;
	
}
