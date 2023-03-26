package finance_publisher;

public class Finance {
	


	private String financeID;
	private String date;
	private String transactionType;
	private int amount;
	private String description;
	private String financeId;	

	
	public Finance() {
	}

	public String getFinanceID() {
		return financeID;
	}

	public void setFinanceID(String financeID) {
		this.financeID = financeID;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	


}