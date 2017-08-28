package com.deyond.framework.module.sys.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("sys/")
public class SysController {
	
	/**
	 * 跳转列表页面
	 * @param map
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/findListUI", method = { RequestMethod.GET })
	public String findListUI(ModelMap map, HttpServletRequest request, HttpServletResponse response)
	{
		return "upload/upload";
	}
	
	@RequestMapping(value = "/findList")
	public String findList(ModelMap map, HttpServletRequest request, HttpServletResponse response)
	{
		return "about";
	}


}
