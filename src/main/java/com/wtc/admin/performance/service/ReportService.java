package com.wtc.admin.performance.service;

import com.wtc.admin.performance.exception.BussinessException;
import com.wtc.admin.performance.mapper.ReportMapper;
import com.wtc.admin.performance.model.ActiveClientNumColumn;
import com.wtc.admin.performance.model.SearchParam;
import com.wtc.admin.performance.model.SearchReport;
import com.wtc.admin.performance.model.UploadReport;
import com.wtc.admin.performance.utils.DateUtil;
import com.wtc.admin.performance.utils.POIUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class ReportService {

    @Autowired
    private ReportMapper reportMapper;

    public List<UploadReport> preview(MultipartFile file) throws Exception {
        POIUtil.checkFile(file);
        List<String[]> list = POIUtil.readExcel(file, 3, 2);
        return getUploadReport(list);
    }

    public void save(List<UploadReport> uploadReports) {
        reportMapper.save(uploadReports);
    }

    /**
     * 获取UploadReport data
     * @param list
     * @return List<UploadReport>
     */
    private List<UploadReport> getUploadReport(List<String[]> list) throws Exception{
        final String errorMessage = "内容不能为空或者文件格式不正确 ^_^ ！";
        if(list.size()==0){
            throw new BussinessException(errorMessage);
        }
        
        List<UploadReport> reportList = new ArrayList<>();
        
        try {
            list.forEach(data -> {
                UploadReport report = new UploadReport();
                // 交易日期
                report.setDate(data[0]);
                // 商家名称
                report.setBusinessName(data[1]);
                // 拓展时间
                report.setExpandTime(DateUtil.parse(data[2],DateUtil.YYYYMMDD));
                // 当日交易笔数
                if (isNotBlank(data[3]))
                    report.setTranNum(Integer.parseInt(data[3]));
                // 当日审核通过交易笔数
                if (isNotBlank(data[4]))
                    report.setPassedTranNum(Integer.parseInt(data[4]));
                // 当日虚假交易笔数
                if (isNotBlank(data[5]))
                    report.setShamTranNum(Integer.parseInt(data[5]));
                // 当日有效交易客户数
                if (isNotBlank(data[6]))
                    report.setActiveClientNum(Integer.parseInt(data[6]));
                // 单价
                if (isNotBlank(data[7]))
                    report.setUnitPrice(Double.parseDouble(data[7]));
                // 价格系数
                if (isNotBlank(data[8]))
                    report.setPriceCoefficient(Double.parseDouble(data[8]));
                // 应结算金额
                if (isNotBlank(data[9]))
                    report.setSettlementAmount(Double.parseDouble(data[9]));
                // 商家PID
                report.setBusinessPID(data[10]);
                // 详细地址
                report.setBusinessAddress(data[11]);
                // 省份
                report.setProvince(data[12]);
                // 城市
                report.setCity(data[13]);
                // 区县
                report.setArea(data[14]);
                // 归属员工姓名
                report.setEmpName(data[15]);
                // 员工支付宝账号
                report.setEmpAlipayAccount(data[16]);
                // 市场类型
                report.setMarketType(data[17]);
                // 集中市场名称
                report.setMarketName(data[18]);
                // 商家来源
                report.setLeadsSources(data[19]);
                reportList.add(report);
            });
        }catch (Exception e){
            log.error(e.getMessage());
            throw new BussinessException(errorMessage);
        }
        
        return reportList;
    }
    
    /**
     * 根据条件查出报表信息
     * @param param
     */
    public Map<String,Object> getReport(SearchParam param) {
        param.setStartDate(new DateTime(param.getStartDateStr()).withMillisOfDay(0).toDate());
        param.setEndDate(new DateTime(param.getEndDateStr()).withMillisOfDay(0).toDate());
        if(StringUtils.isNotBlank(param.getDate())){
            param.setDate(DateUtil.dateToString(new DateTime(param.getDate()).withMillisOfDay(0).toDate(),DateUtil.YYYYMMDD));
        }
        param.setList(getActiveClientNumColumns());
        List<SearchReport> list = reportMapper.selectReport(param);
        int total = reportMapper.selectReportCount(param);
        Map<String,Object> result = new HashMap<>();
        result.put("total",total);
        result.put("items",list);
        return result;
    }
    
    /**
     * 判断数据是否为空字段
     * @param data
     */
    private static boolean isNotBlank(String data) {
        if (StringUtils.equals(data, "-"))
            return false;
        return true;
    }
    
    public List<ActiveClientNumColumn> getActiveClientNumColumns() {
        List<ActiveClientNumColumn> list = new ArrayList<>();
        
        ActiveClientNumColumn acnc;
        for(int i = 1;i<=30;i++){
            acnc = new ActiveClientNumColumn();
            acnc.setAddDay(i);
            acnc.setColumnName("activeClientNum"+i);
            list.add(acnc);
        }
        return list;
    }
}
