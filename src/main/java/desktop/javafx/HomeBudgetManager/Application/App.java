package desktop.javafx.HomeBudgetManager.Application;

import java.io.IOException;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class App extends Application
{
	public static void main(String[] args)
	{
		Application.launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) 
	{
		
		FXMLLoader loader = new FXMLLoader();	
		loader.setLocation(this.getClass().getResource("/fxml/MainScreen.fxml"));
		
		try 
		{
			StackPane stackPane = loader.load();
			Scene scene = new Scene(stackPane);
			primaryStage.setScene(scene);
			primaryStage.show();	
			primaryStage.setResizable(false);
			primaryStage.setTitle("Home Budget Manager"); 
			primaryStage.getIcons().add(new Image("/image/icon.png"));
			primaryStage.setOnCloseRequest((new EventHandler<WindowEvent>(){
				@Override
				public void handle(WindowEvent event)
				{
					Platform.exit();
					System.exit(0);	
				};
			}));
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
}
