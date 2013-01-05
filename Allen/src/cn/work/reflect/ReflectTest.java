package cn.work.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;


public class ReflectTest {


	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		//静态方法直接调用
//		myTest();
//		myTestOne();
//		myTestTwo();
//		myTestThree();
		myTestFour();
	}
	public static void myTest() throws Exception{
		Class c=Class.forName("cn.bway.sendtask.test.TTest");
		//通过类的自审，获取类的所有方法和属性
		Method [] method=c.getDeclaredMethods();  //方法
		for(Method me:method){
			String str=me.toString();
			String str1=me.getName(); //获得方法名称
			str=str.substring(str.lastIndexOf(".")+1,str.length());
			str=str.toLowerCase(); //转换小写
			System.out.println(str1);
		}
		Field [] field=c.getDeclaredFields(); //属性
		for(Field f:field){
			String str=f.toString();
			Object str1=f.getName();//获得属性名称
			Object str2=f.getType().getSimpleName(); //获得属性的类型
			if(str2.equals("int")){
				System.out.println("是int类型的");
			}
			str=str.substring(str.lastIndexOf(".")+1,str.length());
			str=str.toUpperCase(); //转换大写
			System.out.println(str1);
		}
		
	}
	/*
	 *静态代码块运行
	 ******************
	  构造方法
	  构造方法
	 true
	 */
	public static void myTestOne() throws Exception{
		TTest tt=null;
		Class c=Class.forName("cn.bway.sendtask.test.TTest");
		System.out.println("******************");
		tt=(TTest) c.newInstance();
		TTest tt1=new TTest(0,0);
		System.out.println(tt.getClass()==tt1.getClass());
	}
	public static void myTestTwo(){
		try {
			//获得指定字符串类对象
			Class<?> cla=Class.forName("cn.bway.sendtask.test.TTest");
			//设置Class对象数组，用于指定构造方法类型
			Class[] cl=new Class[]{int.class,int.class};
			
			//获得Constructor构造器对象。并指定构造方法类型
			Constructor con=cla.getConstructor(cl);
			
			//给传入参数赋初值
			Object[] x={new Integer(33),new Integer(67)};
			
			//得到实例
			Object obj=con.newInstance(x);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
   public static void myTestThree() throws  Exception{
	   try {
		 //获得窗体类的Class对象
		   Class cla=Class.forName("cn.bway.sendtask.test.TTest");
		//生成窗体类的实例
		   Object   obj=cla.newInstance();  //注意new的是一个无参的构造函数
		//获得窗体类的setValue方法对象，并指定该方法参数类型为int,int
		Method method=cla.getMethod("setSize", new Class[]{int.class,int.class});
		/*
		 * 执行setValue()方法，并传入一个Object[]数组对象， 
		 * 作为该方法参数，等同于  窗体对象.setSize(300,300);
		 */
		method.invoke(obj, new Object []{new Integer(300),new Integer(300)});
		
		//获得窗体类的setSize方法对象，并指定该方法参数类型为boolean
		Method methodVisible=cla.getMethod("setVisible", new Class[]{boolean.class});
		
		/*
		 * 执行setVisible()方法，并传入一个Object[]数组对象，  			    *作为该方法参数。 等同于  窗体对象.setVisible(true);
		 */
		methodVisible.invoke(obj, new Object[]{new Boolean(true)});
		

	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
   }
   
   public static void myTestFour() throws Exception{
		Class c=Class.forName("cn.work.reflect.TTest");
		Map map=mapKey3Lowercase(mapValue());
		Field [] field1=c.getDeclaredFields(); //属性
		for(int i=0; i<field1.length;i++){
			Object name=field1[i].getName();//获得属性名称
			Object strValue=map.get(name);//获得属性值
			System.out.println(name+"="+strValue+",");
		}
	}
 //将老的map转换至新的map,并将key转换为小写
	public static Map mapKey3Lowercase(Map mapV) {
		Map map=new HashMap();
		Set keyset=mapV.keySet();
		for (Iterator iterator = keyset.iterator(); iterator.hasNext();) {
			Object key = (Object) iterator.next();
			Object svalue=mapV.get(key);
			Object skey=key.toString().toLowerCase();
//			System.out.println(skey+"==="+svalue);
			if(skey!=null&&svalue!=null){
				map.put(skey, svalue);
			}
		}
		return map;
	}
	
	public static Map mapValue(){
		Map map=new HashMap();
		map.put("CATEGORY", "merchant");
		map.put("categoryID", "8380101");
		map.put("index", "8380101");
		return map;
	}

}
