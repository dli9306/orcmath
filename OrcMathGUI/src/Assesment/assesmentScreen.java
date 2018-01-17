package Assesment;

import java.util.List;

import guiTeacher.components.Action;
import guiTeacher.components.Button;
import guiTeacher.components.TextLabel;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.ClickableScreen;

public class assesmentScreen extends ClickableScreen {
	
	private TextLabel label;
	private boolean set = false;

	public assesmentScreen(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		label = new TextLabel(130,100,300,40,"");
		viewObjects.add(label);
		Button win = new Button(130,200,100,100,"WIN", new Action() {
			
			@Override
			public void act() {
				if(!set) {
					set = true;
					changeText("You Win");
				}
				
			}
		});
		viewObjects.add(win);
		Button lose = new Button(130,300,100,100,"LOSE", new Action() {
			
			@Override
			public void act() {
				if(!set) {
					set = true;
					changeText("You Lose");
				
				}
				
			}
		});
		viewObjects.add(lose);
	}
	public void changeText(String x) {
		label.setText(x);
		
		
		
	}

}
