package com.sadasen.finance.modules.consume.dao;

import org.beetl.sql.core.annotatoin.Param;
import org.beetl.sql.core.mapper.BaseMapper;

import com.sadasen.finance.modules.consume.entity.Consume;

/**
 * @date 2018年3月8日
 * @author lei.ys
 * @addr company
 * @desc
 */
public interface ConsumeDao extends BaseMapper<Consume> {
	
	public String findMaxCodeByParentId(@Param("type") int type, @Param("parentId") long parentId);
	
	public int countByParentId(@Param("parentId") long parentId);

}
