package com.deyond.framework.module.picture.controller;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.deyond.framework.common.utils.ZxingUtils;

@Controller
@RequestMapping("picture/")
public class QrcodeImageController {

	/**
	 * 功能:根据访问地址生成对应2维码图片
	 * @param map
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/qrcode", method = { RequestMethod.GET })
	public String qrcode(ModelMap map, HttpServletRequest request, HttpServletResponse response)
	{	
		String uuid = request.getParameter("uuid");//接收数据
		try {
			uuid = new String(uuid.getBytes("ISO8859-1"), "UTF-8") ;
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		BufferedImage image = ZxingUtils.getBufferedImage(uuid,256);
		response.setContentType("image/png");  
	    OutputStream os;
		try {
			os = response.getOutputStream();
			ImageIO.write(image, "png", os); 
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
	    return null;
	}
}
