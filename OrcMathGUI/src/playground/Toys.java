package playground;

import java.awt.Color;
import java.awt.Graphics2D;

import guiTeacher.components.AnimatedComponent;
import guiTeacher.components.Component;

public class Toys extends AnimatedComponent {

	public Toys() {
		super(50,50,34,41);
		addSequence("resources/megaman.png", 150, 0, 2, 34, 41, 4);
		Thread animation = new Thread(this);
		animation.start();
		update();
		
	}

	@Override
	public void update(Graphics2D g) {
		//g.setColor(Color.green);
		//g.fillRect(0, 0, getWidth(), getHeight());
		super.update(g);
	

	}

}
