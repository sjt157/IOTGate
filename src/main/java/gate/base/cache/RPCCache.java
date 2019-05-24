package gate.base.cache;

import java.util.concurrent.ConcurrentHashMap;

/**
* @author 宋建涛 E-mail:1872963677@qq.com
* @version 创建时间：2019年5月24日 下午12:29:03
* 类说明:RPC服务缓存
*/
public class RPCCache {
private static ConcurrentHashMap<String, Class<?>> rpcServices;
	
	private RPCCache(){
		throw new AssertionError();
	}

	static{
		rpcServices = new ConcurrentHashMap<String, Class<?>>();
	}
	
	public static Class<?> getClass(String className){
		return rpcServices.get(className);
	}
	
	public static void putClass(String className , Class<?> clazz){
		rpcServices.put(className, clazz);
	}
}
