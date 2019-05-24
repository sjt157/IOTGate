package gate.concurrent;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/**
* @author 宋建涛 E-mail:1872963677@qq.com
* @version 创建时间：2019年5月24日 上午9:39:06
* 类说明:自定义一个ThreadFactory的实现类
*/
public class ThreadFactoryImpl implements ThreadFactory{
	AtomicInteger index = new AtomicInteger(0);
	private String threadNamePrefix;
	private boolean isDaemon;
	
	public ThreadFactoryImpl(String threadNamePrefix,boolean isDaemon) {
		super();
		this.threadNamePrefix = threadNamePrefix;
		this.isDaemon = isDaemon;
	}
	
	
	@Override
	public Thread newThread(Runnable r) {
		
		Thread thread =  new Thread(r,threadNamePrefix+index.addAndGet(1));
		thread.setDaemon(isDaemon);
		return thread;
		
	}
}
