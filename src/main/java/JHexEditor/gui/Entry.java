package JHexEditor.gui;

public class Entry 
{
	private int number;
	private byte binary;
	private char charackter;
	
	public Entry(int n, byte b)
	{
		this.number = n;
		this.binary = b;
		
		this.charackter = (char) b;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public byte getBinary() {
		return binary;
	}

	public void setBinary(byte binary) {
		this.binary = binary;
	}

	public char getCharackter() {
		return charackter;
	}

	public void setCharackter(char charackter) {
		this.charackter = charackter;
	}
	
	
	
}
