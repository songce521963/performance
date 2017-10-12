
package com.wtc.admin.performance.mapper;

import com.wtc.admin.performance.model.UploadReport;

import java.util.List;

public interface ReportMapper {

    int save(List<UploadReport> uploadReports);

}
