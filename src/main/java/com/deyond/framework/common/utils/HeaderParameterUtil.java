/*
 * Copyright (C) 2015 ShenZhen HeShiDai Co.,Ltd All Rights Reserved.
 * 未经本公司正式书面同意，其他任何个人、团体不得使用、复制、修改或发布本软件.
 * 版权所有深圳合时代金融服务有限公司 www.heshidai.com.
 */
package com.deyond.framework.common.utils;

import java.util.Enumeration;
import java.util.TreeMap;

import javax.servlet.http.HttpServletRequest;

/**
 * 请求参数转化
 */
public class HeaderParameterUtil {

    public static TreeMap<String, String> getHeaders(HttpServletRequest request) {
        TreeMap<String, String> parametersMap = new TreeMap<String, String>();
        Enumeration<String> headers = request.getHeaderNames();
        while (headers.hasMoreElements()){
            String name = (String) headers.nextElement();
            String header = request.getHeader(name);
            parametersMap.put(name,header);
        }
        return parametersMap;
    }

    public static TreeMap<String, String> getParametersMap(HttpServletRequest request) {
        TreeMap<String, String> parametersMap = new TreeMap<String, String>();
        Enumeration<String> em = request.getParameterNames();
        while (em.hasMoreElements()) {
            String name = (String) em.nextElement();
            String parameter = request.getParameter(name);
            parametersMap.put(name, parameter);
        }
        return parametersMap;
    }
}
