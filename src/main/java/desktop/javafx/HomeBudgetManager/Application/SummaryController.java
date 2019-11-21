package desktop.javafx.HomeBudgetManager.Application;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.Pane;

public class SummaryController extends BudgetController 
{
	private ArrayList<Budget> budgetList = null;
	private Calendar chosenYear;

    @FXML
    private TabPane tabPane;
    @FXML
    private Tab constantExpensesTab;
    @FXML
    private Tab plannedExpensesTab;
    @FXML
    private Tab savingsTab;
    @FXML
    private Tab allExpensesTab;

//------GETTER'S------//
	
	protected ArrayList<Budget> getBudgetList() 
	{
		return budgetList;
	}

//------SETTER'S------//
		
	protected void setBudgetList(ArrayList<Budget> budgetList) 
	{
		this.budgetList = budgetList;
	}

//------METHODS'S------//

    @FXML
    void onClickApplyYearButton(ActionEvent event) 
    {
      	try 
    	{
        	String inputYear = textFieldYears.getText();
        	if ((Integer.parseInt(inputYear) > 0) & (Integer.parseInt(inputYear) < 10000))
        	{
        		chosenYear.set(Calendar.YEAR, Integer.parseInt(inputYear));
            	applyYearButton.setMouseTransparent(true);
            	applyYearButton.setDisable(true);
            	textFieldYears.setMouseTransparent(true);
            	textFieldYears.setDisable(true);
        	}
        	else
        	{        		
        		loadWarningScreen("Wrong value. \nEnter a year from 1 to 9999 and try again.");
        	}
    	}
    	catch(NumberFormatException e)
    	{
    		loadWarningScreen("The 'year' field must contain a numeric value. \nTry again.");
    	} 
      	
		loadConstantExpensesTab();
    }
    
	@FXML
    private void initialize()
	{
		chosenYear = Calendar.getInstance();
	}
	
	protected void loadConstantExpensesTab()
	{
		Pane pane = null;
		FXMLLoader loader = new FXMLLoader();
    	loader.setLocation(this.getClass().getResource("/fxml/ConstantExpensesTab.fxml"));
    	try 
    	{
			pane = loader.load();
		} 
    	catch (IOException e) 
    	{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		constantExpensesTab.setContent(pane);
		ConstantExpensesTabController constantExpensesTabController = loader.getController();
		constantExpensesTabController.drawChart(budgetList, chosenYear);
	}
}
