package mystuff;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import guiTeacher.components.TextLabel;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.ClickableScreen;

public class SimonScreenDavid  extends ClickableScreen implements Runnable {
	private TextLabel label;
	private ProgressInterfaceDavid p;
	private ArrayList<MoveInterfaceDavid> sequence;
	private ButtonInterfaceDavid[] button;
	private int r; //round
	private boolean acceptInput;
	int sequenceIndex;
	int lastSelectedButton;
	

	public SimonScreenDavid(int width, int height) {
		super(width, height);
		Thread app = new Thread(this);
		app.start();
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		addButtons();
		for(ButtonInterfaceDavid b: button){ 
		    viewObjects.add(b); 
		}
		p = getProgress();
		label = new TextLabel(130,230,300,40,"Let's play Simon!");
		sequence = new ArrayList<MoveInterfaceDavid>();
		lastSelectedButton = -1;
		sequence.add(randomMove());
		sequence.add(randomMove());
		r = 0;
		viewObjects.add(p);
		viewObjects.add(label);
		
	}

	private MoveInterfaceDavid randomMove() {
		int index = (int)(Math.random()*button.length);
		while(index == lastSelectedButton) {
			index= (int)(Math.random()*button.length);
		}
		return getMove(index);
	}
	private MoveInterfaceDavid getMove(int i) {
	    return null;
	}

	private ProgressInterfaceDavid getProgress() {
		// TODO Auto-generated method stub
		return null;
	}

	private void addButtons() {
		int numButtons = 6;
		Color[] color = {Color.blue,Color.green,Color.red,Color.yellow,Color.orange,Color.pink};
		ArrayList<MoveInterfaceDavid> list=new ArrayList<MoveInterfaceDavid>(numButtons);
		for(int i=0;i<numButtons;i++) {
			ButtonInterfaceDavid x = getAButton();
			button[i] = x;
		}
		
	}

}
