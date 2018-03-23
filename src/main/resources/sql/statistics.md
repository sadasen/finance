selectTotalToday
===
	select ifnull(sum(amount), 0) from t_record
	where
	rdate = CURRENT_DATE() and type = #type# and user_id = #userId#

selectTotalByTimeArea
===
	select ifnull(sum(amount), 0) from t_record
	where 
	record_date between #startDate# and #endDate# and type = #type# and user_id = #userId#