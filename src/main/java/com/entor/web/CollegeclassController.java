package com.entor.web;


import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.entor.entity.Collegeclass;
import com.entor.service.ICollegeclassService;


/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author lichaohua
 * @since 2019-10-22
 */
@Controller
public class CollegeclassController {
	
	@Autowired
	private ICollegeclassService collegeclassService;
	//有什么学院
	@RequestMapping("/queryCollege")
	private String queryCollege(Model model) {
		List<Collegeclass> list =  collegeclassService.queryCollege();
		model.addAttribute("list1", list);
		return "class/collegeClass";
	}
	//学院里有哪些班级
	@RequestMapping("/queryClass")
	private String queryClass(HttpServletRequest request,Model model) {
		String college = request.getParameter("collegeName");
		List<Collegeclass> list =  collegeclassService.queryClass(college);
		model.addAttribute("list2", list);
		return "class/collegeClass";
	}
	
	//删除学院
	@RequestMapping("/deleteCollege")
	public String deleteCollege(HttpServletRequest request) {
		String name = request.getParameter("Cname");
		collegeclassService.deleteCollege(name);
		return "redirect:queryCollege";
	}
	// 修改学院
	@RequestMapping("/updateCollege")
	public String updateCollege(Collegeclass collegeclass) {
		collegeclassService.updateCollege(collegeclass);
		return "redirect:queryCollege";
	}
	//添加班级
	@RequestMapping("/addCClass")
	public String addClass(Collegeclass collegeclass) {
		collegeclassService.addClass(collegeclass);
		return "redirect:queryClass";
	}
	//删除班级
	@RequestMapping("/deleteCClass")
	public String deleteClass(int id,HttpServletRequest request) {
		id = Integer.parseInt(request.getParameter("id"));
		collegeclassService.deleteClass(id);
		return "redirect:queryClass";
	}
	//修改班级
	@RequestMapping("/updateCClass")
	public String updateClass(Collegeclass collegeclass) {
		collegeclassService.updateClass(collegeclass);
		return "redirect:queryClass";
	}
	
	
}
