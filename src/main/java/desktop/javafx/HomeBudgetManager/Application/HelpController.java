package desktop.javafx.HomeBudgetManager.Application;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.TextArea;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;


public class HelpController implements Initializable 
{
	
    @FXML
    private TreeView<String> treeViev;
    @FXML
    private TextArea textArea;

	@SuppressWarnings("unchecked")
	@Override
	public void initialize(URL location, ResourceBundle resources)
	{
	    TreeItem<String> help  = new TreeItem<>("Help");
	    TreeItem<String> constantExpenses  = new TreeItem<>("Constant Expenses");
	    TreeItem<String> plannedExpenses  = new TreeItem<>("Planned Expenses");
	    TreeItem<String> savings  = new TreeItem<>("Savings");
	    TreeItem<String> summary  = new TreeItem<>("Summary");
	    
	    help.getChildren().addAll(constantExpenses, plannedExpenses, savings, summary);
	    treeViev.setRoot(help);
	}
	
    @FXML
    protected void onTreeItemClick(MouseEvent event) 
    {
	    EventHandler<MouseEvent> mouseClick = new EventHandler<MouseEvent>()
	    {
			@Override
			public void handle(MouseEvent event) 
			{
				Node node = event.getPickResult().getIntersectedNode();
				if(node instanceof Text)
				{
					Text treeItemName = (Text) node;
					String selectedTreeItem = treeItemName.getText();
					showText(selectedTreeItem);
				}
			}
	    };
	    
	    treeViev.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseClick);
    }
    
    protected void showText(String selectedTreeItem)
    {
		textArea.setStyle("-fx-text-fill: DarkGray");
    	if (selectedTreeItem.equals("Help"))
    	{
			textArea.setText("Click on 'Help' to expand menu.");
    	}
    	if (selectedTreeItem.equals("Constant Expenses"))
    	{
    		textArea.setText("In this window enter your monthly constant expenses, for example flat payments or fuel costs.");
    	}
    	if (selectedTreeItem.equals("Planned Expenses"))
    	{
			textArea.setText("In this window enter your planned expenses that are not constant, for example cost of buying a laptop.");
    	}
    	if (selectedTreeItem.equals("Savings"))
    	{
			textArea.setText("In this window enter amount of your savings.");
    	}
    	if (selectedTreeItem.equals("Summary"))
    	{
			textArea.setText("This window include charts summarizing expenses and savings.");
    	}
    }
}
