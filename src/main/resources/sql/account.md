

countByUser
===
	select count(0) from t_account where user_id = #userId#
	
selectListByUser
===
	select id, name, sort from t_account where user_id = #userId#
	