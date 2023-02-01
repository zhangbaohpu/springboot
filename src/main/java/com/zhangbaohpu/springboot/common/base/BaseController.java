package com.zhangbaohpu.springboot.common.base;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.google.common.collect.Maps;
import com.zhangbaohpu.springboot.common.utils.ShiroUtils;
import com.zhangbaohpu.springboot.config.Constant;
import com.zhangbaohpu.springboot.module.system.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Map;

public class BaseController {

	@Autowired
	private LocaleMessageSourceService localeMessageSourceService;

	public User getUser() {
		return ShiroUtils.getUser();
	}

	public String getUserId() {
		return getUser().getId().toString();
	}

	public String getUsername() {
		return getUser().getId();
	}


	public String getMsg(String  key) {
		return localeMessageSourceService.getMessage(key);
	}


	/**
	 * 获取bootstrap data分页数据
	 * @param page
	 * @return map对象
	 */
	public <T> Map<String, Object> getBootstrapData(IPage page){
		Map<String, Object> map = Maps.newHashMap();
		map.put(Constant.BOOTSTRAP_TABLE_ROWS, page.getRecords());
		map.put(Constant.BOOTSTRAP_TABLE_TOTAL, page.getTotal());
		return map;
	}
	/**
	 * 添加Flash消息
	 * @param
	 */
	protected void addMessage(RedirectAttributes redirectAttributes, String... messages) {
		StringBuilder sb = new StringBuilder();
		for (String message : messages){
			sb.append(message).append(messages.length>1?"<br/>":"");
		}
		redirectAttributes.addFlashAttribute("message", sb.toString());
	}

}