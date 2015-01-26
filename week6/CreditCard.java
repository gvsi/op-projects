public class CreditCard {
	private int expiryMonth;
	private int expiryYear;
	private String firstName;
	private String lastName;
	private String ccNumber;
	
	public CreditCard(int expiryMonth, int expiryYear, String firstName, String lastName, String ccNumber) {
		this.expiryMonth = expiryMonth;
		this.expiryYear = expiryYear;
		this.firstName = firstName;
		this.lastName = lastName;
		this.ccNumber = ccNumber;
	}
	
	public String formatExpiryDate() {
		return String.format("%d/%d", this.expiryMonth, this.expiryYear % 100);
	}
	
	public String formatFullName() {
		return String.format("%s %s", this.firstName, this.lastName);
	}
	
	public String formatCCNumber() {
		return String.format("%s %s %s %s", this.ccNumber.substring(0, 4), this.ccNumber.substring(4, 8), this.ccNumber.substring(8, 12), this.ccNumber.substring(12));
	}
	
	public boolean isValid() {
		// to implement
		return true;
	}
	
	public String toString() {
		return String.format("Number: %s\nExpiration date: %s\nAccount holder: %s\nIs valid: %s", formatCCNumber(), formatExpiryDate(), formatFullName(), isValid());
	}
	
	public static void main(String[] args) {
		CreditCard cc1 = new CreditCard(10, 2014, "Bob", "Jones", "1234567890123456");
		System.out.println(cc1);
	}
}
