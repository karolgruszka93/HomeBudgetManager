package desktop.javafx.HomeBudgetManager.Application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class SavingsController 
{
	private MainController mainController;
	
	@FXML
    private Button backButton;
	
	protected MainController getMainController()
    {
		return mainController;
	}

	protected void setMainController(MainController mainController) 
	{
		this.mainController = mainController;
	}

    @FXML
    private void onClickBackButton(ActionEvent event) 
    {
    	mainController.loadMenuScreen();
    }

}
