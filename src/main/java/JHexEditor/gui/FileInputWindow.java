package JHexEditor.gui;

import java.io.File;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class FileInputWindow extends GridPane
{
	private File file;
	
	public FileInputWindow()
	{
		FileChooser chooser = new FileChooser();
		Button openButton = new Button("Öffne Datei");
		
		openButton.setOnAction(action -> {
			
			file = chooser.showOpenDialog(new Stage());
			System.out.println(file.getAbsolutePath());
			
		});
		
		this.setPadding(new Insets(10, 10, 10, 10));
		this.add(openButton, 0, 0);
		this.setAlignment(Pos.CENTER);
	}
	
	public File getFile()
	{
		return file;
	}
}
