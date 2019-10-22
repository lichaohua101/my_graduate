package com.entor.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.activerecord.Model;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author lichaohua
 * @since 2019-10-22
 */
public class Collegeclass extends Model<Collegeclass> {

    private static final long serialVersionUID = 1L;

    /**
     * 班级id
     */
	@TableId(value="id", type= IdType.AUTO)
	private Integer id;
    /**
     * 学院名字
     */
	private String college;
    /**
     * 班级名字
     */
	private String className;
    /**
     * 老师id
     */
	private Integer teacher;


	public Integer getId() {
		return id;
	}

	public Collegeclass setId(Integer id) {
		this.id = id;
		return this;
	}

	public String getCollege() {
		return college;
	}

	public Collegeclass setCollege(String college) {
		this.college = college;
		return this;
	}

	public String getClassName() {
		return className;
	}

	public Collegeclass setClassName(String className) {
		this.className = className;
		return this;
	}

	public Integer getTeacher() {
		return teacher;
	}

	public Collegeclass setTeacher(Integer teacher) {
		this.teacher = teacher;
		return this;
	}

	public static final String ID = "id";

	public static final String COLLEGE = "college";

	public static final String CLASSNAME = "className";

	public static final String TEACHER = "teacher";

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "Collegeclass{" +
			", id=" + id +
			", college=" + college +
			", className=" + className +
			", teacher=" + teacher +
			"}";
	}
}
