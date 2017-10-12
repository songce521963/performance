package com.wtc.admin.performance.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class UploadReport implements Serializable{
	// id
	private int id;
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
	private String expandTime;
	// 归属员工姓名
	private String empName;
	// 员工支付宝账号
	private String empAlipayAccount;
	// 是否具有返佣资格
	private String isResignation;
	// 价格系数
	private Double priceCoefficient;
	// 累计交易笔数
	private Integer tranNum;
	// 累计审核通过交易笔数
	private Integer passedTranNum;
	// 累计虚假交易笔数
	private Integer shamTranNum;
	// 累计有效交易客户数
	private Integer activeClientNum;
	// 累计已结算交易客户数
	private Integer settledClientNum;
	// 当月待结算交易客户数
	private Integer monthSettleClientNum;
	// 剩余待结算交易客户数
	private Integer remSettleClientNum;
	// 市场类型
	private String marketType;
	// 集中市场名称
	private String marketName;
	// 商家关联leads来源
	private String leadsSources;
}
