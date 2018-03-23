package com.sadasen.finance.modules.statistics.dao;

import org.beetl.sql.core.annotatoin.Param;
import org.beetl.sql.core.mapper.BaseMapper;

import com.sadasen.finance.modules.statistics.dto.StatsPara;
import com.sadasen.finance.modules.statistics.entity.Statistics;

/**
 * @date 2018年3月23日
 * @author lei.ys
 * @addr company
 * @desc
 */
public interface StatisticsDao extends BaseMapper<Statistics> {
	
	public long selectTotalToday(@Param("userId") long userId, @Param("type") int type);

	public long selectTotalByTimeArea(StatsPara para);
	
	public long selectTotalAll(StatsPara para);

	public long selectAvgAll(StatsPara para);

}
