package desktop.javafx.HomeBudgetManager.Application;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class WarningController 
{

    @FXML
    private Label warningLabel;

    protected Label getWarningLabel() 
	{
		return warningLabel;
	}

    protected void setWarningLabel(Label warningLabel) 
	{
		this.warningLabel = warningLabel;
	}

}
