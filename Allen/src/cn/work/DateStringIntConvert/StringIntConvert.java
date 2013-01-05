package cn.work.DateStringIntConvert;

public class StringIntConvert {
	public static void main(String[] args) {
		
		//int 转 String   
		int cnt = 1250;   
		//方法一   
		String c1 = Integer.toString(cnt);   
		//方法二   
		String c2 = String.valueOf(cnt);//直接使用String类的静态方法，只产生一个对象   
		//方法三   
		String c3 = "" + cnt; //会产生两个String对象   
		    
		//String 转 int   
		int num2 = 0;   
		//方法一   
		int num1 = new Integer("100").intValue();//直接强制转换   
		//方法二   
		try {   
			num2 = Integer.parseInt("200");//直接使用静态方法，不会产生多余的对象，但会抛出异常   
		}   
		catch(Exception e) {   
		    System.out.println("<font color=red>"+e+"</font>");   
		}   
		//方法三   
		int num3 = Integer.valueOf("300").intValue();   
		//Integer.valueOf(s) 相当于 new Integer(Integer.parseInt(s))，也会抛异常，但会多产生一个对象
		
	}
}
