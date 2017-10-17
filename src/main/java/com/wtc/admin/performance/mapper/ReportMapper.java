
package com.wtc.admin.performance.mapper;

import com.wtc.admin.performance.model.SearchParam;
import com.wtc.admin.performance.model.SearchReport;
import com.wtc.admin.performance.model.UploadReport;

import java.util.List;

public interface ReportMapper {

    int save(List<UploadReport> list);
	
	List<SearchReport> selectReport(SearchParam param);
	
	int selectReportCount(SearchParam param);
}
