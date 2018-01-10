package mystuff;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import guiTeacher.components.Action;
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
		 label.setText("");
		    nextRound();
		
	}

	private void nextRound() {
		acceptInput = false;
		r++;
		MoveInterfaceDavid x = randomMove();
		sequence.add(x);
		p.setRound(r);
		p.setSequenceSize(sequence.size());
		changeText("Simon's turn");
		playSequence();
		changeText("Your turn");
		acceptInput = true;
		sequenceIndex = 0;
		
	}
	/*
	private void setSequenceSize(int size) {
		// TODO Auto-generated method stub
		
	}

	private void setRound(int r2) {
		// TODO Auto-generated method stub
		
	}
	*/

	private void playSequence() {
		 ButtonInterfaceDavid b=null;
		 int sleepTime = (int) (1000/(r*10));
		 for(int i=0;i<sequence.size();i++){ 
			     if(b!=null) {
			    	 b.dim();
			     }
			    b = sequence.get(i).getButton();
			    b.highlight();
			    try {
					Thread.sleep(sleepTime);
					} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					}
			}
		 b.dim();
		
	}

	private ButtonInterfaceDavid getButton() {
		// TODO Auto-generated method stub
		return null;
	}

	public void changeText(String x) {
		label.setText(x);
		try {
			Thread.sleep(1000);
			} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
		label.setText("");
		
		
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

    
	private MoveInterfaceDavid getMove(int index) {
		 return new MoveFahad(button[index]);
	}

	private ProgressInterfaceDavid getProgress() {
	   return new ProgressFahad(200, 200, 100, 100);
	}

	private void addButtons() {
		int numButtons = 6;
		Color[] color = {Color.blue,Color.green,Color.red,Color.yellow,Color.orange,Color.pink};
		button =new ButtonInterfaceDavid[numButtons];
		for(int i=0;i<numButtons;i++) {
			final ButtonInterfaceDavid b = getAButton();
			button[i] = b;
			b.setColor(color[i]); 
			b.setX(100);
			b.setY(30+(i*50));
			b.setAction(new Action(){

				public void act(){
					if(acceptInput) {
						Thread blink = new Thread(new Runnable(){

							public void run(){
								b.highlight();
								try {
								Thread.sleep(800);
								} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
								}
								b.dim();
							}
							  
							});
						blink.start();
					}
				 if(b==sequence.get(sequenceIndex).getButton()) {
					 sequenceIndex++;
				 }
				 else {
					 p.gameOver();
				 }
				 if(sequenceIndex == sequence.size()){ 
					    Thread nextRound = new Thread(SimonScreenDavid.this); 
					    nextRound.start(); 
					}

					
				}

				});
			button[i] = b;
		}
	
		
	}

	private ButtonInterfaceDavid getAButton() {
		return new ButtonFahad(0, 0, 40, 40, "", null);
	}

}
