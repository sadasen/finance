用户表操作

用户登录

findToLogin
===

	select id, user_name, nick_name, reg_time from sys_user
	where 
	user_name = #userName# and password = #password#