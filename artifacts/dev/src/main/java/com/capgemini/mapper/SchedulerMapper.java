package com.capgemini.mapper;

public interface SchedulerMapper {

	//删除超过一年的accrued record
	int deleteExpiredRecord();
	
	//删除超过一年的projectInfo
	int deleteExpiredProject();
		
	//删除超过一年的poInfo
	int deleteExpiredPo();
		
	//删除超过一年的roleInfo
	int deleteExpiredRole();
		
	//删除超过一年的consultantInfo
	int deleteExpiredConsultant();
}
