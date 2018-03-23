selectTotalToday
===
	select ifnull(sum(amount), 0) from t_record
	where
	record_date = CURRENT_DATE() and type = #type# and user_id = #userId#

selectTotalByTimeArea
===
	select ifnull(sum(amount), 0) from t_record
	where 
	record_date between #startDate# and #endDate# and type = #type# and user_id = #userId#
	
selectTotalAll
===
	select ifnull(sum(amount), 0) from t_record
	where
	type = #type# and user_id = #userId#
	
selectAvgAll
===
	select ifnull(sum(amount),0)/(timestampdiff(day,min(record_date),current_date())+1) 
	from t_record
	where
	type = #type# and user_id = #userId#
	