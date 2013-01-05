package cn.work.Enum;


public class EnumTest {

	/**
	 * 枚举测试
	 * @param args
	 */
	public static void main(String[] args) {
		// 获取枚举状态
		String accounttradetype=String.valueOf(AccountTradeType.Account_Tradetype_Payment.getStatus());
		//获取枚举title
		String accounttype=AccountTradeType.Account_Tradetype_Payment.getTitle();
		System.out.println(accounttradetype);
		System.out.println(accounttype);
	}

}
