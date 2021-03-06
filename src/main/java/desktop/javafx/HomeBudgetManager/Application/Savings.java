package desktop.javafx.HomeBudgetManager.Application;

import java.math.BigDecimal;
import java.util.Calendar;

public class Savings extends Budget
{
	Savings()
	{
		super();
	}
	
	Savings(String amountDescription, BigDecimal amount, int month, int year)
	{
		super.currentDate = Calendar.getInstance();
		super.chosenDate = Calendar.getInstance();
		super.chosenDate.set(Calendar.YEAR, year);
		super.chosenDate.set(Calendar.MONTH, month);
		super.chosenDate.set(Calendar.DAY_OF_MONTH, 15);
		super.amountDescription = amountDescription;
		super.amount = amount;
	} 
	
}
