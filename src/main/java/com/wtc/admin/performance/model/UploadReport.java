package com.wtc.admin.performance.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class UploadReport implements Serializable{
	// 日期
	private String date;
	// 商家名称
	private String businessName;
	// 商家PID
	private String businessPID;
	// 商家地址
	private String businessAddress;
	// 省
	private String province;
	// 市
	private String city;
	// 区
	private String area;
	// 拓展时间
	private Date expandTime;
	// 归属员工姓名
	private String empName;
	// 员工支付宝账号
	private String empAlipayAccount;
	// 当日交易笔数
	private Integer tranNum;
	// 当日审核通过交易笔数
	private Integer passedTranNum;
	// 当日虚假交易笔数
	private Integer shamTranNum;
	// 当日有效交易客户数
	private Integer activeClientNum;
	// 单价
	private Double unitPrice;
	// 价格系数
	private Double priceCoefficient;
	// 应结算金额
	private Double settlementAmount;
	// 市场类型
	private String marketType;
	// 集中市场名称
	private String marketName;
	// 商家关联leads来源
	private String leadsSources;
}
