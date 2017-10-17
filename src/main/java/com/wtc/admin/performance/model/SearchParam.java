package com.wtc.admin.performance.model;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class SearchParam extends Page {
	// 开始日期
	private String startDateStr;
	// 结束日期
	private String endDateStr;
	
	// 开始日期
	private Date startDate;
	// 结束日期
	private Date endDate;
	
	// 商家名称
	private String businessName;
	// 商家PID
	private String businessPID;
	// 归属员工姓名
	private String empName;
	//activeClientNumColumn
	private List<ActiveClientNumColumn> list;
}
