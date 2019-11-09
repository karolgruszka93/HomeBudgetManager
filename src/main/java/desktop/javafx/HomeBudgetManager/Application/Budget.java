package desktop.javafx.HomeBudgetManager.Application;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Calendar;


public class Budget 
{
	protected Calendar currentDate;
	protected Calendar chosenDate;
	protected String amountDescription;
	protected BigDecimal amount;

	Budget()
	{
		this.currentDate = Calendar.getInstance();
		this.chosenDate = Calendar.getInstance();
	}
	
//------GETTER'S------//

	protected String getCurrentDate() 
	{
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");	
		return dateFormat.format(currentDate.getTime());
	}
	
	protected int getChosenYear()
	{
		return chosenDate.get(Calendar.YEAR);
	}
	 
	protected int getChosenMonth()
	{
		return chosenDate.get(Calendar.MONTH);
	}
	
	public BigDecimal getAmount() 
	{
		return amount;
	}
	
	public String getAmountDescription() 
	{
		return amountDescription;
	}

//------SETTER'S------//
	
	protected void setChosenDate(int month, int year) 
	{		
		this.chosenDate.set(Calendar.YEAR, year);
		this.chosenDate.set(Calendar.MONTH, month);
	}
	
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
