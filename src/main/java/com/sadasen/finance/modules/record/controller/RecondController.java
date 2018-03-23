package com.sadasen.finance.modules.record.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sadasen.core.response.JsonResult;
import com.sadasen.finance.base.BaseController;
import com.sadasen.finance.modules.record.entity.Record;
import com.sadasen.finance.modules.record.service.RecordService;
import com.sadasen.finance.modules.record.vo.RecordInfo;
import com.sadasen.finance.util.Utils;
import com.sadasen.util.DateUtil;

/**
 * @date 2018年3月23日
 * @author lei.ys
 * @addr company
 * @desc
 */
@RestController
@RequestMapping("/record")
public class RecondController extends BaseController {

	private static final long serialVersionUID = -5615248355788811605L;
	
	@Autowired
	private RecordService recordService;
	
	public JsonResult add(Record record) {
		record = recordService.save(record);
		return JsonResult.instance("记账成功", record);
	}
	
	@RequestMapping("/list/{endDate}")
	public JsonResult listAll(Record record, String endDate) {
		record.setUserId(Utils.getLoginUserId(getRequest()));
		Date temp = DateUtil.stringToDateFormat(endDate, "yyyyMMdd");
		endDate = DateUtil.dateToStringFormat(temp, "yyyy-MM-dd");
		record.setRecordData(endDate);
		List<RecordInfo> data = recordService.listAll(record);
		return JsonResult.instance(data);
	}
	
}
