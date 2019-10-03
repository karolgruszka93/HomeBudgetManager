package desktop.javafx.HomeBudgetManager.Application;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class ConstantExpensesController 
{
	private ConstantExpenses constantExpenses;
	private MainController mainController;
	private Pane pane = null;
	private Label warningLabel = null;
	private ArrayList<Budget> budget;

	@FXML
    private Button backButton;
    @FXML
    private Button applyYearButton;
    @FXML
    private Button addExpenseButton;
    @FXML
    private ComboBox<String> comboBoxMonths;
    @FXML
    private Label selectedDateLabel;
    @FXML
    private Label monthLabel;
    @FXML
    private Label yearLabel;
    @FXML
    private Label currentDateLabel;
    @FXML
    private Label nowDateLabel;
    @FXML
    private TableView<?> expensesTableView;
    @FXML
    private TableColumn<?, ?> expensesTableColumn;
    @FXML
    private TableColumn<?, ?> amountTebleColumn;
    @FXML
    private TextField textFieldYears;
    @FXML
    private TextField textFieldExpenses;
    @FXML
    private TextField textFieldAmount;



//------GETTER'S------//
    
	protected MainController getMainController() 
	{
		return mainController;
	}

//------SETTER'S------//

	protected void setMainController(MainController mainController) 
	{
		this.mainController = mainController;
	}

//------METHODS'S------//
	
    @FXML
    private void onClickBackButton(ActionEvent event) 
    {
    	mainController.loadMenuScreen();
    }
    
    @FXML
    private void onClickApplyButton(ActionEvent event) 
    {
    	constantExpenses = new ConstantExpenses();
    	try 
    	{
        	String inputYear = textFieldYears.getText();
     
        	if ((Integer.parseInt(inputYear) > 0) & (Integer.parseInt(inputYear) < 10000) & (comboBoxMonths.getValue() != null))
        	{
        		constantExpenses.setChosenDate(parseMonth(comboBoxMonths.getValue()), Integer.parseInt(inputYear));
        		selectedDateLabel.setVisible(true);
            	monthLabel.setText(comboBoxMonths.getValue());
            	yearLabel.setText(String.valueOf(constantExpenses.getChosenYear()));
            	applyYearButton.setMouseTransparent(true);
            	applyYearButton.setDisable(true);
            	textFieldYears.setMouseTransparent(true);
            	textFieldYears.setDisable(true);
            	comboBoxMonths.setMouseTransparent(true);
            	comboBoxMonths.setDisable(true);
            	currentDateLabel.setVisible(true);
            	nowDateLabel.setText(constantExpenses.getCurrentDate());
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
    	expensesTableView.setDisable(false);
    }
    
    @FXML
    private void onClickAddExpenseButton(ActionEvent event) 
    {
    	budget = mainController.getBudget();
    	String inputDescrition = textFieldExpenses.getText();
       	try 
    	{
       		BigDecimal imputAmount = new BigDecimal(textFieldAmount.getText().replace(',', '.'));
    	}
       	catch(NumberFormatException e)
       	{
       		loadWarningScreen("The 'amount' field must contain a positive numeric value. \nTry again.");
       	}
    	// nie moge byc ujemnych i pustego opisu
    }
    
    @FXML
    private void initialize()
	{
    	comboBoxMonths.getItems().addAll("January", "February", "March", "April", "May", "June", "July", "August", 
    			"September", "October", "November", "December");
    	
    	expensesTableView.setDisable(true);
	}
    
    private void loadWarningScreen(String warningText)
    {
		FXMLLoader loader = new FXMLLoader();
    	loader.setLocation(this.getClass().getResource("/fxml/WarningScreen.fxml"));
    	try 
    	{
			pane = loader.load();
		} 
    	catch (IOException e) 
    	{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	Scene scene = new Scene(pane);
    	Stage stage = new Stage();
    	stage.setResizable(false);
    	stage.setAlwaysOnTop(true);
    	stage.initStyle(StageStyle.UTILITY);
    	stage.setTitle("Warning");
    	stage.setScene(scene);
    	stage.show();
    	
    	WarningController warningController = loader.getController();
    	warningLabel = warningController.getWarningLabel();
    	warningLabel.setText(warningText);
    }
    
    private int parseMonth(String month)
    {
		int inputMonth = 0;
   		if(comboBoxMonths.getValue().compareTo("January") == 0) inputMonth = 0;
		if(comboBoxMonths.getValue().compareTo("February") == 0) inputMonth = 1;
		if(comboBoxMonths.getValue().compareTo("March") == 0) inputMonth = 2;
		if(comboBoxMonths.getValue().compareTo("April") == 0) inputMonth = 3;
		if(comboBoxMonths.getValue().compareTo("May") == 0) inputMonth = 4;
		if(comboBoxMonths.getValue().compareTo("June") == 0) inputMonth = 5;
		if(comboBoxMonths.getValue().compareTo("July") == 0) inputMonth = 6;
		if(comboBoxMonths.getValue().compareTo("August") == 0) inputMonth = 7;
		if(comboBoxMonths.getValue().compareTo("September") == 0) inputMonth = 8;
		if(comboBoxMonths.getValue().compareTo("October") == 0) inputMonth = 9;
		if(comboBoxMonths.getValue().compareTo("November") == 0) inputMonth = 10;
		if(comboBoxMonths.getValue().compareTo("December") == 0) inputMonth = 11;
		return inputMonth;
    }
}
