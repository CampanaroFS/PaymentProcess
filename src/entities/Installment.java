package entities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Installment {
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	private Date date;
	private Double amount;
	
	public Installment(Date date, Double amount) {
		this.date = date;
		this.amount = amount;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amout) {
		this.amount = amout;
	}
	
	@Override
	public String toString() {
		return sdf.format(date) + " - " + String.format("%.2f", amount);
	}
}
