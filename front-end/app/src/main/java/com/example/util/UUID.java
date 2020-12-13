package com.example.util;
//一定范围内唯一的机器生成标识符
/**
 * 获取uuid
 * @author 张兴宝 
 *
 */
public class UUID {
	public static String getUuid() {
		return java.util.UUID.randomUUID().toString().replaceAll("-", "")
				.toUpperCase();
	}

}
