package com.qianqian.user.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.framelib.utils.ResponseUtils;
import com.qianqian.user.model.RecieveAddress;
import com.qianqian.user.service.IRecieveAddressService;

/**
 * Title:ShippingAddressController
 * Description:收货地址管理
 * @Create_by:yinsy
 * @Create_date:2014-4-29
 * @Last_Edit_By:
 * @Edit_Description:
 * @version:member.maxtp 1.0
 */
@Controller
public class RecieveAddressController {
	
	@Autowired
	IRecieveAddressService recieveAddressService;
	
	/**
	 * 跳转到收货地址管理页，并查询出当前用户下的所有收货地址
	 * @Create_by:yinsy
	 * @Create_date:2014-4-29
	 * @param modelMap
	 * @return
	 * @throws Exception 
	 * @Last_Edit_By:
	 * @Edit_Description:
	 * @Create_Version:member.maxtp 1.0
	 */
	@RequestMapping("user/toRecAddr.htm")
	public String toRecAddr(ModelMap modelMap) throws Exception {
		List<RecieveAddress> addrList = recieveAddressService.searchRecAddr();
		modelMap.put("addrList", addrList);
		return "user/recAddr";
	}
	
	/**
	 * 获取收货地址信息
	 * @Create_by:yinsy
	 * @Create_date:2014-4-30
	 * @param id
	 * @param modelMap
	 * @return
	 * @Last_Edit_By:
	 * @Edit_Description:
	 * @Create_Version:member.maxtp 1.0
	 */
	@RequestMapping("user/getRecAddr")
	public String getRecAddr(String id,ModelMap modelMap) throws Exception {
		RecieveAddress recAddr = recieveAddressService.getRecAddr(id);
		modelMap.put("addr", recAddr);
		return "";
	}
	
	/**
	 * 新增收货地址
	 * @Create_by:yinsy
	 * @Create_date:2014-4-29
	 * @param recAddr 收货地址对象
	 * @return
	 * @Last_Edit_By:
	 * @Edit_Description:
	 * @Create_Version:member.maxtp 1.0
	 */
	@RequestMapping("user/addRecAddr.htm")
	public void addRecAddr(RecieveAddress recAddr,HttpServletResponse response) {
		try {
			int flag = recieveAddressService.addRecAddr(recAddr);
			ResponseUtils.renderText(response, flag);
		} catch (Exception e) {
			ResponseUtils.renderText(response, 0);
		}
	}
	
	/**
	 * 修改收货地址
	 * @Create_by:yinsy
	 * @Create_date:2014-4-29
	 * @param recAddr 收货地址对象
	 * @return
	 * @Last_Edit_By:
	 * @Edit_Description:
	 * @Create_Version:member.maxtp 1.0
	 */
	@RequestMapping("user/modifyRecAddr.htm")
	public void modifyRecAddr(RecieveAddress recAddr,HttpServletResponse response) {
		try {
			int flag = recieveAddressService.modifyRecAddr(recAddr);
			ResponseUtils.renderText(response, flag);
		} catch (Exception e) {
			ResponseUtils.renderText(response, 0);
		}
	}
	
	/**
	 * 删除收货地址
	 * @Create_by:yinsy
	 * @Create_date:2014-4-29
	 * @param id
	 * @return
	 * @Last_Edit_By:
	 * @Edit_Description:
	 * @Create_Version:member.maxtp 1.0
	 */
	@RequestMapping("user/deleteRecAddr.htm")
	public void deleteRecAddr(String id,HttpServletResponse response) {
		try {
			int flag = recieveAddressService.deleteRecAddr(id);
			ResponseUtils.renderText(response, flag);
		} catch (Exception e) {
			ResponseUtils.renderText(response, 0);
		}
	}
	
}
