package com.sadasen.finance.consume.service;

import com.sadasen.finance.consume.entity.Consume;

/**
 * @date 2018年3月8日
 * @author lei.ys
 * @addr company
 * @desc
 */
public interface ConsumeService {
	
	public Consume save(Consume consume);
	
	public Consume findById(long id);
	
	public String getMaxCodeByParent(long id);

}
