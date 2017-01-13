package simonJason;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import guiCompononets.Action;
import guiCompononets.ClickableGraphic;
import guiCompononets.TextLabel;
import guiCompononets.Visible;
import guiScreens.ClickableScreen;


public class SimonScreenJasonLau extends ClickableScreen implements Runnable {
	
	public ProgressInterfaceJasonLau prog;
	public ArrayList<MoveInterfaceJasonLau> seq;
	public ButtonInterfaceJasonLau[] butts;
	public TextLabel text;

	public int round;
	public int seqIndex;
	public boolean inputAccepted;
	public int lastSelectedButton;
	

	public SimonScreenJasonLau(int width, int height) {
		super(width, height);
		Thread game = new Thread(this);
		game.start();
	}

	@Override
	public void run() {
		text.setText("");
		nextRound();
	}

	private void nextRound() {	
		inputAccepted = false;
		round++;
		seq.add(randomMove());
		prog.setSequenceSize(seq.size());
		prog.setRound(round);
		changeText("Simon's Turn");
		text.setText("");
		playSequence();
		changeText("Your Turn");
		text.setText("");
		inputAccepted = true;
		seqIndex = 0;
	}

	private void playSequence() {
		ButtonInterfaceJasonLau b = null;
		for(MoveInterfaceJasonLau move: seq){
			if(b != null){
				b.dim();
				b = move.getButton();
				b.highlight();
				int sleepTime = (int)((1000/round + 1) * 2);
				try {
					Thread.sleep(sleepTime);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		b.dim();
		
	}

	private void changeText(String string) {
		text.setText(string);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		addButtons();
		prog = getProgress();
		text = new TextLabel(130,230,300,40,"Let's play Simon!");
		seq = new ArrayList<MoveInterfaceJasonLau>();
		//add 2 moves to start
		lastSelectedButton = -1;
		seq.add(randomMove());
		seq.add(randomMove());
		round = 0;
		viewObjects.add(prog);
		viewObjects.add(text);

	}

	private MoveInterfaceJasonLau randomMove() {
		ButtonInterfaceJasonLau b;
		int rdmidx = (int)(Math.random() * seq.size());
		while(rdmidx == lastSelectedButton){
			rdmidx = (int)(Math.random() * seq.size());
		}
		b = butts[rdmidx];
		return getMove(b);
	}

	private void addButtons() {
		int buttonnum = 5;
		Color[] buttcolors = {Color.BLUE,Color.YELLOW,Color.RED,Color.GREEN,Color.PINK};
		int[] xcord = {85,50,120,50,120};
		int[] ycord = {35,75,75,110,110};
		for(int i = 0; i < buttonnum; i++){
			final ButtonInterfaceJasonLau b = getAButton();
			b.setColor(buttcolors[i]);
		    b.setX(xcord[i]);
		    b.setY(ycord[i]);
		    b.setAction(new Action() {
				
				
				public void act() {
					if(inputAccepted){
						Thread blink = new Thread(new Runnable(){

							public void run(){
								b.highlight();
								try {
									Thread.sleep(800);
									
								} catch (InterruptedException e) {
									e.printStackTrace();
								}
								b.dim();
							}

							});
						blink.start();
						if(b.equals(seq.get(seqIndex).getButton())){
							seqIndex++;
						}
						else{
							prog.gameOver();
						}
						
						if(seqIndex == seq.size()){
							Thread nextRound = new Thread(SimonScreenJasonLau.this);
							nextRound.start();
						}
					}
					
				}
			});
		    
		    addObject(b);
		}
	}

	

	private MoveInterfaceJasonLau getMove(ButtonInterfaceJasonLau b) {
		// TODO Auto-generated method stub
		return new Move(b);
	}

	@Override
	public void initObjects(ArrayList<Visible> viewObjects) {
		
	}
	
	public ButtonInterfaceJasonLau getAButton(){
		return new Button();
	}
	
	public ProgressInterfaceJasonLau getProgress(){
		return new Progress();
		
	}
	
	

}
