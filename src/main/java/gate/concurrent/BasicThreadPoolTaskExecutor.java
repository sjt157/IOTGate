package gate.concurrent;
/**
* @author 宋建涛 E-mail:1872963677@qq.com
* @version 创建时间：2019年5月24日 上午9:31:26
* 类说明：基本线程池
*/

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BasicThreadPoolTaskExecutor {
	private static ExecutorService service = null;
	
	private  BasicThreadPoolTaskExecutor() {
		throw new AssertionError();
	}
	
	static{
		service = Executors.newCachedThreadPool(new ThreadFactoryImpl("basicExector_",false));
	}
	
	public static ExecutorService getBasicExecutor(){
		return service;
	}
}
