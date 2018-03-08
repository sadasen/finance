package com.sadasen.finance.consume.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sadasen.finance.base.BaseController;
import com.sadasen.finance.consume.dto.ConsumeDto;
import com.sadasen.finance.consume.entity.Consume;
import com.sadasen.finance.consume.service.ConsumeService;
import com.sadasen.finance.util.Utils;
import com.sadasen.core.common.Consts;
import com.sadasen.core.common.JsonResult;

/**
 * @date 2018年3月8日
 * @author lei.ys
 * @addr company
 * @desc
 */
@RestController
@RequestMapping("/consume")
public class ConsumeController extends BaseController {

	private static final long serialVersionUID = 1452929117248745829L;
	
	@Autowired
	private ConsumeService consumeService;
	
	@PostMapping("/add")
	public JsonResult add(ConsumeDto consumeDto) {
		Consume consume = new Consume(consumeDto);
		consume.setUserId(Utils.getLoginUserId(getRequest()));
		consume = consumeService.save(consume);
		if(null==consume) {
			return new JsonResult("系统错误！", Consts.REQUEST_ERROR_CODE);
		} else if(-1L==consume.getId()) {
			return new JsonResult("请求无效！", Consts.REQUEST_FAILURE_CODE);
		}
		return new JsonResult(consume);
	}
	
	@GetMapping("/listByParent/{type}/{parentId}")
	public JsonResult list(@PathVariable("type") int type, @PathVariable("parentId") long parentId) {
		Utils.printInfo("list success");
		return new JsonResult(new ArrayList<>());
	}

}