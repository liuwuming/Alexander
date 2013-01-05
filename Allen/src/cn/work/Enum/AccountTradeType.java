package cn.work.Enum;
/**
 * 枚举
 * @author lwm
 *
 */
public enum AccountTradeType {
	Account_Tradetype_Payment(01,"支付"),
	Account_Tradetype_PaymentCleare(02,"支付结算"),
	Account_Tradetype_Withdrawals(11,"提现"),
	Account_Tradetype_Transfer(12,"转账"),
	Account_Tradetype_Withdrawals_Cleare(13,"提现结算"),
	Account_Tradetype_Transfer_Cleare(14,"转账结算"),
	Account_Tradetype_PayFees(21,"支付手续费"),
	Account_Tradetype_PayFees_Cleare(22,"支付手续费结算"),
	Account_Tradetype_Proxy_Rebate(31,"代理商的返点费"),
	;
	private int status;
	private String title = null;
	
	AccountTradeType(int status, String title) {
		this.status = status;
		this.title = title;
	}

	public int getStatus() {
		return status;
	}

	public String getTitle() {
		return title;
	}
	
	public String toString() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("AccountTradeType[status=").append(this.status)
		.append(",title=").append(this.title).append("]");
		return strBuilder.toString();
	}
}
