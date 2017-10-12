package com.wtc.admin.performance.model;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;
import org.apache.commons.lang3.StringUtils;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RestResponse<T> {

	private String resultCode;
	private String errorCode = StringUtils.EMPTY;
	private String errorMessage = StringUtils.EMPTY;
	private T result;

	public RestResponse(){}
	
	public RestResponse(String resultCode,T result){
		this.resultCode = resultCode;
		this.result = result;
	}
	
	public RestResponse(String resultCode){
		this.resultCode = resultCode;
	}
	
	public RestResponse(String resultCode,String errorCode,String errorMessage){
		this.resultCode = resultCode;
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
	}
	
	
}
