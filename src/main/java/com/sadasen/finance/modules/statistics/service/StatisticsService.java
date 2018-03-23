package com.sadasen.finance.modules.statistics.service;

import com.sadasen.finance.modules.statistics.dto.StatsPara;

/**
 * @date 2018年3月23日
 * @author lei.ys
 * @addr company
 * @desc
 */
public interface StatisticsService {
	
	public long findTotalToday(long userId, int type);

	public long getTotalMonth(StatsPara para);

	public long getAvgMonth(StatsPara para);

	public long getTotalAll(StatsPara para);

	public long getAvgAll(StatsPara para);

}
