package desktop.javafx.HomeBudgetManager.Application;

import java.util.ArrayList;
import java.util.Calendar;

import javafx.fxml.FXML;

public class AllExpensesTabController extends TabController
{

	//------GETTER'S------//
	    

	//------SETTER'S------//
	  	
	  	
	//------METHOD'S------//
	  	
	@FXML
	private void initialize()
	{
		
	}
	
	protected ArrayList<Budget> prepareDataToConstExpChart(ArrayList<Budget> budgetList, Calendar chosenYear)
	{
    	ArrayList<Budget> constantExpensesList = new ArrayList<>();
    	if (budgetList.size() != 0)
    	{
			for(int i=0; i<budgetList.size(); i++)
			{
				if((budgetList.get(i) instanceof ConstantExpenses) 
						&& (budgetList.get(i).getChosenYear() == chosenYear.get(Calendar.YEAR)))
				{
					constantExpensesList.add(budgetList.get(i));
				}
			}
    	}
		return constantExpensesList;
	}
	
	protected ArrayList<Budget> prepareDataToSavChart(ArrayList<Budget> budgetList, Calendar chosenYear)
	{
		ArrayList<Budget> savingsList = new ArrayList<>();
	    if (budgetList.size() != 0)
	    {
			for(int i=0; i<budgetList.size(); i++)
			{
				if((budgetList.get(i) instanceof Savings) 
						&& (budgetList.get(i).getChosenYear() == chosenYear.get(Calendar.YEAR)))
				{
					savingsList.add(budgetList.get(i));
				}
			}
	    }
		return savingsList;
	}
	
	protected ArrayList<Budget> prepareDataToPlanExpChart(ArrayList<Budget> budgetList, Calendar chosenYear)
	{
		ArrayList<Budget> plannedExpensesList = new ArrayList<>();
	    if (budgetList.size() != 0)
	    {
			for(int i=0; i<budgetList.size(); i++)
			{
				if((budgetList.get(i) instanceof PlannedExpenses) 
						&& (budgetList.get(i).getChosenYear() == chosenYear.get(Calendar.YEAR)))
				{
					plannedExpensesList.add(budgetList.get(i));
				}
			}
	    }
		return plannedExpensesList;
	}
}
