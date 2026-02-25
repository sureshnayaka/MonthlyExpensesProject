package com.sg.user.response;

import java.time.Instant;


public class ApiResponse<T> {

	private String message;
	private int statusCode;
	private String timeStamp;
	private String path;
	private String traceId;
	private T data;

	public ApiResponse(String message, int statusCode, String timeStamp, String path, String traceId, T data) {
		super();
		this.message = message;
		this.statusCode = statusCode;
		this.timeStamp = timeStamp;
		this.path = path;
		this.traceId = traceId;
		this.data = data;
	}

	public static <T> ApiResponse<T> response(String message, int statusCode, T data, String path, String traceId) {
		return new ApiResponse<>(message, statusCode, Instant.now().toString(), path, traceId, data);
	}

	public static <T> ApiResponse<T> success(String message, T data, String path) {
		return response(message, 200, data, path, null);
	}
	
	
	public static <T> ApiResponse<T> failure(String message, int stausCode, String path) {
		return response(message, stausCode, null, path, null);
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public String getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getTraceId() {
		return traceId;
	}

	public void setTraceId(String traceId) {
		this.traceId = traceId;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
	
	
}