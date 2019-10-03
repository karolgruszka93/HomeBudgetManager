package desktop.javafx.HomeBudgetManager.Application;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Budget 
{
	private Calendar currentDate;
	private Calendar chosenDate;
	private BigDecimal amount;
	private String amountDescription;

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
	
	protected BigDecimal getAmount()
	{
		return amount;
	}
	
	protected String getAmountDescription()
	{
		return amountDescription;
	}


//------SETTER'S------//
	
	protected void setChosenDate(int month, int year) 
	{		
		this.chosenDate.set(Calendar.YEAR, year);
		this.chosenDate.set(Calendar.MONTH, month);
	}
	
	protected void setAmount(BigDecimal amount)
	{
		this.amount = amount;
	}
	
	protected void setAmountDescription(String amountDescription)
	{
		this.amountDescription = amountDescription;
	}

//------METHOD'S------//
	
	protected void addToBudget(String amountDescription, BigDecimal amount)
	{
		setAmountDescription(amountDescription);
		setAmount(amount);
	}
	
}
