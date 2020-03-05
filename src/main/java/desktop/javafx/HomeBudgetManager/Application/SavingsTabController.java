package desktop.javafx.HomeBudgetManager.Application;

import java.util.ArrayList;
import java.util.Calendar;

public class SavingsTabController extends TabController
{

	protected ArrayList<Budget> prepareDataToChart(ArrayList<Budget> budgetList, Calendar chosenYear)
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
}
