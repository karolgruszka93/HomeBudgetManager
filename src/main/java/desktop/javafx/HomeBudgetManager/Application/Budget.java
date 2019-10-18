package desktop.javafx.HomeBudgetManager.Application;

import java.text.SimpleDateFormat;
import java.util.Calendar;


public class Budget 
{
	protected Calendar currentDate;
	protected Calendar chosenDate;

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
	
//------SETTER'S------//
	
	protected void setChosenDate(int month, int year) 
	{		
		this.chosenDate.set(Calendar.YEAR, year);
		this.chosenDate.set(Calendar.MONTH, month);
	}
}
