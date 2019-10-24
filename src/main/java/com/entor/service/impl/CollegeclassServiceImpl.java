package com.entor.service.impl;

import com.entor.entity.Collegeclass;
import com.entor.mapper.CollegeclassMapper;
import com.entor.service.ICollegeclassService;
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
 * @since 2019-10-22
 */
@Service
public class CollegeclassServiceImpl extends ServiceImpl<CollegeclassMapper, Collegeclass> implements ICollegeclassService {
	
	@Autowired
	private CollegeclassMapper collegeclassMapper;
	
	/**
	 * 有什么学院
	 * @return
	 */
	@Override
	public List<Collegeclass> queryCollege() {
		return collegeclassMapper.queryCollege();
	}
	/**
	 * 学院里有什么班级
	 * @param college
	 * @return
	 */
	@Override
	public List<Collegeclass> queryClass(String college) {
		return collegeclassMapper.queryClass(college);
	}
	/**
	 * 删除学院
	 * @param request
	 * @return
	 */
	@Override
	public void deleteCollege(String name) {
		Wrapper<Collegeclass> wrapper = new EntityWrapper<>();
		wrapper.eq(Collegeclass.COLLEGE, name);
		collegeclassMapper.delete(wrapper);
	}
	/**
	 * 修改学院
	 * @param collegeclass
	 * @return
	 */
	@Override
	public void updateCollege(Collegeclass collegeclass) {
		//修改之前的 学院名字
		String before = collegeclassMapper.selectById(collegeclass.getId()).getCollege();
		collegeclassMapper.updateCollege(before, collegeclass.getCollege());
	}
	/**
	 * 添加班级
	 * @param collegeclass
	 * @return
	 */
	@Override
	public void addClass(Collegeclass collegeclass) {
		collegeclassMapper.insert(collegeclass);
	}
	/**
	 * 删除班级
	 * @param id
	 * @return
	 */
	@Override
	public void deleteClass(int id) {
		collegeclassMapper.deleteById(id);
	}
	/**
	 * 修改班级
	 * @param collegeclass
	 * @return
	 */
	@Override
	public void updateClass(Collegeclass collegeclass) {
		collegeclassMapper.updateById(collegeclass);
	}
	
	
	
}
