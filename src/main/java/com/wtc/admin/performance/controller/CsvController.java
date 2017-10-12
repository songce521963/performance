package com.wtc.admin.performance.controller;

import com.wtc.admin.performance.model.RestResponse;
import com.wtc.admin.performance.model.UploadReport;
import com.wtc.admin.performance.service.CsvService;
import com.wtc.admin.performance.utils.RestGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.util.List;

@RestController
@RequestMapping("api/")
public class CsvController {

	@Autowired
	private CsvService csvService;
	
	@PostMapping("preview")
	public RestResponse<List<UploadReport>> preview(MultipartHttpServletRequest request) throws Exception{
		List<UploadReport> reports = csvService.preview(request);
		return RestGenerator.successResult(reports);
	}
	
	@PostMapping
	public RestResponse save(List<UploadReport> uploadReports) throws Exception{
		csvService.save(uploadReports);
		return RestGenerator.successResult();
	}
}
