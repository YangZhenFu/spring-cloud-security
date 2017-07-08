package com.spring.cloud.security.common.constant;

/**
 * 业务类里面的常量
 * @author lixp 2017年1月14日 16:41:55
 *
 */
public class UserConstant {
	
		//用户有效
		public final static String USER_VALID_STR="1";
		public final static Byte USER_VALID_BYTE=(byte)1;
		//用户无效
		public final static String USER_INVALID_STR="0";
		public final static Byte USER_INVALID_BYTE=(byte)0;
		
		//用户锁定
		public final static String USER_LOCK_STR="1";
		public final static Byte USER_LOCK_BYTE=(byte)1;
		//用户解锁
		public final static String USER_UNLOCK_STR="0";
		public final static Byte USER_UNLOCK_BYTE=(byte)0;
	
	
		public static int PW_ENCORDER_SALT = 12;
}
