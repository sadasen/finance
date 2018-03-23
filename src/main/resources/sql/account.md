

countByUser
===
	select count(0) from t_account where user_id = #userId#
	
selectListByUser
===
	select id, name, sort from t_account where user_id = #userId#
	order by sort
	
selectListByWay
===
	select a.id, a.name, a.sort from t_account a
	join t_way_account b on a.id = b.account_id
	where b.way_id = #wayId# and a.user_id = #userId#
	order by a.sort
	
selectListByNotInWay
===
	select a.id, a.name, a.sort from t_account a
	left join t_way_account b on a.id = b.account_id
	where b.way_id is null and a.user_id = #userId#
	order by a.sort
	