package org.springframework.security.web.authentication;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

/**
 * TCP服务端的NIO写法
 * 要使用选择器（Selector），需要创建一个Selector实例（使用静态工厂方法open()）并将其注册（register）到想要监控的信道上
 * （注意，这要通过channel的方法实现，而不是使用selector的方法）。最后，调用选择器的select()方法。该方法会阻塞等待，
 * 直到有一个或更多的信道准备好了I/O操作或等待超时。select()方法将返回可进行I/O操作的信道数量。现在，在一个单独的线程中，
 * 通过调用select()方法就能检查多个信道是否准备好进行I/O操作。如果经过一段时间后仍然没有信道准备好，
 * select()方法就会返回0，并允许程序继续执行其他任务。
 * @author lwm-t196
 *
 */
public class SocketChannelNIOServer {
	
	    private static final int BUF_SIZE=1024;
	    private static final int PORT = 8011;
	    private static final int TIMEOUT = 3000;
	 
	    public static void main(String[] args) {

	    	selector();
		}
	    
	    public static void handleAccept(SelectionKey key) throws IOException{
	    	System.out.println("handleAccept start ...");
	        ServerSocketChannel ssChannel = (ServerSocketChannel)key.channel();
	        SocketChannel sc = ssChannel.accept();
	        sc.configureBlocking(false);
	        sc.register(key.selector(), SelectionKey.OP_READ,ByteBuffer.allocateDirect(BUF_SIZE));
	    }
	 
	    public static void handleRead(SelectionKey key) throws IOException{
	    	System.out.println("handleRead start ...");
	        SocketChannel sc = (SocketChannel)key.channel();
	        ByteBuffer buf = (ByteBuffer)key.attachment();
	        long bytesRead = sc.read(buf);
	        while(bytesRead>0){
	            buf.flip();
	            while(buf.hasRemaining()){
	                System.out.print((char)buf.get());
	            }
	            System.out.println();
	            buf.clear();
	            bytesRead = sc.read(buf);
	        }
	        if(bytesRead == -1){
	            sc.close();
	        }
	    }
	 
	    public static void handleWrite(SelectionKey key) throws IOException{
	    	System.out.println("handleWrite start ...");
	        ByteBuffer buf = (ByteBuffer)key.attachment();
	        buf.flip();
	        SocketChannel sc = (SocketChannel) key.channel();
	        while(buf.hasRemaining()){
	            sc.write(buf);
	        }
	        buf.compact();
	    }
	 
	    public static void selector() {
	        Selector selector = null;
	        ServerSocketChannel ssc = null;
	        try{
	            selector = Selector.open();
	            ssc= ServerSocketChannel.open();
	            ssc.socket().bind(new InetSocketAddress(PORT));
	            ssc.configureBlocking(false);
	            ssc.register(selector, SelectionKey.OP_ACCEPT);
	 
	            while(true){
	                if(selector.select(TIMEOUT) == 0){
	                    System.out.println("==");
	                    continue;
	                }
	                Iterator<SelectionKey> iter = selector.selectedKeys().iterator();
	                while(iter.hasNext()){
	                    SelectionKey key = iter.next();
	                    if(key.isAcceptable()){
	                        handleAccept(key);
	                    }
	                    if(key.isReadable()){
	                        handleRead(key);
	                    }
	                    if(key.isWritable() && key.isValid()){
	                        handleWrite(key);
	                    }
	                    if(key.isConnectable()){
	                        System.out.println("isConnectable = true");
	                    }
	                    iter.remove();
	                }
	            }
	 
	        }catch(IOException e){
	            e.printStackTrace();
	        }finally{
	            try{
	                if(selector!=null){
	                    selector.close();
	                }
	                if(ssc!=null){
	                    ssc.close();
	                }
	            }catch(IOException e){
	                e.printStackTrace();
	            }
	        }
	    }
	
	
}
