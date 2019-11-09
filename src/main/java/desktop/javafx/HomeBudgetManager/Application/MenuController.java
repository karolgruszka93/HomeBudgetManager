package desktop.javafx.HomeBudgetManager.Application;

import java.io.IOException;
import java.util.ArrayList;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class MenuController 
{
	private ArrayList<Budget> constantExpensesList;
	private MainController mainController;
	private Pane pane = null;
	
	@FXML
	private Button exitButton;
	@FXML
	private Button constantExpensesButton;
	@FXML
	private Button plannedExpensesButton;
	@FXML
	private Button savingsButton;
	@FXML
	private Button summaryButton;
	@FXML
	private Button saveButton;
	@FXML
	private Button loadButon;
	@FXML
	private Button helpButton;
	@FXML
	private Button aboutButton;
	
//------SETTER'S------//
	
	protected void setMainController(MainController mainController) 
	{
		this.mainController = mainController;
	}
	
	public void setConstantExpensesList(ArrayList<Budget> constantExpensesList)
	{
		this.constantExpensesList = constantExpensesList;
	}

//------GETTER'S------//
	
	protected MainController getMainController() 
	{
		return mainController;
	}
	
	public ArrayList<Budget> getConstantExpensesList() 
	{
		return constantExpensesList;
	}
	
//------METHOD'S------//
	
	@FXML
	private void onClickExitButton()
	{
		Platform.exit();
		System.exit(0);
	}
	
	@FXML
	private void onClickAboutButton(ActionEvent event) 
	{
		FXMLLoader loader = new FXMLLoader();
    	loader.setLocation(this.getClass().getResource("/fxml/AboutScreen.fxml"));
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
    	stage.initStyle(StageStyle.UTILITY);
    	stage.setAlwaysOnTop(true);
    	stage.setTitle("About Screen");
    	stage.setScene(scene);
    	stage.show();
    	
	}

	@FXML
	private void onClickConstantExpensesButton(ActionEvent event) 
	{
		FXMLLoader loader = new FXMLLoader();
    	loader.setLocation(this.getClass().getResource("/fxml/ConstantExpensesScreen.fxml"));
    	try 
    	{
			pane = loader.load();
		} 
    	catch (IOException e) 
    	{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
		mainController.setScreen(pane); 
		ConstantExpensesController constantExpensesController = loader.getController();
		constantExpensesController.setMainController(mainController);
		constantExpensesController.setConstantExpensesList(constantExpensesList);
	}

	@FXML
	private void onClickHelpButton(ActionEvent event) 
	{
		FXMLLoader loader = new FXMLLoader();
    	loader.setLocation(this.getClass().getResource("/fxml/HelpScreen.fxml"));
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
    	stage.initStyle(StageStyle.UTILITY);
    	stage.setTitle("Help Screen");
    	stage.setScene(scene);
    	stage.show();
	}

	@FXML
	private void onClickLoadButton(ActionEvent event) 
	{

	}

	@FXML
	private void onClickPlannedExpensesButton(ActionEvent event) 
	{
		FXMLLoader loader = new FXMLLoader();
    	loader.setLocation(this.getClass().getResource("/fxml/PlannedExpensesScreen.fxml"));
    	try 
    	{
			pane = loader.load();
		} 
    	catch (IOException e) 
    	{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
		mainController.setScreen(pane); 
		PlannedExpensesController plannedExpensesController = loader.getController();
		plannedExpensesController.setMainController(mainController);
	}

	@FXML
	private void onClickSaveButton(ActionEvent event) 
	{

	}

	@FXML
	private void onClickSavingsButton(ActionEvent event) 
	{
		FXMLLoader loader = new FXMLLoader();
    	loader.setLocation(this.getClass().getResource("/fxml/SavingsScreen.fxml"));
    	try 
    	{
			pane = loader.load();
		} 
    	catch (IOException e) 
    	{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
		mainController.setScreen(pane); 
		SavingsController savingsController = loader.getController();
		savingsController.setMainController(mainController);
	}

	@FXML
	private void onClickSummaryButton(ActionEvent event) 
	{
		FXMLLoader loader = new FXMLLoader();
    	loader.setLocation(this.getClass().getResource("/fxml/SummaryScreen.fxml"));
    	try 
    	{
			pane = loader.load();
		} 
    	catch (IOException e) 
    	{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	mainController.setScreen(pane); 
    	SummaryController summaryController = loader.getController();
    	summaryController.setMainController(mainController);
	}
	
	@FXML
	private void initialize()
	{

	}
}

