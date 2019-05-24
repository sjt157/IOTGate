package gate.codec;

import gate.rpc.dataBridge.ResponseData;
import gate.util.SerializationUtil;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

/**
* @author 宋建涛 E-mail:1872963677@qq.com
* @version 创建时间：2019年5月24日 下午2:02:18
* 类说明
*/
public class RpcEncoder extends MessageToByteEncoder<ResponseData> {
	@Override
	protected void encode(ChannelHandlerContext ctx, ResponseData msg, ByteBuf out) throws Exception {
		byte[] data = SerializationUtil.serialize(msg);
		out.writeShort(data.length);
		out.writeBytes(data);
	}
}
