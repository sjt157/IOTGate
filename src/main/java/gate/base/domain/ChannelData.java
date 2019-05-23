package gate.base.domain;

import java.io.Serializable;

/**
* @author 宋建涛 E-mail:1872963677@qq.com
* @version 创建时间：2019年5月23日 下午3:11:20
* 类说明
*/
public class ChannelData implements Serializable {

	/**
	 * 一个客户端请求所对应的所有有用数据对象
	 */
	private static final long serialVersionUID = 7677695333862680962L;
	
	/**
	 * 通道的远程ip地址
	 */
	private String ipAddress;
	private SocketData socketData;
	/**
	 *根据SocketData创建对象 
	 */
	public ChannelData(SocketData socketData) {
		
		this(null,socketData);
	}
	
	public ChannelData(String ipAddress, SocketData socketData) {
		super();
		this.ipAddress = ipAddress;
		this.socketData = socketData;
	}
	public String getIpAddress() {
		return ipAddress;
	}
	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}
	public SocketData getSocketData() {
		return socketData;
	}
	public void setSocketData(SocketData socketData) {
		this.socketData = socketData;
	}

}
