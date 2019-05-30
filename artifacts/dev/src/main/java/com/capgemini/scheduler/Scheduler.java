package com.capgemini.scheduler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.capgemini.mapper.SchedulerMapper;

@Component
public class Scheduler {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	SchedulerMapper schedulerMapper;

	//删除accure_records表中大于一年的数据，每个月的15号执行一次
	@Scheduled(cron="0 0 0 15 * ?")
	public void deleteExpiredRecord() {
		schedulerMapper.deleteExpiredRecord();
	}
	
	//删除accure_records表中大于一年的数据，每个月的15号执行一次
	@Scheduled(cron="0 0 0 15 * ?")
	public void deleteExpiredProject() {
		schedulerMapper.deleteExpiredProject();
	}
	
	//删除accure_records表中大于一年的数据，每个月的15号执行一次
	@Scheduled(cron="0 0 0 15 * ?")
	public void deleteExpiredPo() {
		schedulerMapper.deleteExpiredPo();
	}
	
	//删除accure_records表中大于一年的数据，每个月的15号执行一次
	@Scheduled(cron="0 0 0 15 * ?")
	public void deleteExpiredRole() {
		schedulerMapper.deleteExpiredRole();
	}
	
	//删除accure_records表中大于一年的数据，每个月的15号执行一次
	@Scheduled(cron="0 0 0 15 * ?")
	public void deleteExpiredConsultant() {
		schedulerMapper.deleteExpiredConsultant();
	}
	
}
