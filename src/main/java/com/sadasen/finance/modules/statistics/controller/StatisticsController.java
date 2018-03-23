package com.sadasen.finance.modules.statistics.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sadasen.core.response.JsonResult;
import com.sadasen.finance.base.BaseController;
import com.sadasen.finance.modules.statistics.service.StatisticsService;
import com.sadasen.finance.util.Utils;

/**
 * @date 2018年3月23日
 * @author lei.ys
 * @addr company
 * @desc
 */
@RestController
@RequestMapping("/statistics")
public class StatisticsController extends BaseController {
	
	private static final long serialVersionUID = -2004982525225925956L;
	
	@Autowired
	private StatisticsService statisticsService;

	@RequestMapping("/index")
	public JsonResult index(int type) {
		long userId = Utils.getLoginUserId(getRequest());
		Map<String, String> data = new HashMap<>();
		data.put("todayAmount", statisticsService.findTotalToday(userId, type)+"");
		return JsonResult.instance(data);
	}

}
