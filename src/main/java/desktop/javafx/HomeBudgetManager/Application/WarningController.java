package desktop.javafx.HomeBudgetManager.Application;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class WarningController 
{
	
    @FXML
    private Label warningLabel;

    public Label getWarningLabel() 
	{
		return warningLabel;
	}

    public void setWarningLabel(Label warningLabel) 
	{
		this.warningLabel = warningLabel;
	}

}
