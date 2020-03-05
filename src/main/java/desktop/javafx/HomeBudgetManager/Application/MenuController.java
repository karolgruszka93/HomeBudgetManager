package desktop.javafx.HomeBudgetManager.Application;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Scanner;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class MenuController extends BudgetController
{
	private ArrayList<Budget> budgetList;
	
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
	
	public void setBudgetList(ArrayList<Budget> budgetList)
	{
		this.budgetList = budgetList;
	}

//------GETTER'S------//
	
	public ArrayList<Budget> getBudgetList() 
	{
		return budgetList;
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
			showAlert();
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
			showAlert();
		}
    	
		mainController.setScreen(pane); 
		ConstantExpensesController constantExpensesController = loader.getController();
		constantExpensesController.setMainController(mainController);
		constantExpensesController.setBudgetList(budgetList);
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
			showAlert();
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
		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("Open .hbm file");
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("HBM", "*.hbm"));
		File file = fileChooser.showOpenDialog(null);
        if (file != null) 
        {
			openFile(file);
        }
	}
	
	protected void openFile(File file)
	{
		String[] lineInFile = new String[5];
		try 
		{
			Scanner readFile = new Scanner(file);
			while(readFile.hasNextLine())
			{
				String line = readFile.nextLine();
				lineInFile = line.split(", ");
				if(lineInFile[0].equals("ce"))
				{
					ConstantExpenses ce = new ConstantExpenses();
					ce.setChosenDate(Integer.parseInt(lineInFile[3]), Integer.parseInt(lineInFile[4]));
					ce.setAmountDescription(lineInFile[1]);
					ce.setAmount(BigDecimal.valueOf(Double.parseDouble(lineInFile[2])));
					budgetList.add(ce);
				}
				if(lineInFile[0].equals("sv"))
				{
					Savings sv = new Savings();
					sv.setChosenDate(Integer.parseInt(lineInFile[3]), Integer.parseInt(lineInFile[4]));
					sv.setAmountDescription(lineInFile[1]);
					sv.setAmount(BigDecimal.valueOf(Double.parseDouble(lineInFile[2])));
					budgetList.add(sv);				}
				if(lineInFile[0].equals("pe"))
				{
					PlannedExpenses pe = new PlannedExpenses();
					pe.setChosenDate(Integer.parseInt(lineInFile[3]), Integer.parseInt(lineInFile[4]));
					pe.setAmountDescription(lineInFile[1]);
					pe.setAmount(BigDecimal.valueOf(Double.parseDouble(lineInFile[2])));
					budgetList.add(pe);
				}
			}
			readFile.close();
		} 
		catch (IOException e) 
		{
			loadWarningScreen("An error occurred while trying to open the file. \\nTry again.");
		}
		catch (NumberFormatException nf)
		{
			loadWarningScreen("The input file contains an error. \nTry again.");
		}
	}

	@FXML
	private void onClickSaveButton(ActionEvent event)
	{
		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("Save .hbm file");
		fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("HBM", "*.hbm"));
		File file = fileChooser.showSaveDialog(null);
        if (file != null) 
        {
			saveFile(file);
        }
	}
	
	private void saveFile(File file)
	{
		FileOutputStream fileOutputStream = null;
		try 
		{
			fileOutputStream = new FileOutputStream(file);
		} 
		catch (FileNotFoundException e) 
		{
			loadWarningScreen("File does not exist. \nTry again.");
		}
		
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(fileOutputStream));		 
		for (int i=0; i<budgetList.size(); i++) 
		{
			Budget budgetItem = budgetList.get(i);
			try 
			{
				if(budgetItem instanceof ConstantExpenses) 
				{
					writer.write("ce, " + budgetItem.getAmountDescription() +", "+ budgetItem.getAmount() 
					+", "+ budgetItem.getChosenMonth() +", "+ budgetItem.getChosenYear());
				}
				if(budgetItem instanceof Savings) 
				{
					writer.write("sv, " + budgetItem.getAmountDescription() +", "+ budgetItem.getAmount() 
					+", "+ budgetItem.getChosenMonth() +", "+ budgetItem.getChosenYear());
				}
				if(budgetItem instanceof PlannedExpenses) 
				{
					writer.write("pe, " + budgetItem.getAmountDescription() +", "+ budgetItem.getAmount() 
					+", "+ budgetItem.getChosenMonth() +", "+ budgetItem.getChosenYear());
				}
				writer.newLine();
			} 
			catch (IOException e) 
			{
				loadWarningScreen("An error occurred while trying to save the file. \nTry again.");
			}
		}
		try 
		{
			writer.close();
		} 
		catch (IOException e) 
		{
			loadWarningScreen("An error occurred while trying to save the file. \\nTry again.");
		}
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
			showAlert();
		}
    	
		mainController.setScreen(pane); 
		PlannedExpensesController plannedExpensesController = loader.getController();
		plannedExpensesController.setMainController(mainController);
		plannedExpensesController.setBudgetList(budgetList);
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
			showAlert();
		}
		
		mainController.setScreen(pane); 
		SavingsController savingsController = loader.getController();
		savingsController.setMainController(mainController);
		savingsController.setBudgetList(budgetList);;
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
			showAlert();
		}

    	mainController.setScreen(pane); 
    	SummaryController summaryController = loader.getController();
    	summaryController.setMainController(mainController);
    	summaryController.setBudgetList(budgetList);
	}
	
	private void showAlert()
	{
		Alert alert = new Alert(AlertType.ERROR, "An error occurred while app running. Try again");
		alert.setTitle("Error");
		alert.showAndWait();
		Platform.exit();
		System.exit(0);
	}
	
}

