package JHexEditor.gui;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;


public class ShowBinaryWindow extends TableView<Entry>
{
	public ShowBinaryWindow(File file)
	{
		try 
		{
			InputStream fileInputStream = new FileInputStream(file);
			byte[] allBinaries = fileInputStream.readAllBytes();
			
			ObservableList<Entry> data = fillObservableList(allBinaries);
			
			TableColumn<Entry, Integer> numberColumn = new TableColumn<Entry, Integer>("Number");
			numberColumn.setResizable(false);
			
			TableColumn<Entry, Byte> byteColumn = new TableColumn<Entry, Byte>("Integer");
			byteColumn.setResizable(false);
			
			TableColumn<Entry, Character> charColumn = new TableColumn<Entry, Character>("Charackter");
			charColumn.setResizable(false);
			
			
			
			//TODO Weitere Spalte mit Binär-Werten
			
			//TODO Weitere Spalte mit Hexadezimal-Werten
			
			//TODO Manche Dateien haben unterschiedlich große Bit-Blöcke.
				//Darauf muss eingegangen werden
			
			
			numberColumn.setCellValueFactory(new PropertyValueFactory<Entry, Integer>("number"));
			byteColumn.setCellValueFactory(new PropertyValueFactory<Entry, Byte>("binary"));
			charColumn.setCellValueFactory(new PropertyValueFactory<Entry, Character>("charackter"));
			
			this.getColumns().addAll(numberColumn, byteColumn, charColumn);
			this.setItems(data);
			
			fileInputStream.close();
			
		} catch(FileNotFoundException e)
		{
			e.printStackTrace();
		} catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
	
	private ObservableList<Entry> fillObservableList(byte[] bin)
	{
		ArrayList<Entry> arr = new ArrayList<>();
		
		for (int i=0; i<bin.length; i++)
		{
			arr.add(new Entry(i, bin[i]));
		}
		
		
		return FXCollections.observableArrayList(arr);
	}
	
}
