package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Contract;
import entities.Installment;
import entities.services.ContractService;
import entities.services.PaypalService;

public class Program {

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		System.out.println("Enter contract data");
		System.out.print("Number: ");
		int number = sc.nextInt();
		System.out.print("Date (dd/MM/yyyy): ");
		Date date = sdf.parse(sc.next());
		System.out.print("Contract value: ");
		double totalValue = sc.nextDouble();
		sc.nextLine();
		System.out.print("Enter number of installments: ");
		int numberInstallment = sc.nextInt();

		Contract contract = new Contract(number, date, totalValue);

		ContractService cs = new ContractService(new PaypalService());
		cs.processContract(contract, numberInstallment);

		System.out.println("Installments:");
		for (Installment in : contract.getInstallment()) {
			System.out.println(in);
		}
		
		sc.close();
	}

}