package com.sadasen.finance.modules.account.service;

import java.util.List;

import com.sadasen.finance.modules.account.entity.Account;

/**
 * @date 2018年3月8日
 * @author lei.ys
 * @addr company
 * @desc
 */
public interface AccountService {
	
	public Account save(Account account);
	
	public List<Account> findListByUser(long userId);

}
