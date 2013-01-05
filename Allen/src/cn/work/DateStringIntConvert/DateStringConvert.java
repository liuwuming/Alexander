package cn.work.DateStringIntConvert;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import sun.tools.jar.Main;

public class DateStringConvert {
	public static void main(String[] args) {
		
		SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");   
		SimpleDateFormat format2 = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒");  
		
		Date date1 = null;   
		Date date2 = null; 
		String str1 = "2009-02-14 12:00:00";   
		String str2 = "2009年02月14日 12时00分00秒"; 
		
		Date date3 = new Date();
		Date date4 = new Date();
		String str3="";
		String str4="";
		
		try {
			date1 = format1.parse(str1);
			date2 = format2.parse(str2);  
			System.out.println(date1+"===="+date2);
			
			str3=format1.format(date3);
			str4=format2.format(date4);
			System.out.println(str3+"===="+str4);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}   
	}
}
