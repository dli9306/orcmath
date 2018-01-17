package Assesment;

import guiTeacher.GUIApplication;
import mystuff.SimonGameDavid;

public class assesment80 extends GUIApplication {

	public assesment80(int width, int height) {
		super(width, height);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		assesment80 a = new assesment80(800, 550);
		Thread runner = new Thread(a);
		runner.start();
	}

	@Override
	public void initScreen() {
		assesmentScreen screen = new assesmentScreen(getWidth(),getHeight());
		setScreen(screen);
		
	}

}
