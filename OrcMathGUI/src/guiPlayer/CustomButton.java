package guiPlayer;

import java.awt.Color;
import java.awt.Graphics2D;

import javax.swing.Box.Filler;

import guiTeacher.components.Action;
import guiTeacher.components.Button;

public class CustomButton extends Button {
	
	private String str1;
	private String str2;
	private Color color;

	public CustomButton(int x, int y) {
		super(x, y, 40, 70, "", null);
		// TODO Auto-generated constructor stub
	}
	public void drawButton(Graphics2D g, boolean hover) {
		g.setColor(Color.green);
		g.drawString(str1, 30, 30);
		g.drawString(str2, 30, 60);
	    g.fillRect(50, 50, 100, 100);
	}
	void updateString1(String string) {
		
	}

	void updateString2(String string) {
		
	}

	void setIconColor(Color color) {
		
	}

}
