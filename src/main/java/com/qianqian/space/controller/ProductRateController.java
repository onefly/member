package com.qianqian.space.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.qianqian.comment.model.Rate;
import com.qianqian.comment.service.IProductRateDubboService;

/**
 * 商品评论控制器
 * @Project 	: member.maxtp
 * @Program Name: com.qianqian.space.controller.ProductRateController.java
 * @ClassName	: ProductRateController 
 * @Author 		: shensheng 
 * @CreateDate  : 2014年8月4日 下午3:29:49
 */
@Controller
@RequestMapping("/naked/comment")
public class ProductRateController {
	
	@Resource
	IProductRateDubboService productRateService;
	
	@RequestMapping("/toComment")
	public String gotoComment(){
		return "/space/nakedcomment";
	}
	
	@RequestMapping("/commitComment")
	public String commitComment(Rate rate){
		productRateService.save(rate);
		return "/space/commitStatus";
	}

}
