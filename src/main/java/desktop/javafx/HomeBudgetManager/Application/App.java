package desktop.javafx.HomeBudgetManager.Application;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class App extends Application
{
	public static void main(String[] args)
	{
		Application.launch(args);	//uruchomienie aplikacji
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception 
	{
		FXMLLoader loader = new FXMLLoader();	
		loader.setLocation(this.getClass().getResource("/fxml/MainScreen.fxml"));
		StackPane stackPane = loader.load();
		
		Scene scene = new Scene(stackPane);	  // dodanie stackPane do sceny 
		
		primaryStage.setScene(scene);	// dodanie sceny do stage
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
}
