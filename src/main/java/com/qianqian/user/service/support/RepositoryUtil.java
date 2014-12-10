package com.qianqian.user.service.support;

import redis.clients.jedis.ShardedJedisPool;

import com.framelib.redis.IRedisUtil;
import com.framelib.redis.impl.RedisUtilImpl;
import com.framelib.utils.ApplicationUtil;

public class RepositoryUtil {
	
	public String get(String table,String id,String column){
		String queryKey=table+":"+id+":"+column;
		IRedisUtil ru=(RedisUtilImpl)ApplicationUtil.getBean("redisUtil");
		ShardedJedisPool sjp=(ShardedJedisPool)ApplicationUtil.getBean("shardedJedisPool");
		
		return ru.get(queryKey);
	}
	
	

}
