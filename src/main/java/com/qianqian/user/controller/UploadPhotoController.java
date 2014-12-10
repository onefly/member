package com.qianqian.user.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.framelib.common.CommonConstants;
import com.framelib.common.SessionData;
import com.framelib.dfs.FastDFSUtil;
import com.framelib.utils.SessionUtil;
import com.framelib.utils.StringUtil;
import com.qianqian.user.model.User;
import com.qianqian.user.service.IUserService;

import sun.misc.BASE64Decoder;

/**
 * 上传头像的控制器
 * 
 * @Project : member.maxtp
 * @Program Name: com.qianqian.user.controller.UploadPhotoController.java
 * @ClassName : UploadPhotoController
 * @Author : shenzhenxing
 * @CreateDate : 2014年4月29日 下午4:24:53
 */
@Controller
public class UploadPhotoController {
	@Resource
	private IUserService userService;
	private static Logger log = LoggerFactory
			.getLogger(UploadPhotoController.class);
	private static String fileServer = CommonConstants.FILE_SERVER_IP;

	/**
	 * 上传头像的控制器
	 * 
	 * @Method_Name : upload
	 * @param request
	 * @return
	 * @throws Exception
	 * @return : String
	 * @Creation Date : 2014年4月29日 下午4:24:28
	 * @version : v1.00
	 * @Author : shenzhenxing
	 * @Update Date :
	 * @Update Author :
	 */
	@RequestMapping("/uploadHead")
	
	public String upload(HttpServletRequest request, Model model,String pic1,String pic2,String pic3)
			{
		
		
		List<String> filePathList = new ArrayList<String>();
		try {
			SessionData session = SessionUtil.getSessionData(request);
			long userId = session.getId();
			
		
			String[] results1 = FastDFSUtil.uploadFile(new BASE64Decoder().decodeBuffer(pic1), "jpg", null);
			String[] results2 = FastDFSUtil.uploadFile(new BASE64Decoder().decodeBuffer(pic2), "jpg", null);
			String[] results3 = FastDFSUtil.uploadFile(new BASE64Decoder().decodeBuffer(pic3), "jpg", null);
			
			
		
			String big=results1[0] + "/" + results1[1];
			String mid=results2[0] + "/" + results2[1];
			String small=results3[0] + "/" + results3[1];
			//System.out.println(big);
			filePathList.add(big);
			filePathList.add(mid);
			filePathList.add(small);
		
			/* 更新用户表 */

			User user = userService.getUser(userId);
			
			if (!StringUtil.isBlank(user.getBigHeadUrl())) {
				
				// 不为空，说明已上传过头像，需要删除原来的头像
				String smallUrl=user.getSmallHeadImage();
				String midUrl=user.getMiddleHeadUrl();
				String bigUrl=user.getBigHeadUrl();
			
				String smallgroupName = smallUrl.split("\\/")[0];
				String smallremoteFileName = smallUrl.substring(smallgroupName.length()+1);
				String midgroupName = midUrl.split("\\/")[0];
				String midremoteFileName = midUrl.substring(midgroupName.length()+1);
				String biggroupName = bigUrl.split("\\/")[0];
				String bigremoteFileName = bigUrl.substring(biggroupName.length()+1);
				//删除文件服务器原来的头像
				
				FastDFSUtil.deleteFile(smallgroupName, smallremoteFileName);
				FastDFSUtil.deleteFile(midgroupName,midremoteFileName );
				FastDFSUtil.deleteFile(biggroupName,bigremoteFileName);
				
			}
			user.setBigHeadUrl(big);
			user.setSmallHeadImage(mid);
			user.setMiddleHeadUrl(small);
			userService.updateUser(user);
			log.info(" "+Arrays.toString(filePathList.toArray()));
			model.addAttribute("picUrl", filePathList);
			model.addAttribute("status", 1);
		} catch (Exception e) {
			model.addAttribute("status", 0);
			
			log.error(e.toString(), e);
		}

		return null;
	}
	/**
	 * 访问修改头像的controller
	 *  @Method_Name    : upload
	 *  @return 
	 *  @return         : String
	 *  @Creation Date  : 2014年5月7日 上午10:08:05
	 *  @version        : v1.00
	 *  @Author         : shenzhenxing 
	 *  @Update Date    : 
	 *  @Update Author  :
	 */
	@RequestMapping("/user/uploadPhoto")
	public String upload(){
		return "/user/uploadPhoto/uploadPhoto";
	}


}
