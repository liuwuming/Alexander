package cn.work.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class ReflectApp {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		/**
		 * 1.构造方法的反射
		 */
//		getConstructor1();
		/**
		 * 2.成员变量的反射：
		 */
//		getDeclaredField1();
		/**
		 * 3. 成员方法的反射：
		 */
//		getDeclaredMethod2();
		/**
		 * 4. 泛型的类型检查只存在编译期间，运行期间并不存在泛型类型，可以用反射来实现题设要求
		 */
		getDeclaredMethod3();
	}
	/**
	 *1. 构造方法的反射：
	 */
	public static void getConstructor1(){
		   try {
	            //取得Class
	            Class<?> clazz = Class.forName("java.lang.Integer");
	            //取得类中参数为String类型的构造器
	            Constructor<?> constructor = clazz.getConstructor(String.class);
	            //使用构造器创建一个实例对象
	            Object obj = constructor.newInstance("10");
	            //打印结果
	            System.out.println(obj);
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	}
	/**
	 *2. 成员变量的反射：
	 */
	public static void getDeclaredField1(){
		   try {
	            //创建一个Person实例对象
	            Person person = new ReflectApp().new Person();
	            //取得Class
	            Class<?> clazz = person.getClass();
	            /******** 通过反射访问 public 权限的属性变量 ********/
	            //取得字段的属性名
	            Field age = clazz.getDeclaredField("age");
	            //设置该属性的值
	            age.set(person, 22);
	            
	            /******* 通过反射访问 protected 权限的属性变量 *******/
	            Field mail = clazz.getDeclaredField("mail");
	            mail.set(person, "fancydeepin@yeah.net");
	            
	            /******** 通过反射访问 private 权限的属性变量 ********/
	            Field name = clazz.getDeclaredField("name");
	            //private修饰的变量不能直接访问,如需访问必须要将setAccessible的值设置成true,也就是强制访问,或者说是暴力访问
	            name.setAccessible(true);
	            name.set(person, "fancy");
	            System.out.println(person);
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	}
		//内部类
	    public class Person {
	        public    int age;
	        private   String name;
	        protected String mail;
	        public int getAge() {
	            return age;
	        }
	        public String getName() {
	            return name;
	        }
	        public void setAge(int age) {
	            this.age = age;
	        }
	        public void setName(String name) {
	            this.name = name;
	        }
	        public String getMail() {
	            return mail;
	        }
	        public void setMail(String mail) {
	            this.mail = mail;
	        }
	        @Override
	        public String toString() {
	            
	            return "Name is：" + name + ",\t Age is：" + age + ",\t Mail is：" + mail;
	        }
	    }
	    
	    
	    /**
	     *3. 成员方法的反射：
	     */
	    public static void getDeclaredMethod2(){
	    	 try {
	             //取得Class
	             Class<?> clazz = Class.forName("cn.work.reflect.ReflectApp");
	             //取得方法
	             Method method = clazz.getDeclaredMethod("print", String.class);
	             //调用该方法
	             method.invoke(clazz.newInstance(), "fancy");
	         } catch (Exception e) {
	             e.printStackTrace();
	         }
	    }
	    public void print(int arg){
	        System.out.println("Arg is int, value is " + arg);
	    }
	    public void print(String arg){
	        System.out.println("Arg is String, value is " + arg);
	    }
	    
	    
	    /**
	     * 4. 泛型的类型检查只存在编译期间，运行期间并不存在泛型类型，可以用反射来实现题设要求
	     */
	    public static void getDeclaredMethod3(){
	    	 try {
	             ArrayList<Integer> list = new ArrayList<Integer>();
	             Method add = ArrayList.class.getDeclaredMethod("add", Object.class);
	             add.invoke(list, "fancy");
	             System.out.println(list.get(0));
	         } catch (Exception e) {
	             e.printStackTrace();
	         }

	    }
	    
}	
