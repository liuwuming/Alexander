package cn.work.singleton;


public class Singleton {

	//第一种声明Singletong方法
	/*
	 * 注意这是private私有的构造方法， 只供内部调用
	 * 外部不能通过new的方式来生成该类的实例
	 */ 

//	private Singleton(){
//		
//	}
	/*
	 * 在自己内部定义自己一个实例，是不是很奇怪？
	 * 定义一个静态的实例，保证其唯一性
	 */ 

//	private static Singleton instance =new Singleton();
	// 这里提供了一个供外部访问本class的静态方法，可以直接访问
//	public static Singleton getInstance(){
//		return instance ;
//	}
	
	//第二种声明方法
	//先申明该类静态对象
	private static Singleton instance = null;
	
	//创建一个静态访问器，获得该类实例。加上同步，表示防止两个线程同时进行对象的创建
	public static synchronized Singleton getInstance() {
		
		//如果为空，则生成一个该类实例
		if (instance == null){
			instance = new Singleton();
		}
		return instance;
	}


}
