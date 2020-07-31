package JHexEditor.gui;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;


public class ShowBinaryWindow extends GridPane
{
	public ShowBinaryWindow(File file)
	{
		
		try {
			InputStream fileInputStream = new FileInputStream(file);
			
			byte[] allBinaries = fileInputStream.readAllBytes();
			String output = "";
			
			//TODO Label ist keine gute Lösung! Funktioniert auch nicht für große dateien
			
			for (int i=0; i<allBinaries.length; i++)
			{
				output = i + ":   " + Byte.toString(allBinaries[i]) 
						+ ", 10er   |  " + (char) allBinaries[i]
						+ ", (char)   |  " + Integer.parseInt(Byte.toString(allBinaries[i]), 16)
						+ ", 16er";
				this.add(new Label(output), 0, i);
			}
			
			this.setPadding(new Insets(10, 10, 10, 10));
			fileInputStream.close();
			
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
