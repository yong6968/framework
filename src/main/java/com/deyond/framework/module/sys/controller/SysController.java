package com.deyond.framework.module.sys.controller;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("sys/")
public class SysController {
	
	/**
	 * 跳转人民币余额页面
	 * @param map
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/test", method = { RequestMethod.GET })
	public String gotoRmbBalancePage(ModelMap map, HttpServletRequest request, HttpServletResponse response)
	{
		return "about";
	}
}
