package desktop.javafx.HomeBudgetManager.Application;

import java.math.BigDecimal;
import java.util.Calendar;

public class ConstantExpenses extends Budget
{
	protected String amountDescription;
	protected BigDecimal amount;

	ConstantExpenses()
	{
		super();
	}
	
	ConstantExpenses(String amountDescription, BigDecimal amount, int month, int year)
	{
		super.currentDate = Calendar.getInstance();
		super.chosenDate = Calendar.getInstance();
		super.chosenDate.set(Calendar.YEAR, year);
		super.chosenDate.set(Calendar.MONTH, month);
		this.amountDescription = amountDescription;
		this.amount = amount;
	} 
	
//------GETTER'S------//
	
	public String getAmountDescription() 
	{
		return amountDescription;
	}
	
	public BigDecimal getAmount() 
	{
		return amount;
	}
	
//------SETTER'S------//

	public void setAmountDescription(String amountDescription) 
	{
		this.amountDescription = amountDescription;
	}
	
	public void setAmount(BigDecimal amount) 
	{
		this.amount = amount;
	}

//------METHOD'S------//
	
	protected void addToBudget(String amountDescription, BigDecimal amount)
	{
		this.amountDescription = amountDescription;
		this.amount = amount;	
	}
}
