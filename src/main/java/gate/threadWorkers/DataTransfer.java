package gate.threadWorkers;
import gate.base.domain.ChannelData;
/**
* @author 宋建涛 E-mail:1872963677@qq.com
* @version 创建时间：2019年5月24日 下午2:24:22
* 类说明
*/
public interface DataTransfer extends Runnable {
   void start() throws Exception;
}
