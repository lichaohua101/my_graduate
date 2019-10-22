package com.entor.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author lichaohua
 * @since 2019-10-22
 */
@Controller
public class UserController {
	
	//跳转到用户注册页面checkUsername
	@RequestMapping("/userRegister")
	public String userRegister() {
		return "register/userRegister";
	}
	//跳转到用户注册页面checkUsername
	@RequestMapping("/AdminRegister")
	public String AdminRegister() {
		return "register/userRegister";
	}
	
}
