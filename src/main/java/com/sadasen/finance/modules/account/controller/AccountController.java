package com.sadasen.finance.modules.account.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sadasen.core.response.JsonResult;
import com.sadasen.finance.base.BaseController;
import com.sadasen.finance.modules.account.dto.AccountDto;
import com.sadasen.finance.modules.account.entity.Account;
import com.sadasen.finance.modules.account.service.AccountService;

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
	
	public JsonResult add(AccountDto dto) {
		Account account = new Account();
		account.setName(dto.getName());
		account = accountService.save(account);
		return JsonResult.instance(account);
	}

}
