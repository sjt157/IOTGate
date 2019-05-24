package gate.rpc.rpcProcessor;

import java.util.List;

import gate.util.MixAll;

/**
* @author 宋建涛 E-mail:1872963677@qq.com
* @version 创建时间：2019年5月24日 上午11:36:51
* 类说明
*/
public class Test {
	public static void main(String[] args) {
		List<String> result = MixAll.getClazzName("gate.rpc.rpcService", false);
		for (String className : result) {
			System.out.println(className);
		}
}
	
}
