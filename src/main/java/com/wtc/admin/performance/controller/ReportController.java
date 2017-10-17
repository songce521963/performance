package com.wtc.admin.performance.controller;

import com.wtc.admin.performance.model.RestResponse;
import com.wtc.admin.performance.model.SearchParam;
import com.wtc.admin.performance.model.SearchReport;
import com.wtc.admin.performance.model.UploadReport;
import com.wtc.admin.performance.service.ReportService;
import com.wtc.admin.performance.utils.RestGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/")
public class ReportController {

	@Autowired
	private ReportService reportService;
	
	@PostMapping("preview")
	public RestResponse<List<UploadReport>> preview(@RequestParam("file")MultipartFile file) throws Exception{
		List<UploadReport> reports = reportService.preview(file);
		return RestGenerator.successResult(reports);
	}
	
	@PostMapping("save")
	public RestResponse save(@RequestBody List<UploadReport> uploadReports) throws Exception{
		reportService.save(uploadReports);
		return RestGenerator.successResult();
	}
	
	@GetMapping("getReport")
	public RestResponse save(SearchParam param) throws Exception{
		Map<String,Object> result = reportService.getReport(param);
		return RestGenerator.successResult(result);
	}
}
