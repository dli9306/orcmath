package mystuff;

import java.awt.Color;
import java.awt.Graphics2D;

import guiTeacher.components.Action;
import guiTeacher.components.Button;

public class ButtonFahad extends Button implements ButtonInterfaceDavid {
	
	private static boolean buttonOn;
	
	public static void main(String[] args) {
		buttonOn = true;
	}

	public ButtonFahad(int x, int y, int w, int h, String text, Action action) {
		super(x, y, w, h, "", null);
		// TODO Auto-generated constructor stub
	}
	 
	public void drawButton(Graphics2D g, boolean hover) {
		if(buttonOn) {
		
		}
		else {
			 g.drawRect(getX(), getY(), getWidth(), getHeight());
		}
	}
	
	@Override
	public void setColor(Color color) {
		// TODO Auto-generated method stub

	}

	@Override
	public void highlight() {
		// TODO Auto-generated method stub

	}

	@Override
	public void dim() {
		// TODO Auto-generated method stub

	}

	@Override
	public void getAButton() {
		// TODO Auto-generated method stub

	}

}
