package com.commons.utils;

import java.util.List;

import redis.clients.jedis.ShardedJedis;

public class RedisUtils {
	/**
	 * 设置 list
	 * 
	 * @param <T>
	 * @param key
	 * @param value
	 */
	public static <T> void setList(ShardedJedis jedis, String key, List<T> list) {
		jedis.set(key.getBytes(), ObjectTranscoder.serialize(list));
	}

	/**
	 * 获取list
	 * 
	 * @param <T>
	 * @param key
	 * @return list
	 */
	@SuppressWarnings("unchecked")
	public static <T> List<T> getList(ShardedJedis jedis,String key) {
		byte[] in = jedis.get(key.getBytes());
		List<T> list = (List<T>) ObjectTranscoder.deserialize(in);
		return list;
	}
}
