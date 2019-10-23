package com.entor.web;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.entor.entity.UserDetails;
import com.entor.service.IUserDetailsService;


/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author lichaohua
 * @since 2019-10-22
 */
@Controller
public class UserDetailsController {
	
	@Autowired
	private IUserDetailsService userDetailsService;
	
	//添加用户注册成功  的详情
	@RequestMapping("/addUserD")
	public String addUserD(int uid) {
		userDetailsService.addUserD(uid);
		return "";
	}
	//获取用户的最后次登录详情
	@RequestMapping("/queryLastUserD")
	public String queryLastUserD(int uid) {
		UserDetails userDetails = userDetailsService.queryLastUserD(uid);
		return "";
	}
	//修改 用户登录详情
	@RequestMapping("/updateLastUserD")
	public String updateLastUserD(UserDetails userDetails) {
		userDetailsService.updateLastUserD(userDetails);
		return "";
	}
	//删除一个用户的 登录详情
	@RequestMapping("/deleteUserDById")
	public String deleteUserDById(int id) {
		userDetailsService.deleteUserDById(id);
		return "";
	}
}
