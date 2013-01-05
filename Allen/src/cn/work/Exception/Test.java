package cn.work.Exception;

import java.util.ArrayList;
import java.util.List;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args)throws Exception {
		try {
			List list = new ArrayList();
			System.out.println(list.get(1));
		} catch (Exception e) {
			throw new Exception("没有值！！！！！");
		}
	}

}
