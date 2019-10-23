package com.entor.web;

import java.io.IOException;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.entor.entity.User;
import com.entor.entity.UserDetails;
import com.entor.service.IUserDetailsService;
import com.entor.service.IUserService;

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
	
	@Autowired
	private IUserService userService;
	@Autowired
	private IUserDetailsService userDetailsService;
	private Subject subject ;
	
	//跳转到登录页面
	@RequestMapping("/login")
	public String login() {
		return "login";
	}
	//登录验证
	@RequestMapping("/loginCheck")
	public String loginCheck(User user,Map<String, Object>map) {
		System.out.println("明文密码"+user.getPassword());
		//加密，加盐，防止编译的密码相同而被破解
		SimpleHash hash = new SimpleHash("md5", user.getPassword(), "123",2);
		String enpassword = hash.toHex();
		System.out.println("经过md5方式加密并经过2次盐“123”的密文密码"+enpassword);
		UsernamePasswordToken token = new UsernamePasswordToken(user.getUsername(),enpassword);
		subject = SecurityUtils.getSubject();
		try {
			subject.login(token);
			return "redirect:/classStudents";
		}catch(Exception e) {
			map.put("msg", "账号或者密码错误");
			return "forward:/login";
		}
	}
	//登录成功
	@RequestMapping("/classStudents")
	public String classStudents() {
		//获取当前登录的用户
		subject = SecurityUtils.getSubject();
		User user = (User)subject.getPrincipal();
		//创建用户新的 登录信息  添加登录时间   登录状态
		UserDetails userDetails = new UserDetails();
		userDetails.setUid(user.getId());
		userDetails.setLoginTime(new Date());
		userDetails.setOnline(1);
		userDetailsService.addUserD(user.getId());
		//获取要修改的Id
		userDetails = userDetailsService.queryLastUserD(user.getId());
		//修改，添加登录时间   登录状态
		userDetails.setLoginTime(new Date());
		userDetails.setOnline(1);
		userDetailsService.updateLastUserD(userDetails);
		return "redirect:/queryCollege";
	}
	//注销用户
	@RequestMapping("/logout")
	public String logout() {
		//获取当前登录的用户
		subject = SecurityUtils.getSubject();
		User user = (User)subject.getPrincipal();
		UserDetails userDetails = userDetailsService.queryLastUserD(user.getId());
		
		//添加用户 注销的世间  登录状态
		userDetails.setExitTime(new Date());
		userDetails.setOnline(0);
		userDetailsService.updateLastUserD(userDetails);
		
		subject.logout();
		return "redirect:/login";
	}
	
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
	// 校验学号是否已经别注册
	@RequestMapping("/checkUsername")
	@ResponseBody
	public int checkUsername(HttpServletRequest request, HttpServletResponse response, Map<String, Object> map)throws IOException {
		String username = request.getParameter("username");
		User user = userService.queryUserByUsername(username);
		int msg = 1;
		System.out.println(username);
		if (user == null) {
			msg = 0;
		}
		return msg;
	}
	// 添加用户(admin,user)
	@RequestMapping("/addUser")
	public String addUser(User user) {
		//获取当前用户
		subject = SecurityUtils.getSubject();
		User user2 = (User) subject.getPrincipal();
		//注册加密
		SimpleHash hash = new SimpleHash("md5", user.getPassword(), "123", 2);
		String enpassword = hash.toHex();
		user.setPassword(enpassword);
		userService.add(user);
		System.out.println("注册成功：" + user);
		//添加用户 第一次登录信息
	    userDetailsService.addUserD(user.getId());
		//如果是登录状态添加用户，返回当前状态
		if (user2 == null) {
			return "redirect:/login";
		} else {
			return "redirect:/classStudents";
		}
	}

}
