package desktop.javafx.HomeBudgetManager.Application;

import java.util.ArrayList;
import java.util.Calendar;

import javafx.fxml.FXML;

public class PlannedExpensesTabController extends TabController 
{

	//------GETTER'S------//
	    

	//------SETTER'S------//
	  	
	  	
	//------METHOD'S------//
	  	
	@FXML
	private void initialize()
	{
		
	}

	protected ArrayList<Budget> prepareDataToChart(ArrayList<Budget> budgetList, Calendar chosenYear)
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