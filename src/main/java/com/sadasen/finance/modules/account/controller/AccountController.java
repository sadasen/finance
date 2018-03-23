package com.sadasen.finance.modules.account.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sadasen.core.response.JsonResult;
import com.sadasen.core.response.status.Status;
import com.sadasen.finance.base.BaseController;
import com.sadasen.finance.modules.account.entity.Account;
import com.sadasen.finance.modules.account.service.AccountService;
import com.sadasen.finance.util.Utils;

/**
 * @date 2018年3月8日
 * @author lei.ys
 * @addr company
 * @desc
 */
@RestController
@RequestMapping("/account")
public class AccountController extends BaseController {

	private static final long serialVersionUID = 5650910228283975725L;
	
	@Autowired
	private AccountService accountService;
	
	@PostMapping("/add")
	public JsonResult add(Account account) {
		account.setUserId(Utils.getLoginUserId(getRequest()));
		try {
			account = accountService.save(account);
			if(-1==account.getId()) {
				return JsonResult.instance(Status.REQUEST_LACK, "名称不能为空");
			}
		} catch (Exception e) {
			e.printStackTrace();
			return JsonResult.instance(Status.SYSTEM_ERROR);
		}
		return JsonResult.instance(account);
	}

}
