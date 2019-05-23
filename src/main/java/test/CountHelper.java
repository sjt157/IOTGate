package test;

import java.util.concurrent.atomic.AtomicInteger;

/**
* @author 宋建涛 E-mail:1872963677@qq.com
* @version 创建时间：2019年5月23日 下午4:47:29
* 类说明:测试使用的一些计数的变量---要合理考虑并发
*/
public class CountHelper {
public static int ThreadNum = 1;
	
	public static AtomicInteger clientRecieveCount ;
	public static AtomicInteger masterRecieveCount ;
	
	public static Long masterRecieveStartTime;//记录前置接收到第一条数据的时间
	
	static{
		clientRecieveCount = new AtomicInteger(0);
		masterRecieveCount = new AtomicInteger(0);
	}
}
