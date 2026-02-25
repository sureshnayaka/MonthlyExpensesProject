package com.sg.user.util;

import com.sg.user.response.ApiResponse;

public final class ResponseBuilder {
	
	public static <T> ApiResponse<T> success (String message, T data, String path){
		return ApiResponse.success(message, data, path);
	}

	public static <T> ApiResponse<T> failure (String message, int statusCode, String path){
		return ApiResponse.failure(message, statusCode, path);
	}
}
