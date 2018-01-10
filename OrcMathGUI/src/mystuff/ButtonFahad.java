package mystuff;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;

import guiTeacher.components.Action;
import guiTeacher.components.Button;

public class ButtonFahad extends Button implements ButtonInterfaceDavid {
	
	private static boolean buttonOn;
	private Color color;
	
	public static void main(String[] args) {
		buttonOn = true;
	}

	public ButtonFahad(int x, int y, int w, int h, String text,Action action) {
		super(x, y, w, h, "", null);
		
	}
	 
	public void drawButton(Graphics2D g, boolean hover){
		Ellipse2D ellipse = new Ellipse2D.Double(0, 0, getWidth(), getHeight());
		g.setColor(color);
		g.draw(ellipse);
		g.fill(ellipse);
	}
	public void update() {
		BufferedImage hoverImage = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_ARGB);
		Graphics2D hoverG = hoverImage.createGraphics();
		applyStyles(hoverG);
		drawButton(hoverG, true);
		super.update();
	}
	@Override
	public void highlight() {
		setColor(Color.cyan);
		update();
	}
	@Override
	public void dim() {
		setColor(color);
		update();
	}
	@Override
	public void setColor(Color color) {
		this.color = color;
		update();
		
	}
	@Override
	public void getAButton() {
		// TODO Auto-generated method stub
		
	}

	


}
