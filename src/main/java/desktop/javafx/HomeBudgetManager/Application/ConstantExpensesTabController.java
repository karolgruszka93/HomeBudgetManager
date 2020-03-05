package desktop.javafx.HomeBudgetManager.Application;

import java.util.ArrayList;
import java.util.Calendar;

public class ConstantExpensesTabController extends TabController
{	
 
	protected ArrayList<Budget> prepareDataToChart(ArrayList<Budget> budgetList, Calendar chosenYear)
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
}
