package com.wtc.admin.performance.utils;

import com.wtc.admin.performance.model.RestResponse;

public class RestGenerator {

	private final static String SUCCESS_RESULT_CODE = "OK";
	private final static String ERROR_RESULT_CODE = "ERROR";

	public static <T> RestResponse<T> successResult(T data) {
		return new RestResponse<T>(SUCCESS_RESULT_CODE, data);
	}

	public static <T> RestResponse<T> successResult() {
		return new RestResponse<T>(SUCCESS_RESULT_CODE);
	}

	public static <T> RestResponse<T> errorResult(String errorCode, String errorMessage) {
		return new RestResponse<T>(ERROR_RESULT_CODE, errorCode, errorMessage);
	}

}
