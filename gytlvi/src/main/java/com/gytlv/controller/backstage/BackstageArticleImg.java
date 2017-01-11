package com.gytlv.controller.backstage;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.commons.utils.DateUtil;

@Controller
@RequestMapping("/upload")
public class BackstageArticleImg {
	
	@Value("#{configProperties['uploadImage']}")
	private String uploadImage; 
	
	@RequestMapping(value = "/uploadImg", method = RequestMethod.POST)
	public @ResponseBody String uploadImg(HttpServletRequest request,HttpServletResponse response,
			MultipartFile myFileName) throws IllegalStateException, IOException, ServletException {
		response.setContentType("textml;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
		String nowTime = DateUtil.formatDateByFormat(new Date(), "yyyyMMdd");
		String path =uploadImage+nowTime;  
		String fileName = myFileName.getOriginalFilename();
		// 获取文件名称
		String fName = "";
		// 获取文件后缀
		String suffix = "";
		if (fileName.indexOf(".") >= 0) {
			int indexdot = fileName.indexOf(".");
			suffix = fileName.substring(indexdot);
			fName = fileName.substring(0, fileName.lastIndexOf("."));
			fName = fName + "_" + nowTime;
			fName = fName + suffix;
		}
		File fileList=new File(path);
		if(!fileList.exists()&&!fileList.isDirectory()){
			fileList.mkdir();
		}
		File fileList_slt=new File(path+"\\slt");
		if(!fileList_slt.exists()&&!fileList_slt.isDirectory()){
			fileList_slt.mkdir();
		}
		File targetFile=new File(path,fName); 
		myFileName.transferTo(targetFile);
		return "/upload/"+nowTime+"/"+fName;
	}
}
