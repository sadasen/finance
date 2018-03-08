package com.sadasen.finance.way.entity;

import java.util.Date;

import org.beetl.sql.core.annotatoin.Table;

import com.sadasen.finance.base.BaseBean;

/**
 * @date 2018年3月8日
 * @author lei.ys
 * @addr company
 * @desc
 */
@Table(name="t_way")
public class Way extends BaseBean {

	private static final long serialVersionUID = 2487804878858971425L;
	
	private long id;
	private String name;
	private Date createTime;
	
	public Way() {
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

}
