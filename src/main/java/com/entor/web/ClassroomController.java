package com.entor.web;


import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.entor.entity.Classroom;
import com.entor.service.IClassroomService;
import com.entor.service.impl.ClassroomServiceImpl;


/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author lichaohua
 * @since 2019-10-23
 */
@Controller
public class ClassroomController {
	
	@Autowired
	private IClassroomService classroomService;
	
	/**
	 * 添加一个实验室
	 * @param classroom
	 * @return
	 */
	@RequestMapping("/addClass")
	public String addClass(Classroom classroom) {
		classroomService.addClass(classroom);
		return "redirect:queryAllClass";
	}
	/**
	 * 删除一个实验室
	 * @param classroom
	 * @return
	 */
	@RequestMapping("/deleteClass")
	public String deleteClass(int id,HttpServletRequest request) {
		id=Integer.parseInt(request.getParameter("id"));
		classroomService.deleteClass(id);
		return "redirect:queryAllClass";
	}
	/**
	 * 修改一个实验室
	 * @param classroom
	 * @return
	 */
	@RequestMapping("/updateClass")
	public String updateClass(HttpServletRequest request,Model model) {
		int id = Integer.parseInt(request.getParameter("id"));
		Classroom classroom = classroomService.selectById(id);
		model.addAttribute("classroom", classroom);
		System.out.println(classroom);
		return "classRoom/updateClassRoom";
	}
	@RequestMapping("/updateClassS")
	public String update(Classroom classroom) {
		classroomService.updateClass(classroom);
		return "redirect:queryAllClass";
	}
	/**
	 * 查询所有实验室
	 * @param classroom
	 * @return
	 */
	@RequestMapping("/queryAllClass")
	public String queryAllClass(Model model) {
		List<Classroom> list = classroomService.queryAllClass();
		model.addAttribute("list", list);
		return "classRoom/classRoom";
	}
	
}
