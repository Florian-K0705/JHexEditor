package JHexEditor.common;

import JHexEditor.gui.FileInputWindow;
import javafx.application.Application;

import javafx.scene.Scene;
import javafx.stage.Stage;

public class Launcher extends Application
{

	public static void main(String[] args) 
	{
		launch(args);

	}

	@Override
	public void start(Stage primaryStage) throws Exception 
	{	
		FileInputWindow window = new FileInputWindow();
		primaryStage.setScene(new Scene(window, 400, 100));
		primaryStage.setTitle("JHexEditor");
		primaryStage.show();
	}

}
