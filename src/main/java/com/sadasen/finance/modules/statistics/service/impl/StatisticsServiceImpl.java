package com.sadasen.finance.modules.statistics.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sadasen.finance.modules.statistics.dao.StatisticsDao;
import com.sadasen.finance.modules.statistics.service.StatisticsService;

/**
 * @date 2018年3月23日
 * @author lei.ys
 * @addr company
 * @desc
 */
@Service
public class StatisticsServiceImpl implements StatisticsService {
	
	@Autowired
	private StatisticsDao statisticsDao;

	@Override
	public int findTotalToday(long userId, int type) {
		return statisticsDao.selectTotalToday(userId, type);
	}

}
