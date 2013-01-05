package cn.work.uuidGenerator;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.UUID;

public class UuidGenerator {
	/**
	 * java生成唯一标示的UUID
	 * @param args
	 */
	public static void main(String[] args) {
//		String uuid=getUuidGenerator();
//		System.out.println("randomUUID=>"+uuid);
//		System.out.println("uuidLength=>"+uuid.length());
		String userName="123";
		String adviceMemo = "NPS�û�" + userName + "��" + new Date() + "������״̬���̼�(";
		try {
			String a=new String(adviceMemo.getBytes("ISO-8859-1"),"utf-8");
			System.out.println(a);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}
	public static String getUuidGenerator(){
		String uuid = UUID.randomUUID().toString();   
		return uuid.replaceAll("-", "");  
	}
}
