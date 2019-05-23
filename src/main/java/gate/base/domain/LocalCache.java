package gate.base.domain;
/**
* @author 宋建涛 E-mail:1872963677@qq.com
* @version 创建时间：2019年5月23日 下午4:08:16
* 本地缓存	统一接口
*/
public interface LocalCache {
	Object get(Object key);

	void set(Object key ,Object value);
	
	boolean del(Object key);
}
