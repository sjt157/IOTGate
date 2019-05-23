package gate.util;
/**
* @author 宋建涛 E-mail:1872963677@qq.com
* @version 创建时间：2019年5月23日 下午5:43:16
* 类说明
*/
public class Test {
	
	public static long getPID() {
	    String processName = java.lang.management.ManagementFactory.getRuntimeMXBean().getName();
	    if (processName != null && processName.length() > 0) {
	        try {
	            return Long.parseLong(processName.split("@")[0]);
	        }
	        catch (Exception e) {
	            return 0;
	        }
	    }
	
	    return 0;
	}
	
	public static void main(String[] args) {
		long a = Test.getPID();
		System.out.println(a);
	}
}
