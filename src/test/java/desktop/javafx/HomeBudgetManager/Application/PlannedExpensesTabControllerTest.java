package desktop.javafx.HomeBudgetManager.Application;

import static org.junit.Assert.assertSame;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PlannedExpensesTabControllerTest 
{
	PlannedExpensesTabController test =  new PlannedExpensesTabController();
	ArrayList<Budget> budgetList = new ArrayList<Budget>();
	BigDecimal amount = new BigDecimal(1.0);
	ConstantExpenses ce = new ConstantExpenses("description", amount, 0, 2020);
	Savings sv = new Savings("description", amount, 0, 2020);
	PlannedExpenses pe = new PlannedExpenses("description", amount, 0, 2020);
	Calendar chosenYear = Calendar.getInstance();
	
	@BeforeEach
	public void setTestData()
	{
		budgetList.add(ce);
		budgetList.add(sv);
		budgetList.add(pe);
		chosenYear.set(Calendar.YEAR, 2020);
	}
	
	@Test
	public void prepareDataToChartTest()
	{
		assertSame(pe, test.prepareDataToChart(budgetList, chosenYear).get(0));
	}
}
