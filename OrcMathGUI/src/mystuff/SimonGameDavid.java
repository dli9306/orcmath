package mystuff;

import guiPlayer.CatalogMakerGUI;
import guiPlayer.CatalogScreen;
import guiPlayer.CustomGUI;
import guiTeacher.GUIApplication;

public class SimonGameDavid extends GUIApplication {

	public SimonGameDavid(int width, int height) {
		super(width, height);
		setVisible(true);
	}
	public static void main(String[] args) {
		SimonGameDavid simon = new SimonGameDavid(800, 550);
		Thread runner = new Thread(simon);
		runner.start();
	}

	@Override
	public void initScreen() {
		SimonScreenDavid screen = new SimonScreenDavid(getWidth(), getHeight());
		setScreen(screen);
		
	}

}
