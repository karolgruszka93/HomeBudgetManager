package desktop.javafx.HomeBudgetManager.Application;

import static org.junit.Assert.assertSame;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import desktop.javafx.HomeBudgetManager.Application.AllExpensesTabController;
import desktop.javafx.HomeBudgetManager.Application.Budget;
import desktop.javafx.HomeBudgetManager.Application.ConstantExpenses;
import desktop.javafx.HomeBudgetManager.Application.PlannedExpenses;
import desktop.javafx.HomeBudgetManager.Application.Savings;

public class AllExpensesTabControllerTest 
{
	AllExpensesTabController test =  new AllExpensesTabController();
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
	public void prepareDataToConstExpChartTest()
	{
		assertSame(ce, test.prepareDataToConstExpChart(budgetList, chosenYear).get(0));
	}
	
	@Test
	public void prepareDataToSavChartTest()
	{
		assertSame(sv, test.prepareDataToSavChart(budgetList, chosenYear).get(0));
	}
	
	@Test
	public void prepareDataToPlanExpChartTest()
	{
		assertSame(pe, test.prepareDataToPlanExpChart(budgetList, chosenYear).get(0));
	}
}
