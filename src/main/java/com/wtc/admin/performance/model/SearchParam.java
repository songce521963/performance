package com.wtc.admin.performance.model;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class SearchParam {
	// 开始拓展日期
	private String startExpandTimeStr;
	// 结束拓展日期
	private String endExpandTimeStr;
	
	// 开始日期
	private Date startExpandTime;
	// 结束日期
	private Date endExpandTime;
	
	// 日期
	private String startDate;
	private String endDate;
	
	// 商家名称
	private String businessName;
	// 商家PID
	private String businessPID;
	// 归属员工姓名
	private String empName;
	//activeClientNumColumn
	private List<ActiveClientNumColumn> list;
}
