package entities.services;

public interface OnlinePayment {
	
	public Double simpleInterest(int months, double amount);
	
	public Double paymentFee(double amount);

}
