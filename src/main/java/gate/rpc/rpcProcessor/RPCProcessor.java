package gate.rpc.rpcProcessor;

import gate.rpc.dataBridge.RequestData;
import gate.rpc.dataBridge.ResponseData;

/**
* @author 宋建涛 E-mail:1872963677@qq.com
* @version 创建时间：2019年5月23日 下午7:34:25
* 类说明:RPC服务接口
*/
public interface RPCProcessor {
	
	void exportService() throws Exception;
	
	ResponseData executeService(RequestData request);
}
