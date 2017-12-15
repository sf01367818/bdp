package com.sf.bdp.marathon.common.bean;

public class Response<T> {
	
	private boolean success;
	private T data;
	
	public Response(){}

	public Response(boolean success) {
		this.success = success;
	}

	public Response(boolean success, T data) {
		this.success = success;
		this.data = data;
	}

	public static <T> Response<T> ok(T data) {
		return new Response<>(true, data);
	}
	public static<T> Response<T> ok(){
		return new Response<>(true,null);
	}
	public static<T> Response<T> error(){
		return new Response<>(false,null);
	}

	public static <T> Response<T> error(T data) {
		return new Response<>(false, data);
	}
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
}
