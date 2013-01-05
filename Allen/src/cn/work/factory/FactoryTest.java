package cn.work.factory;


public class FactoryTest {

		/**
		 * @param args
		 */
		public static void main(String[] args) {
			//获得工厂类的实例
			Factory factory=Factory.getFactory();
			//调用获得接口对象的方法，获得接口对象
			InterfaceTest inter=factory.getInterface();
			//调用接口定义的方法
			inter.getName();

		}
}
