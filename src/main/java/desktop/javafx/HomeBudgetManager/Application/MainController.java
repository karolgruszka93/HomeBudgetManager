package desktop.javafx.HomeBudgetManager.Application;

import java.io.IOException;
import java.util.ArrayList;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

public class MainController 
{
	private ArrayList<Budget> budget = new ArrayList<>(); 
	@FXML 
	private StackPane mainScreen;
	private Pane pane = null;
	
//------SETTER'S------//
	
    
//------GETTER'S------//
	

//-----METHOD'S------// 
	
	@FXML
	protected void initialize()
	{
		loadMenuScreen(); 
	}

	protected void loadMenuScreen() {
		FXMLLoader loader = new FXMLLoader();	
		loader.setLocation(this.getClass().getResource("/fxml/MenuScreen.fxml"));
		try 
		{
			pane = loader.load();
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		setScreen(pane);
		MenuController menuController = loader.getController();
		menuController.setMainController(this);
	}
	
	protected void setScreen(Pane pane)
	{
		mainScreen.getChildren().clear();
		mainScreen.getChildren().add(pane);
	}
}
