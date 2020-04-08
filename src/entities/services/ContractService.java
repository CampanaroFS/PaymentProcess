package entities.services;

import java.util.Calendar;
import java.util.Date;

import entities.Contract;
import entities.Installment;

public class ContractService {

	private OnlinePayment onlinePayment;
	
	public ContractService(OnlinePayment onlinePayment) {
		this.onlinePayment = onlinePayment;
	}

	public void processContract(Contract contract, int months) {

		double value = contract.getTotalValue() / months;
		int i = 1;

		while (i <= months) {
			Date nextInstallment = addMonths(contract.getDate(), i);
			
			double simpleInterestValue = value + onlinePayment.simpleInterest(i, value);
			double valueWithFee = simpleInterestValue + onlinePayment.paymentFee(simpleInterestValue);
			contract.setInstallment(new Installment(nextInstallment, valueWithFee));
			
			i++;
		}
	}

	private Date addMonths(Date date, int i) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.MONTH, i);
		return cal.getTime();
	}

}
