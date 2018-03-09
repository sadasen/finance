package com.sadasen.finance.modules.account.service.impl;

import java.util.Date;

import org.beetl.sql.core.SQLManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sadasen.finance.modules.account.entity.Account;
import com.sadasen.finance.modules.account.service.AccountService;
import com.sadasen.util.StringUtil;

/**
 * @date 2018年3月8日
 * @author lei.ys
 * @addr company
 * @desc
 */
@Service
public class AccountServiceImpl implements AccountService {
	
	@Autowired
	private SQLManager sqlManager;

	@Override
	public Account save(Account account) {
		if(StringUtil.isEmpty(account.getName())) {
			account.setId(-1L);
			return account;
		}
		account.setCreateTime(new Date());
		account.setHasWay(0);
		int r = sqlManager.insertTemplate(account, true);
		if(1==r) {
			return account;
		}
		return null;
	}

}
