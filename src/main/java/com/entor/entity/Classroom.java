package com.entor.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
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
public class Classroom extends Model<Classroom> {

    private static final long serialVersionUID = 1L;

    /**
     * 教室id
     */
	@TableId(value="id", type= IdType.AUTO)
	private Integer id;
    /**
     * 教室名字
     */
	private String className;
    /**
     * 0可用，1不可以
     */
	private Integer state;
    /**
     * 教室开始使用的时间
     */
	private Date createTime;
    /**
     * 教室结束使用的时间
     */
	private Date exitTime;


	public Integer getId() {
		return id;
	}

	public Classroom setId(Integer id) {
		this.id = id;
		return this;
	}

	public String getClassName() {
		return className;
	}

	public Classroom setClassName(String className) {
		this.className = className;
		return this;
	}

	public Integer getState() {
		return state;
	}

	public Classroom setState(Integer state) {
		this.state = state;
		return this;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public Classroom setCreateTime(Date createTime) {
		this.createTime = createTime;
		return this;
	}

	public Date getExitTime() {
		return exitTime;
	}

	public Classroom setExitTime(Date exitTime) {
		this.exitTime = exitTime;
		return this;
	}

	public static final String ID = "id";

	public static final String CLASSNAME = "className";

	public static final String STATE = "state";

	public static final String CREATETIME = "createTime";

	public static final String EXITTIME = "exitTime";

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "Classroom{" +
			", id=" + id +
			", className=" + className +
			", state=" + state +
			", createTime=" + createTime +
			", exitTime=" + exitTime +
			"}";
	}
}
