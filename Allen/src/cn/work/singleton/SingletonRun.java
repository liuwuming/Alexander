package cn.work.singleton;


public class SingletonRun {


	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//这样的调用不被允许，因为构造方法是私有的。
		//Singleton x=new Singleton();
		
		//得到一个Singleton类实例
		Singleton x=Singleton.getInstance();
		
		//得到另一个Singleton类实例
		Singleton y=Singleton.getInstance();
		
		//比较x和y的地址，结果为true。说明两次获得的是同一个对象
		System.out.println(x==y);

	}


}
