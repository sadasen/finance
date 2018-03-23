package com.sadasen.finance.modules.way.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sadasen.core.response.JsonResult;
import com.sadasen.core.response.status.Status;
import com.sadasen.finance.base.BaseController;
import com.sadasen.finance.modules.way.entity.Way;
import com.sadasen.finance.modules.way.service.WayService;
import com.sadasen.finance.util.Utils;

/**
 * @date 2018年3月8日
 * @author lei.ys
 * @addr company
 * @desc
 */
@RestController
@RequestMapping("/way")
public class WayController extends BaseController {

	private static final long serialVersionUID = -7152683041563523979L;
	@Autowired
	private WayService wayService;
	
	@PostMapping("/add")
	public JsonResult add(Way way) {
		way.setUserId(Utils.getLoginUserId(getRequest()));
		way = wayService.save(way);
		if(-1L==way.getId()) {
			return JsonResult.instance(Status.REQUEST_LACK, "名称不能为空");
		}
		return JsonResult.instance("添加成功", way);
	}
	
	@RequestMapping("/listAll")
	public JsonResult listAll() {
		List<Way> data = wayService.findListByUser(Utils.getLoginUserId(getRequest()));
		if(null==data) {
			data = new ArrayList<>();
		}
		return JsonResult.instance(data);
	}

}
