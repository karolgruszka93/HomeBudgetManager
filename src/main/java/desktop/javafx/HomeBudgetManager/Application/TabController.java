package desktop.javafx.HomeBudgetManager.Application;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import javafx.fxml.FXML;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;

public abstract class TabController
{
    @FXML
    private AreaChart<String, BigDecimal> expensesAreaChart;
    @FXML
    private CategoryAxis constantExpensesAxisX;
    @FXML
    private NumberAxis constantExpensesAxisY;
    @FXML
    private Label monthsLabel;
    @FXML
    private Label amountLabel;
    
    protected void drawChart(ArrayList<Budget> expensesList)
    {
    	XYChart.Series<String, BigDecimal> dataSeries = new XYChart.Series<String, BigDecimal>();
		BigDecimal januaryAmount = new BigDecimal(0.0);
		BigDecimal februaryAmount = new BigDecimal(0.0);
		BigDecimal marchAmount = new BigDecimal(0.0);
		BigDecimal aprilAmount = new BigDecimal(0.0);
		BigDecimal mayAmount = new BigDecimal(0.0);
		BigDecimal juneAmount = new BigDecimal(0.0);
		BigDecimal julyAmount = new BigDecimal(0.0);
		BigDecimal augustAmount = new BigDecimal(0.0);
		BigDecimal septemberAmount = new BigDecimal(0.0);
		BigDecimal octoberAmount = new BigDecimal(0.0);
		BigDecimal novemberAmount = new BigDecimal(0.0);
		BigDecimal decemberAmount = new BigDecimal(0.0);

    	if (expensesList.size() != 0)
      	{
    		for(int i=0; i<expensesList.size(); i++)
    		{
    			if(expensesList.get(i).getChosenMonth() == Calendar.JANUARY)
    			{	
    				januaryAmount = januaryAmount.add(expensesList.get(i).getAmount());
    			}
    			if(expensesList.get(i).getChosenMonth() == Calendar.FEBRUARY)
    			{	
    				februaryAmount = februaryAmount.add(expensesList.get(i).getAmount());
    			}
    			if(expensesList.get(i).getChosenMonth() == Calendar.MARCH)
    			{	
    				marchAmount = marchAmount.add(expensesList.get(i).getAmount());
    			}
    			if(expensesList.get(i).getChosenMonth() == Calendar.APRIL)
    			{	
    				aprilAmount = aprilAmount.add(expensesList.get(i).getAmount());
    			}
    			if(expensesList.get(i).getChosenMonth() == Calendar.MAY)
    			{	
    				mayAmount = mayAmount.add(expensesList.get(i).getAmount());
    			}
    			if(expensesList.get(i).getChosenMonth() == Calendar.JUNE)
    			{	
    				juneAmount = juneAmount.add(expensesList.get(i).getAmount());
    			}
    			if(expensesList.get(i).getChosenMonth() == Calendar.JULY)
    			{	
    				julyAmount = julyAmount.add(expensesList.get(i).getAmount());
    			}
    			if(expensesList.get(i).getChosenMonth() == Calendar.AUGUST)
    			{	
    				augustAmount = augustAmount.add(expensesList.get(i).getAmount());
    			}
    			if(expensesList.get(i).getChosenMonth() == Calendar.SEPTEMBER)
    			{	
    				septemberAmount = septemberAmount.add(expensesList.get(i).getAmount());
    			}
    			if(expensesList.get(i).getChosenMonth() == Calendar.OCTOBER)
    			{	
    				octoberAmount = octoberAmount.add(expensesList.get(i).getAmount());
    			}
    			if(expensesList.get(i).getChosenMonth() == Calendar.NOVEMBER)
    			{	
    				novemberAmount = novemberAmount.add(expensesList.get(i).getAmount());
    			}
    			if(expensesList.get(i).getChosenMonth() == Calendar.DECEMBER)
    			{	
    				decemberAmount = decemberAmount.add(expensesList.get(i).getAmount());
    			}
    		}
   			dataSeries.getData().add(new XYChart.Data<String, BigDecimal>( "January", januaryAmount));
			dataSeries.getData().add(new XYChart.Data<String, BigDecimal>( "February", februaryAmount));
			dataSeries.getData().add(new XYChart.Data<String, BigDecimal>( "March", marchAmount));
			dataSeries.getData().add(new XYChart.Data<String, BigDecimal>( "April", aprilAmount));
			dataSeries.getData().add(new XYChart.Data<String, BigDecimal>( "May", mayAmount));
			dataSeries.getData().add(new XYChart.Data<String, BigDecimal>( "June", juneAmount));
			dataSeries.getData().add(new XYChart.Data<String, BigDecimal>( "July", julyAmount));
			dataSeries.getData().add(new XYChart.Data<String, BigDecimal>( "August", augustAmount));
			dataSeries.getData().add(new XYChart.Data<String, BigDecimal>( "September", septemberAmount));
			dataSeries.getData().add(new XYChart.Data<String, BigDecimal>( "October", octoberAmount));
			dataSeries.getData().add(new XYChart.Data<String, BigDecimal>( "November", novemberAmount));
			dataSeries.getData().add(new XYChart.Data<String, BigDecimal>( "December", decemberAmount));  
      	}
    	expensesAreaChart.getData().add(dataSeries); 
    }  
}
