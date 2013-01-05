package cn.work.callproc;

import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Types;

public class Callprocedure {


	/**
	 * java调用存储过程
	 * @author lwm
	 *
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		//c.countOneProxyAmount("241", "countOneProxyAmount");
//		c.calcCharge("8380101", "1", 1000, "countCharge");
//		calculate("calculate");
		calculate1();
	}
	private static Connection connection=null;
	private static CallableStatement cstmt = null;
	private static ResultSet rs = null;
	public static Connection getConnection() throws Exception, Exception, Exception{
		Class.forName("oracle.jdbc.driver.OracleDriver").newInstance();
		connection = DriverManager.getConnection ("jdbc:oracle:thin:@192.168.1.106:1521/dp","ora_dinpay3","123456");
		return connection;
	}
	
	public static void countOneProxyAmount(String id,String procName) throws Exception
	{
		try 
		{
			connection=getConnection();
			cstmt = connection.prepareCall("{call " + procName + "(?,?,?,?)}");
			cstmt.setString(1, id);
			cstmt.registerOutParameter(2, Types.FLOAT);
			cstmt.registerOutParameter(3, Types.FLOAT);
			cstmt.registerOutParameter(4, Types.FLOAT);
			cstmt.execute();
			System.out.println("v_totalAmount====>"+cstmt.getFloat(2));
			System.out.println("v_useableAmount====>"+cstmt.getFloat(3));
			System.out.println("v_unuseableAmount====>"+cstmt.getFloat(4));
		} catch(Exception e)
		{
			e.printStackTrace();
		}finally{
			cstmt.close();
			connection.close();
		}
	}
	public static void calcCharge(String merchantId, String cardType, float amount,String procName) throws Exception
	{
		try 
		{
			connection=getConnection();
			cstmt = connection.prepareCall("{call countCharge(?,?,?,?,?,?,?)}");
			cstmt.setString(1,merchantId);
			cstmt.setString(2, cardType);
			cstmt.setFloat(3, amount);
			cstmt.registerOutParameter(4, Types.DOUBLE);
			cstmt.registerOutParameter(5,Types.DOUBLE);
			cstmt.registerOutParameter(6,Types.DOUBLE);
			cstmt.registerOutParameter(7,Types.DOUBLE);
			cstmt.execute(); 
			System.out.println("v_dinpayCharge====>"+ cstmt.getDouble(4));
			System.out.println("v_oneProxyCharge====>"+cstmt.getDouble(5));
			System.out.println("v_twoProxyCharge====>"+cstmt.getDouble(6));
			System.out.println("v_riskCharge====>"+cstmt.getDouble(7));
		} catch(Exception e)
		{
			e.printStackTrace();
		}finally{
			cstmt.close();
			//connection.close();
		}
	}
	public static void calculate(String procName) throws Exception
	{
		try 
		{
			connection=getConnection();
			cstmt = connection.prepareCall("{call " + procName + "(?)}");
			cstmt.registerOutParameter(1, Types.FLOAT);
			cstmt.execute();
			System.out.println("count(*)====>"+cstmt.getFloat(1));
		} catch(Exception e)
		{
			e.printStackTrace();
		}finally{
			cstmt.close();
			connection.close();
		}
	}
	public static void calculate1() throws Exception
	{
		connection=getConnection();
		Statement stmt=connection.createStatement();
		String sql="select * from tb_one_proxy_settle t";
		rs = stmt.executeQuery(sql);
		while(rs.next()){
			BigDecimal a = rs.getBigDecimal("FD_TOTAL_ONE_PROXY_CHARGE");
			BigDecimal b = rs.getBigDecimal("FD_TOTAL_TWO_PROXY_CHARGE");
			System.out.println(String.valueOf(a)+","+String.valueOf(b));
		}
		
	}

}
