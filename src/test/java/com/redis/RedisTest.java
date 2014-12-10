package com.redis;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.framelib.redis.IRedisUtil;
import com.framelib.redis.impl.RedisUtilImpl;

public class RedisTest {

	IRedisUtil redisUtil = null;

	/**
	 * 初始化 Fixture 方法 Title: Description:
	 * 
	 * @Create_by:Zhangy Yan
	 * @Create_date:2014-1-6
	 * @Last_Edit_By:
	 * @Edit_Description
	 * @Create_Version:ShareWithUs 1.0
	 * @return:void
	 */
	@Before
	public void init() {
//		ApplicationContext ctx = new ClassPathXmlApplicationContext(
//				"classpath:spring/applicationContext.xml");
//		// siteinfoService = (SiteinfoService) ctx.getBean("siteinfoService");
//		redisUtil = (IRedisUtil) ctx.getBean("redisUtil");
	}

	// 注销 Fixture 方法
	@After
	public void destroy() {

	}

	@Test
	public void insert() {
		long t1 = System.currentTimeMillis();
		for (int i = 0; i < 2; i++) {
			RedisMoreIncrThread t = new RedisMoreIncrThread();
			t.start();

		}
		long t2 = System.currentTimeMillis();
		System.out.println("time insert:" + (t2 - t1));
	}
	
	@Test
	public void insert2() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"classpath:spring/applicationContext.xml");
		redisUtil = (IRedisUtil) ctx.getBean("redisUtil");
		int i = redisUtil.incr("bbc9").intValue();
		System.out.println("iii   "+i);
		if(i==1){
			 System.out.println("不存在");
		 }else{
			 System.out.println("已经存在！！！！！");
		 }
		
		int j = redisUtil.incr("bbc6").intValue();
		System.out.println("jjj   "+j);
		if(j==1){
			 System.out.println("不存在");
		 }else{
			 System.out.println("已经！！！！！");
		 }
	}

}

class RedisMoreIncrThread extends Thread{
	
	static IRedisUtil redisUtil = null;
 static{
	 ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"classpath:spring/applicationContext.xml");
		// siteinfoService = (SiteinfoService) ctx.getBean("siteinfoService");
		redisUtil = (IRedisUtil) ctx.getBean("redisUtil");
		
 }
	public synchronized static IRedisUtil  getRedisUtil(){
		if(redisUtil==null){
			
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"classpath:spring/applicationContext.xml");
		// siteinfoService = (SiteinfoService) ctx.getBean("siteinfoService");
		redisUtil = (IRedisUtil) ctx.getBean("redisUtil");
		}
		return redisUtil;
	}
	
	  public void run() {
		  System.out.println("wgwgewgweg");
		 if(redisUtil.incr("bbc11").intValue()==1){
			 System.out.println("不存在");
		 }else{
			 System.out.println("已经存在！！！！！");
		 }
		 
	  }
	
	
}