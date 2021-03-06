package test.moniTerminal;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import gate.util.StringUtils;
import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.FixedLengthFrameDecoder;
import test.CountHelper;


public class moniTerminal {
	static EventLoopGroup work=new NioEventLoopGroup();
	public static Bootstrap config(){
		//客户这边只需要创建一个线程组
		Bootstrap bootstrap=new Bootstrap();
		bootstrap.group(work)
		.channel(NioSocketChannel.class)
		.option(ChannelOption.SO_KEEPALIVE, true)
		.option(ChannelOption.SO_SNDBUF, 32*1024)
		.option(ChannelOption.SO_RCVBUF, 32*1024)
		
		//这里方法名与服务端不一样，其他一致
		.handler(new ChannelInitializer<SocketChannel>() {

			@Override
			protected void initChannel(SocketChannel sc) throws Exception {
				//解决黏包问题，这里使用了固定长度的Decoder，因为发送的字节长度是29.
				sc.pipeline().addLast(new FixedLengthFrameDecoder(29));
				sc.pipeline().addLast(new moniTerminalHandler());
			}
		});
		return bootstrap;
	}
	public static void startClient(Bootstrap bootstrap) throws InterruptedException{
		
		
				ChannelFuture channelFuture=bootstrap.connect("127.0.0.1", port).sync();
				for(int i = 0; i<10 ; i++){
//					Thread.sleep(5000);
//					if(i % 2 == 0){
//						byte[] data = StringUtils.decodeHex("681E0081052360541304000024B801000100F007E2071A040F25090000120416");
//						
//						channelFuture.channel().writeAndFlush(Unpooled.wrappedBuffer(data));
//					}else{
						
//						byte[] data = StringUtils.decodeHex("681E0081052360541304000024B801000100F007E2071A040F25090000120416");
						/**
						 * 规约类型2
						 */
//						byte[] data = StringUtils.decodeHex("0000001906343030303132F200077076636C6F7564077076636C6F7564");
						/**
						 * 规约类型3
						 * 684A004A006800114155000000E3000001002342161526044516
						 */
						//byte[] data = StringUtils.decodeHex("684A004A006800114155000000E3000001002342161526044516");
					
					byte[] data = StringUtils.decodeHex("0000001906343030303132F200077076636C6F7564077076636C6F7564");
						channelFuture.channel().writeAndFlush(Unpooled.wrappedBuffer(data));
						
						
//					}
					
				}
				channelFuture.channel().closeFuture().sync();
				work.shutdownGracefully();
	}
	private static int port = 9812; 
	
	public static void main(String[] args) throws InterruptedException {
		/**
		 * 模拟终端启动
		 */
		final Bootstrap bootstrap =config();
		ExecutorService serExecutorService = Executors.newFixedThreadPool(CountHelper.ThreadNum);
		for(int i=0 ; i<CountHelper.ThreadNum ;i++){
			
			serExecutorService.execute(new Runnable() {
				public void run() {
					try {
						startClient(bootstrap);//阻塞运行 需要开线程启动
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			});
		}
	}
}
