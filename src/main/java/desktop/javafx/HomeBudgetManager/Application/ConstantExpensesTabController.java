package desktop.javafx.HomeBudgetManager.Application;

import java.util.ArrayList;
import java.util.Calendar;

import javafx.fxml.FXML;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;

public class ConstantExpensesTabController
{	
    @FXML
    private AreaChart<String, Integer> constantExpensesAreaChart;
    @FXML
    private CategoryAxis constantExpensesAxisX;
    @FXML
    private NumberAxis constantExpensesAxisY;
    @FXML
    private Label monthsLabel;
    @FXML
    private Label amountLabel;

//------GETTER'S------//
    

//------SETTER'S------//
  	
  	
//------METHOD'S------//
  	
	@FXML
    private void initialize()
	{
		
	}

    void drawChart(ArrayList<Budget> budgetList, Calendar chosenYear)
    {
   /* 	XYChart.Series<String, Integer> dataSeries = new XYChart.Series<String, Integer>();
    	dataSeries.getData().add(new XYChart.Data<String, Integer>( "Sty", 100));
    	dataSeries.getData().add(new XYChart.Data<String, Integer>( "Luty", 230));
    	dataSeries.getData().add(new XYChart.Data<String, Integer>( "Marzec", 311));
    	dataSeries.getData().add(new XYChart.Data<String, Integer>( "Kwiecien", 505));
    	dataSeries.getData().add(new XYChart.Data<String, Integer>( "Maj", 545));
    	dataSeries.getData().add(new XYChart.Data<String, Integer>( "Cze", 214));
    	dataSeries.getData().add(new XYChart.Data<String, Integer>( "Lip", 532));
    	dataSeries.getData().add(new XYChart.Data<String, Integer>( "Sier", 526));
    	dataSeries.getData().add(new XYChart.Data<String, Integer>( "Wrze", 11114));
    	dataSeries.getData().add(new XYChart.Data<String, Integer>( "Pazdzier", 332));
    	dataSeries.getData().add(new XYChart.Data<String, Integer>( "List", 244));
    	dataSeries.getData().add(new XYChart.Data<String, Integer>( "Grudzien", 12)); */
    	ArrayList<ConstantExpenses> constantExpensesList = null;
    	if (budgetList.size() != 0)
      	{
    		for(int i=0; i<budgetList.size(); i++)
    		{
    			if((budgetList.get(i) instanceof ConstantExpenses) 
   					&& (budgetList.get(i).getChosenYear() == chosenYear.get(Calendar.YEAR)))
    			{
    				constantExpensesList.add((ConstantExpenses)budgetList.get(i));
    			}
    		}
      	}

    //	constantExpensesAreaChart.getData().add(dataSeries);
    }
}
