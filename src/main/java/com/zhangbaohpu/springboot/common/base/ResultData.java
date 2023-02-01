package com.zhangbaohpu.springboot.common.base;

import com.zhangbaohpu.springboot.config.ApplicationContextRegister;
import io.swagger.annotations.ApiModel;

import java.util.HashMap;
import java.util.Map;

@ApiModel("api接口通用返回对象")
public class ResultData extends HashMap<String, Object> {
	private static final long serialVersionUID = 1L;

	static LocaleMessageSourceService messageSourceService = ApplicationContextRegister.getBean(LocaleMessageSourceService.class);

	public ResultData() {
		put("code", 0);
		put("msg", messageSourceService.getOkMessage());
	}

	public static ResultData error() {
		return error(1, messageSourceService.getErrorMessage());
	}

	public static ResultData error(String msg) {
		return error(500, msg);
	}

	public static ResultData error(int code, String msg) {
		ResultData resultData = new ResultData();
		resultData.put("code", code);
		Object msgs = null;
		try {
			msgs = messageSourceService.getErrorMessageByHand(msg);
		}catch (Exception e){
			msgs = null;
		}
		if(msgs!=null){
			resultData.put("msg", msgs);
		}else{
			resultData.put("msg", msg);
		}
		return resultData;
	}

	public static ResultData ok(String msg) {
		ResultData resultData = new ResultData();
		Object msgs = null;
		try {
			msgs = messageSourceService.getErrorMessageByHand(msg);
		}catch (Exception e){
			msgs = null;
		}
		if(msgs!=null){
			resultData.put("msg", msgs);
		}else{
			resultData.put("msg", msg);
		}
		return resultData;
	}

	public static ResultData ok(Map<String, Object> map) {
		ResultData resultData = new ResultData();
		resultData.putAll(map);
		return resultData;
	}
	public static ResultData ok(Object list, Object count) {
		ResultData resultData = new ResultData();
		resultData.put("data", list);
		resultData.put("count", count);
		return resultData;
	}
	public static ResultData ok(String key1, Object value1,String key2, Object value2) {
		ResultData resultData = new ResultData();
		resultData.put(key1, value1);
		resultData.put(key2, value2);
		return resultData;
	}
	public static ResultData ok(String key, Object value) {
		ResultData resultData = new ResultData();
		resultData.put(key, value);
		return resultData;
	}
	public static ResultData ok(int code, String msg, String data) {
		ResultData resultData = new ResultData();
		resultData.put("code", code);
		resultData.put("msg", msg);
		resultData.put("data", data);
		return resultData;
	}
	public static ResultData ok(int code, String data) {
		ResultData resultData = new ResultData();
		resultData.put("code", code);
		resultData.put("data", data);
		return resultData;
	}

	public static ResultData ok() {
		return new ResultData();
	}

	@Override
	public ResultData put(String key, Object value) {
		super.put(key, value);
		return this;
	}
}
