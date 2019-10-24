package com.entor.service;

import com.entor.entity.Collegeclass;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.annotations.Select;
import org.springframework.web.bind.annotation.RequestMapping;

import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lichaohua
 * @since 2019-10-22
 */
public interface ICollegeclassService extends IService<Collegeclass> {
	
	/**
	 * 有什么学院
	 * @return
	 */
	public List<Collegeclass> queryCollege();
	/**
	 * 学院里有什么班级
	 * @param college
	 * @return
	 */
	public List<Collegeclass> queryClass(String college);

	/**
	 * 删除学院
	 * @param request
	 * @return
	 */
		public void deleteCollege(String name) ;

	/**
	 * 修改学院
	 * @param collegeclass
	 * @return
	 */
		public void updateCollege(Collegeclass collegeclass) ;

	/**
	 * 添加班级
	 * @param collegeclass
	 * @return
	 */
		public void addClass(Collegeclass collegeclass) ;

	/**
	 * 删除班级
	 * @param id
	 * @return
	 */
		public void deleteClass(int id) ;

	/**
	 * 修改班级
	 * @param collegeclass
	 * @return
	 */
		public void updateClass(Collegeclass collegeclass);
}
