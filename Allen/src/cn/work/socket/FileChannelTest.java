package org.springframework.security.web.authentication;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 *
	传统的BIO里面socket.read()，如果TCP RecvBuffer里没有数据，函数会一直阻塞，直到收到数据，返回读到的数据。
	
	对于NIO，如果TCP RecvBuffer有数据，就把数据从网卡读到内存，并且返回给用户；反之则直接返回0，永远不会阻塞。
	
	最新的AIO(Async I/O)里面会更进一步：不但等待就绪是非阻塞的，就连数据从网卡到内存的过程也是异步的。
	
	换句话说，BIO里用户最关心“我要读”，NIO里用户最关心”我可以读了”，在AIO模型里用户更需要关注的是“读完了”。
	
	NIO一个重要的特点是：socket主要的读、写、注册和接收函数，在等待就绪阶段都是非阻塞的，真正的I/O操作是同步阻塞的（消耗CPU但性能非常高）。
 * @author lwm-t196
 *
 */
public class FileChannelTest {
	public static void main(String[] args) {
//		method1();
		method2();
	}
	/**
	 * NIO RandomAccessFile的FileChannel 进行读取操作
	 */
	public static void method1(){
        RandomAccessFile aFile = null;
        try{
            aFile = new RandomAccessFile("E:\\file.txt","rw");
            FileChannel fileChannel = aFile.getChannel();
            ByteBuffer buf = ByteBuffer.allocate(1024);
 
            int bytesRead = fileChannel.read(buf);
            System.out.println(bytesRead);
 
            while(bytesRead != -1)
            {
                buf.flip();
                while(buf.hasRemaining())
                {
                    System.out.print((char)buf.get());
                }
 
                buf.compact();
                bytesRead = fileChannel.read(buf);
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally{
            try{
                if(aFile != null){
                    aFile.close();
                }
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }
	/**
	 * 传统BIO  采用FileInputStream读取文件内容
	 */
	public static void method2(){
	       InputStream in = null;
	       try{
	           in = new BufferedInputStream(new FileInputStream("E:\\file.txt"));
	 
	           byte [] buf = new byte[1024];
	           int bytesRead = in.read(buf);
	           while(bytesRead != -1)
	           {
	               for(int i=0;i<bytesRead;i++)
	                   System.out.print((char)buf[i]);
	               bytesRead = in.read(buf);
	           }
	       }catch (IOException e)
	       {
	           e.printStackTrace();
	       }finally{
	           try{
	               if(in != null){
	                   in.close();
	               }
	           }catch (IOException e){
	               e.printStackTrace();
	           }
	       }
	   }
}
