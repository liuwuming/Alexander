package org.springframework.security.web.authentication;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;

/**
 * 服务端使用BIO实现
 * @author lwm-t196
 *
 */
public class SocketChannelBIOServer {
	
	public static void main(String[] args) {
		server();
	}
	public static void server(){
	       ServerSocket serverSocket = null;
	       InputStream in = null;
	       try
	       {
	           serverSocket = new ServerSocket(8011);
	           int recvMsgSize = 0;
	           byte[] recvBuf = new byte[1024];
	           while(true){
	               Socket clntSocket = serverSocket.accept();
	               SocketAddress clientAddress = clntSocket.getRemoteSocketAddress();
	               System.out.println("Handling client at "+clientAddress);
	               
	               in = clntSocket.getInputStream();
	               while((recvMsgSize=in.read(recvBuf))!=-1){
	                   byte[] temp = new byte[recvMsgSize];
	                   System.arraycopy(recvBuf, 0, temp, 0, recvMsgSize);
	                   System.out.println(new String(temp));
	               }
	           }
	       }
	       catch (IOException e)
	       {
	           e.printStackTrace();
	       }
	       finally{
	           try{
	               if(serverSocket!=null){
	                   serverSocket.close();
	               }
	               if(in!=null){
	                   in.close();
	               }
	           }catch(IOException e){
	               e.printStackTrace();
	           }
	       }
	   }
}
