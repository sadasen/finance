分类表操作

最大的code

findMaxCodeByParentId
===
	select MAX(code) from account_consume
	where 
	type = #type# and parent_id = #parentId#
	
countByParentId
===
	select count(0) from account_consume
	where
	parent_id = #parentId#
	