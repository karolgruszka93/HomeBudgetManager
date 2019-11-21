package desktop.javafx.HomeBudgetManager.Application;

import java.math.BigDecimal;
import java.util.Calendar;

public class PlannedExpenses extends Budget 
{
	PlannedExpenses()
	{
		super();
	}
	
	PlannedExpenses(String amountDescription, BigDecimal amount, int month, int year)
	{
		super.currentDate = Calendar.getInstance();
		super.chosenDate = Calendar.getInstance();
		super.chosenDate.set(Calendar.YEAR, year);
		super.chosenDate.set(Calendar.MONTH, month);
		super.amountDescription = amountDescription;
		super.amount = amount;
	} 
	
//------GETTER'S------//
	

	
//------SETTER'S------//



//------METHOD'S------//
}
