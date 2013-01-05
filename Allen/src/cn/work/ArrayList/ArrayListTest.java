package cn.work.ArrayList;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ArrayListTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<Test> list=new ArrayList<Test>();
		Test t=null;
		BigDecimal withdrawAmt = new BigDecimal(100);
		BigDecimal withdrawMaxAmt = new BigDecimal(40);
		BigDecimal withdrawMinAmt = new BigDecimal(10);
		t.setAA("bb");
		System.out.println("withdrawAmt1=>"+withdrawAmt+">=<"+withdrawMaxAmt);
		if(withdrawAmt.compareTo(withdrawMaxAmt)!=-1){
			while(withdrawAmt.compareTo(withdrawMaxAmt)!=-1){
				t=new Test();
				
				t.setBB(withdrawMaxAmt);
				list.add(t);
				withdrawAmt = withdrawAmt.subtract(withdrawMaxAmt);
				System.out.println("withdrawAmt2=>"+withdrawAmt);
				if (withdrawAmt.compareTo(withdrawMaxAmt)!=-1) {
					continue;
				}else {
					 System.out.println("withdrawAmt3=>"+withdrawAmt+">=<"+withdrawMinAmt);
					if(withdrawAmt.compareTo(withdrawMinAmt)!=-1){
						t=new Test();
					
						t.setBB(withdrawAmt);
						list.add(t);
					}
					break;
				}
				}
			 }
		System.out.println(list.size());
		for(Test c : list){
			System.out.println(c.getAA()+"+"+c.getBB());
		}
		}
}
