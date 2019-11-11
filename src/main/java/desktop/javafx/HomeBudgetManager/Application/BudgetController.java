package desktop.javafx.HomeBudgetManager.Application;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public abstract class BudgetController 
{
	protected MainController mainController = null;
	protected Pane pane = null;
	protected Label warningLabel = null;
	
	@FXML
	protected Button backButton;
    @FXML
    protected Button applyYearButton;
    @FXML
    protected ComboBox<String> comboBoxMonths;
    @FXML
    protected Label selectedDateLabel;
    @FXML
    protected Label monthLabel;
    @FXML
    protected Label yearLabel;
    @FXML
    protected Label currentDateLabel;
    @FXML
    protected Label nowDateLabel;
    @FXML
    protected TextField textFieldYears;
    @FXML

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
    protected void onClickBackButton(ActionEvent event) 
    {
    	mainController.loadMenuScreen();
    }
    
    protected void loadWarningScreen(String warningText)
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
    
    protected int parseMonth(String month)
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
