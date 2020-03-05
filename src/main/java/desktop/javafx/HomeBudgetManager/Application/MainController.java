package desktop.javafx.HomeBudgetManager.Application;

import java.io.IOException;
import java.util.ArrayList;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

public class MainController 
{
	private ArrayList<Budget> budgetList = new ArrayList<>();

	@FXML 
	private StackPane mainScreen;
	private Pane pane = null;
	
//------SETTER'S------//
	
	public void setBudgetList(ArrayList<Budget> budgetList) 
	{
		this.budgetList = budgetList;
	}
	
//------GETTER'S------//
	
	public ArrayList<Budget> getBudgetList() 
	{
		return budgetList;
	}
	
//-----METHOD'S------// 
	
	@FXML
	protected void initialize() 
	{
		loadMenuScreen(); 
	}

	protected void loadMenuScreen() 
	{
		try 
		{
			FXMLLoader loader = new FXMLLoader();	
			loader.setLocation(this.getClass().getResource("/fxml/MenuScreen.fxml"));
			pane = loader.load();
			setScreen(pane);
			MenuController menuController = loader.getController();
			menuController.setMainController(this);
			menuController.setBudgetList(budgetList);
		} 
		catch (IOException e) 
		{
			Alert alert = new Alert(AlertType.ERROR, "An error occurred while app running. Try again");
			alert.setTitle("Error");
			alert.showAndWait();
			Platform.exit();
			System.exit(0);	
		}
	}
	
	protected void setScreen(Pane pane)
	{
		mainScreen.getChildren().clear();
		mainScreen.getChildren().add(pane);
	}
}
