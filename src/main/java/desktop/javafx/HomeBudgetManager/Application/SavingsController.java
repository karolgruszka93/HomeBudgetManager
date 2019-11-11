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

public class SavingsController extends BudgetController
{
	private Savings savings = new Savings();
	private ArrayList<Budget> budgetList = null;
	
    @FXML
    private Button addSavingButton;
    @FXML
    private Button removeSavingButton;
    @FXML
    private Button saveSavingButton;
    @FXML
    private TableView<Savings> savingsTableView;
    @FXML
    private TextField textFieldSavingsDescription;
    @FXML
    private TextField textFieldAmount;

//------GETTER'S------//
    
	public ArrayList<Budget> getBudgetList() 
	{
		return budgetList;
	}

//------GETTER'S------//
	
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
    	
    	savingsTableView.setDisable(true);
    	addSavingButton.setDisable(true);
    	removeSavingButton.setDisable(true);
    	saveSavingButton.setDisable(true);
    	textFieldSavingsDescription.setDisable(true);
    	textFieldAmount.setDisable(true);
    	
        TableColumn<Savings, String> savingDescriptionColumn = new TableColumn<>("SAVING");
        savingDescriptionColumn.setCellValueFactory(new PropertyValueFactory<>("amountDescription"));
        TableColumn<Savings, BigDecimal> amountColumn = new TableColumn<>("AMOUNT");
        amountColumn.setCellValueFactory(new PropertyValueFactory<>("amount"));
        savingsTableView.getColumns().add(savingDescriptionColumn);
        savingsTableView.getColumns().add(amountColumn);
	}
    
    @FXML
    void onClickAddSavingButton(ActionEvent event) 
    {
    	String amountDescription = textFieldSavingsDescription.getText();
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
       	       	savingsTableView.getItems().add(new Savings(amountDescription, inputAmount, 
       	       									 savings.getChosenMonth(), savings.getChosenYear()));
       	       	textFieldSavingsDescription.clear();
       	       	textFieldAmount.clear();
       		}
    	}
       	catch(NumberFormatException e)
       	{
       		loadWarningScreen("The 'amount' field must contain a numeric value. \nTry again.");
       	}  	
    }

    @FXML
    void onClickApplyYearButton(ActionEvent event)
    {
      	try 
    	{
        	String inputYear = textFieldYears.getText();
        	if ((Integer.parseInt(inputYear) > 0) & (Integer.parseInt(inputYear) < 10000) & (comboBoxMonths.getValue() != null))
        	{
        		savings.setChosenDate(parseMonth(comboBoxMonths.getValue()), Integer.parseInt(inputYear));
        		selectedDateLabel.setVisible(true);
            	monthLabel.setText(comboBoxMonths.getValue());
            	yearLabel.setText(String.valueOf(savings.getChosenYear()));
            	applyYearButton.setMouseTransparent(true);
            	applyYearButton.setDisable(true);
            	textFieldYears.setMouseTransparent(true);
            	textFieldYears.setDisable(true);
            	comboBoxMonths.setMouseTransparent(true);
            	comboBoxMonths.setDisable(true);
            	currentDateLabel.setVisible(true);
            	nowDateLabel.setText(savings.getCurrentDate());
            	savingsTableView.setDisable(false);
            	addSavingButton.setDisable(false);
            	removeSavingButton.setDisable(false);
            	textFieldSavingsDescription.setDisable(false);
            	textFieldAmount.setDisable(false);
            	saveSavingButton.setDisable(false); 
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
    			if((budgetList.get(i) instanceof Savings) 
    					&& (budgetList.get(i).getChosenMonth() == savings.getChosenMonth())
    					&& (budgetList.get(i).getChosenYear() == savings.getChosenYear()))
    			{
    				savingsTableView.getItems().add(new Savings(budgetList.get(i).getAmountDescription(), 
    						budgetList.get(i).getAmount(), savings.getChosenMonth(), savings.getChosenYear()));
    			}
    		}
    	} 
    }
    
    @FXML
    void onClickRemoveSavingButton(ActionEvent event) 
    {
    	Savings selectedItem = savingsTableView.getSelectionModel().getSelectedItem();
    	savingsTableView.getItems().remove(selectedItem);
    }

    @FXML
    void onClickSaveSavingsButton(ActionEvent event) 
    {
    	for(int i=budgetList.size()-1; i>=0; i--)
    	{
    		if((budgetList.get(i) instanceof Savings) 
    				&& (budgetList.get(i).getChosenMonth() == savings.getChosenMonth())
    				&& (budgetList.get(i).getChosenYear() == savings.getChosenYear()))
    		{
    			budgetList.remove(i);
    		}
    	}

    	for(int i=0; i<savingsTableView.getItems().size(); i++)
    	{
    		budgetList.add(savingsTableView.getItems().get(i));
    	}
    }
}
