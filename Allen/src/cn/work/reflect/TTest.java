package cn.work.reflect;

public class TTest {
	public int index=0;
	
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}

	static{
		System.out.println("静态代码块运行");
	}
	public TTest() {
		System.out.println("构造方法输出");
	}
	public TTest(int x,int y){
		System.out.println("构造方法输出：x=>"+x+"y=>"+y);
	}
	public void setSize(int i,int j){
		System.out.println(i+j);
	}
	
	public void setVisible(boolean b){
		System.out.println(b);
	}
	
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}
	@Override
	protected void finalize() throws Throwable {
		// TODO Auto-generated method stub
		super.finalize();
	}
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "index=>"+index;
	}
	
	
	public static void main(String[] args) {
		TTest tt=new TTest();
		tt.setIndex(11);
		System.out.println(tt);
	}
}
