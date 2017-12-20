package playground;

import java.awt.Graphics2D;

import guiTeacher.components.Component;

public class Catalog  {
	
	private String name;
	private String author;
	private int page;

	public Catalog(String name,String author, int page) {
		this.name = name;
		this.author = author;
		this.page = page;
		
	}



	public String toString() {
		return name + ", "+ author + ", " + page;
	}
	

}