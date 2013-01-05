package cn.work.timerTask;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;

/**
 * 定时器
 * @author lwm
 *
 */
public class ScheduleAtFixedRate {
	public static void main(String[] args) {
//		TestScheduleAtFixedRate1();
		TestScheduleAtFixedRate2();
	}
	static int i=0;
	public static void TestScheduleAtFixedRate1(){
		 Timer timer = new Timer();
			Calendar calendar = Calendar.getInstance();
			if (new SimpleDateFormat("HH").format(new Date()).compareTo("12")<0) {
				calendar.set(Calendar.HOUR_OF_DAY, 11);  //设置：小时
			}else {
//				calendar.add(Calendar.DAY_OF_MONTH, 1); //设置：月
				calendar.set(Calendar.HOUR_OF_DAY, 15);//设置：小时
			}
			calendar.set(Calendar.MINUTE, 56); //设置：分钟
			calendar.set(Calendar.SECOND, 30); //设置：秒钟
			Date firstWithdrawTime = calendar.getTime(); //获取设置好的时间启动定时任务。
			
			timer.scheduleAtFixedRate(new java.util.TimerTask(){
				public void run(){
					sayHi();
				}
			}, firstWithdrawTime, 1*1*1*1000L); //1秒执行一次
	}
	public static void TestScheduleAtFixedRate2(){
		Timer timer = new Timer();
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.HOUR_OF_DAY, 16);
		cal.set(Calendar.MINUTE, 04);
		cal.set(Calendar.SECOND, 30);
		
//		if(new Date().after(cal.getTime()))	//判断设定的时间是否在当前时间之后
//		{
//			cal.add(Calendar.DAY_OF_MONTH, 0);
////			cal.add(Calendar.MONTH, 1);
////			cal.add(Calendar.YEAR, 1);
//		}
	    Date firstSettleTime = cal.getTime();
//	    SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//	    System.out.println("date=>"+sdf.format(firstSettleTime));
	    timer.scheduleAtFixedRate(new java.util.TimerTask() {
			public void run() {
				sayHi();
			}
		}, firstSettleTime,24 * 60 * 60 * 1000L);
	}
	public static void sayHi(){
		System.out.println("定时任务=》"+i++);
	}
}
