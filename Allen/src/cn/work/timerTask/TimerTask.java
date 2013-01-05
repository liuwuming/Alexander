package cn.work.timerTask;

import java.util.Timer;



public class TimerTask extends java.util.TimerTask {

	/**Timer定时器测试
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Timer t=new Timer();
		TimerTask tt=new TimerTask(0,0);
		t.schedule(tt, 0,1*1*2*1000); //0秒执行后，过2秒执行一次
	}

	public int index=0;
	@Override
	public void run() {
		index++;
		System.out.println("定时任务每2秒钟执行一次==>第"+index+"次执行run()方法");
		//this.cancel();
	}
	static{
		System.out.println("静态代码块运行");
	}
	public TimerTask(int x,int y){
		System.out.println("构造方法输出：x=>"+x+"y=>"+y);
	}

}
