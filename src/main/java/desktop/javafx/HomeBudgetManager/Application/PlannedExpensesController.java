package desktop.javafx.HomeBudgetManager.Application;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class PlannedExpensesController extends BudgetController
{
	private PlannedExpenses plannedExpenses = new PlannedExpenses();
	private ArrayList<Budget> budgetList = null;
	
	@FXML
	private Button addExpenseButton;
	@FXML
	private Button saveExpenseButton;
	@FXML
	private Button removeExpenseButton;
	@FXML
	private TableView<PlannedExpenses> expensesTableView;
	@FXML
	private TextField textFieldExpensesDescription;
	@FXML
	private TextField textFieldAmount;

//------GETTER'S------//	

	public ArrayList<Budget> getBudgetList() 
	{
		return budgetList;
	}

//------SETTER'S------//
    
	public void setBudgetList(ArrayList<Budget> budgetList) 
	{
		this.budgetList = budgetList;
	}

//------METHOD'S------//
    
	@FXML
    private void initialize()
	{
    	comboBoxMonths.getItems().addAll("January", "February", "March", "April", "May", "June", "July", "August", 
    			"September", "October", "November", "December");
    	
    	expensesTableView.setDisable(true);
    	addExpenseButton.setDisable(true);
    	removeExpenseButton.setDisable(true);
    	saveExpenseButton.setDisable(true);
    	textFieldExpensesDescription.setDisable(true);
    	textFieldAmount.setDisable(true);
    	
        TableColumn<PlannedExpenses, String> expenseDescriptionColumn = new TableColumn<>("EXPENSE");
        expenseDescriptionColumn.setCellValueFactory(new PropertyValueFactory<>("amountDescription"));
        TableColumn<PlannedExpenses, BigDecimal> amountColumn = new TableColumn<>("AMOUNT");
        amountColumn.setCellValueFactory(new PropertyValueFactory<>("amount"));
        expensesTableView.getColumns().add(expenseDescriptionColumn);
        expensesTableView.getColumns().add(amountColumn);
	}
	
    @FXML
    private void onClickApplyYearButton(ActionEvent event)
    {
     	try 
    	{
        	String inputYear = textFieldYears.getText();
        	if ((Integer.parseInt(inputYear) > 0) & (Integer.parseInt(inputYear) < 10000) & (comboBoxMonths.getValue() != null))
        	{
        		plannedExpenses.setChosenDate(parseMonth(), Integer.parseInt(inputYear));
        		selectedDateLabel.setVisible(true);
            	monthLabel.setText(comboBoxMonths.getValue());
            	yearLabel.setText(String.valueOf(plannedExpenses.getChosenYear()));
            	applyYearButton.setMouseTransparent(true);
            	applyYearButton.setDisable(true);
            	textFieldYears.setMouseTransparent(true);
            	textFieldYears.setDisable(true);
            	comboBoxMonths.setMouseTransparent(true);
            	comboBoxMonths.setDisable(true);
            	currentDateLabel.setVisible(true);
            	nowDateLabel.setText(plannedExpenses.getCurrentDate());
            	expensesTableView.setDisable(false);
            	addExpenseButton.setDisable(false);
            	removeExpenseButton.setDisable(false);
            	textFieldExpensesDescription.setDisable(false);
            	textFieldAmount.setDisable(false);
            	saveExpenseButton.setDisable(false);
        	}
        	else if(comboBoxMonths.getValue() == null)
        	{
        		loadWarningScreen("Select a month from the list and try again.");
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
    	
    	if (budgetList.size() != 0)
    	{
    		for(int i=0; i<budgetList.size(); i++)
    		{
    			if((budgetList.get(i) instanceof PlannedExpenses) 
    					&& (budgetList.get(i).getChosenMonth() == plannedExpenses.getChosenMonth())
    					&& (budgetList.get(i).getChosenYear() == plannedExpenses.getChosenYear()))
    			{
    				expensesTableView.getItems().add(new PlannedExpenses(budgetList.get(i).getAmountDescription(), 
    						budgetList.get(i).getAmount(), plannedExpenses.getChosenMonth(), plannedExpenses.getChosenYear()));
    			}
    		}
    	}
    }

    @FXML
    private void onClickAddExpenseButton(ActionEvent event)
    {
       	String amountDescription = textFieldExpensesDescription.getText();
       	try 
    	{
       		BigDecimal inputAmount = new BigDecimal(textFieldAmount.getText().replace(',', '.')).setScale(2, RoundingMode.HALF_DOWN);
       		if(inputAmount.doubleValue()<0)
       		{
       			loadWarningScreen("The 'amount' field must contain a positive value. \nTry again.");
       		}
       		if(amountDescription.isEmpty())
       		{
       			loadWarningScreen("Expense description cannot be empty. Try again.");
       		}
       		if((amountDescription.isEmpty()==false) & (inputAmount.doubleValue()>=0))
       		{
       	       	expensesTableView.getItems().add(new PlannedExpenses(amountDescription, inputAmount, 
       	       									 plannedExpenses.getChosenMonth(), plannedExpenses.getChosenYear()));
       	       	textFieldExpensesDescription.clear();
       	       	textFieldAmount.clear();
       		}
    	}
       	catch(NumberFormatException e)
       	{
       		loadWarningScreen("The 'amount' field must contain a numeric value. \nTry again.");
       	}  	
    }
    
    @FXML
    private void onClickRemoveExpenseButton(ActionEvent event) 
    {
    	PlannedExpenses selectedItem = expensesTableView.getSelectionModel().getSelectedItem();
    	expensesTableView.getItems().remove(selectedItem);
    }

    @FXML
    private void onClickSaveExpenseButton(ActionEvent event)
    {
       	for(int i=budgetList.size()-1; i>=0; i--)
    	{
    		if((budgetList.get(i) instanceof PlannedExpenses) 
    				&& (budgetList.get(i).getChosenMonth() == plannedExpenses.getChosenMonth())
    				&& (budgetList.get(i).getChosenYear() == plannedExpenses.getChosenYear()))
    		{
    			budgetList.remove(i);
    		}
    	}

    	for(int i=0; i<expensesTableView.getItems().size(); i++)
    	{
    		budgetList.add(expensesTableView.getItems().get(i));
    	}
    }
}





