package com.wtc.admin.performance.service;

import com.wtc.admin.performance.mapper.ReportMapper;
import com.wtc.admin.performance.model.UploadReport;
import com.wtc.admin.performance.utils.CSVUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class CsvService {

    @Autowired
    private ReportMapper reportMapper;

    public List<UploadReport> preview(MultipartHttpServletRequest request) throws Exception {
        List<String[]> list = CSVUtils.readeCsvByIs(request.getInputStream());
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
    private List<UploadReport> getUploadReport(List<String[]> list) {
        List<UploadReport> reportList = new ArrayList<>();
        list.forEach(data -> {
            UploadReport report = new UploadReport();
            report.setDate(data[0]);
            report.setBusinessName(data[1]);
            report.setBusinessPID(data[2]);
            report.setBusinessAddress(data[3]);
            report.setProvince(data[4]);
            report.setCity(data[5]);
            report.setArea(data[6]);
            report.setExpandTime(data[7]);
            report.setEmpName(data[8]);
            report.setEmpAlipayAccount(data[9]);
            report.setIsResignation(data[10]);
            if (CSVUtils.isNotBlank(data[11]))
            	report.setPriceCoefficient(Double.parseDouble(data[11]));
			if (CSVUtils.isNotBlank(data[12]))
				report.setTranNum(Integer.parseInt(data[12]));
			if (CSVUtils.isNotBlank(data[13]))
				report.setPassedTranNum(Integer.parseInt(data[13]));
			if (CSVUtils.isNotBlank(data[14]))
				report.setShamTranNum(Integer.parseInt(data[14]));
			if (CSVUtils.isNotBlank(data[15]))
				report.setActiveClientNum(Integer.parseInt(data[15]));
			if (CSVUtils.isNotBlank(data[16]))
				report.setSettledClientNum(Integer.parseInt(data[16]));
			if (CSVUtils.isNotBlank(data[17]))
				report.setMonthSettleClientNum(Integer.parseInt(data[17]));
			if (CSVUtils.isNotBlank(data[18]))
				report.setRemSettleClientNum(Integer.parseInt(data[18]));
            report.setMarketName(data[19]);
            report.setMarketType(data[20]);
            report.setLeadsSources(data[21]);
            reportList.add(report);
        });
        return reportList;
    }
	

}
