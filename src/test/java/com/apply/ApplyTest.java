package com.apply;

import java.io.IOException;
import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.framelib.utils.Page;
import com.qianqian.apply.bo.ApplyBO;
import com.qianqian.apply.service.IApplyDubboService;
import com.qianqian.member.model.User;
import com.qianqian.member.service.IUserDubboService;
import com.qianqian.order.dto.OrderBO;
import com.qianqian.order.service.IOrderDubboService;

public class ApplyTest {
	private IApplyDubboService applyDubboService;
	private IOrderDubboService orderDubboService;
	private IUserDubboService userDubboService;

	@Before
	public void before() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"/spring/applicationContext.xml");
		applyDubboService = (IApplyDubboService) ctx.getBean("applyDubboService");
		//orderDubboService = (IOrderDubboService) ctx.getBean("orderDubboService");
		//userDubboService = (IUserDubboService) ctx.getBean("userDubboService");
	}

	@Test
	public void testGetApplyList() throws IOException {
		ApplyBO bo = new ApplyBO();
		Page page = new Page();
		page.setPageNum(2);
		bo.setPage(page);
		bo.setUserId(110l);
		bo  = applyDubboService.getMemApplyList(bo);
		System.out.println("##################################################");
		System.out.println(Arrays.toString(bo.getApplyList().toArray()));
		System.out.println("total count ==>" +bo.getPage().getTotalCount()+";list size="+ bo.getApplyList().size());
		//System.in.read();
	}
	@Test
	public void testOrder(){
		long userId = 5l;
		Page page = new Page();
		page.setNumPerPage(10);
		page.setPageNum(1);
		OrderBO orderBO = orderDubboService.getAllFreeOrderByUserId(userId, page);
//		List<>
//		System.out.println("************************************");
//		System.out.println("list size ==>"+list.size());
		User user = userDubboService.getUser(110L);
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		System.out.println(user.getNickname()+"=="+user.getName());
	}

}
