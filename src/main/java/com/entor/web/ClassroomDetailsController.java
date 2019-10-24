package com.entor.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.entor.entity.ClassroomDetails;
import com.entor.service.IClassroomDetailsService;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author lichaohua
 * @since 2019-10-23
 */
@Controller
public class ClassroomDetailsController {
	
	@Autowired
	private IClassroomDetailsService cDS;
	
	/**
	 * 添加一次 实验室使用详情
	 * @param classroomDetails
	 * @return
	 */
	@RequestMapping("/addClassD")
	public String addClassD(ClassroomDetails classroomDetails) {
		return "mistake";
	}
	/**
	 * 删除一次 实验室使用详情
	 * @param classroomDetails
	 * @return
	 */
	@RequestMapping("/deleteClassD")
	public String deleteClassD(int id) {
		return "mistake";
	}
	/**
	 * 修改 一次 实验室使用详情
	 * @param classroomDetails
	 * @return
	 */
	@RequestMapping("/updateClassD")
	public String updateClassD(ClassroomDetails classroomDetails) {
		return "mistake";
	}
	/**
	 * 查询 实验室 的所有使用详情
	 * @param classroomDetails
	 * @return
	 */
	@RequestMapping("/queryAllById")
	public String queryAllById(int CRid) {
		return "mistake";
	}
	
}
