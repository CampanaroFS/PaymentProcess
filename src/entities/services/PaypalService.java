package entities.services;

public class PaypalService implements OnlinePayment {
	
	public Double simpleInterest(int months, double amount) {
		return amount * 0.01 * months;
	}
	
	public Double paymentFee(double amount) {
		return amount * 0.02;
	}

}
