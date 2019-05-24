package gate.rpc.dataBridge;

import java.io.Serializable;
import java.util.List;

/**
* @author 宋建涛 E-mail:1872963677@qq.com
* @version 创建时间：2019年5月23日 下午8:22:06
* 类说明：封装响应参数
*/
public class ResponseData implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8989064767424020295L;
	
	private String responseNum;
	/**
	 * 返回状态码
	 * 200 成功
	 * 500 失败
	 */
	private int returnCode = 200;
	private List<Object> data;
	private Throwable erroInfo;

	public int getReturnCode() {
		return returnCode;
	}

	public void setReturnCode(int returnCode) {
		this.returnCode = returnCode;
	}

	public List<Object> getData() {
		return data;
	}

	public void setData(List<Object> data) {
		this.data = data;
	}

	public Throwable getErroInfo() {
		return erroInfo;
	}

	public void setErroInfo(Throwable erroInfo) {
		this.erroInfo = erroInfo;
	}

	public String getResponseNum() {
		return responseNum;
	}

	public void setResponseNum(String responseNum) {
		this.responseNum = responseNum;
	}

}
