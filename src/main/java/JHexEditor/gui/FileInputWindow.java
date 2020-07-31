package JHexEditor.gui;

import java.io.File;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class FileInputWindow extends GridPane
{
	private File file;
	
	public FileInputWindow()
	{
		
		//TODO Die geöffnete Datei darf nur eine Datei sein, kein Ordner, muss überprüft werden
		
		FileChooser chooser = new FileChooser();
		Button openButton = new Button("Öffne Datei");
		Button calculateButton = new Button("Zeige"); //TODO Darf nur valide sein, wenn file != null
		
		
		openButton.setOnAction(action -> {
			file = chooser.showOpenDialog(new Stage());
		});
		
		
		calculateButton.setOnAction(action -> {
			Stage stage = new Stage();
			
			ShowBinaryWindow showWindow = new ShowBinaryWindow(file);
			stage.setScene(new Scene(showWindow));
			stage.show();
		});
		
		this.setPadding(new Insets(10, 10, 10, 10));
		this.add(openButton, 0, 0);
		this.add(calculateButton, 0, 1);
		this.setAlignment(Pos.CENTER);
	}
	
	public File getFile()
	{
		return file;
	}
}
