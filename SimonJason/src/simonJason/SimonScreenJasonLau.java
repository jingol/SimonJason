package simonJason;

import java.util.ArrayList;
import java.util.List;

import guiCompononets.ClickableGraphic;
import guiCompononets.TextLabel;
import guiCompononets.Visible;
import guiScreens.ClickableScreen;

public class SimonScreenJasonLau extends ClickableScreen implements Runnable {
	
	public ProgressInterfaceJasonLau prog;
	public ArrayList<MoveInterfaceJasonLau> seq;
	public int round;
	public int seqIndex;
	public boolean inputAccepted;
	public TextLabel text;
	public int lastSelectedButton;
	public ButtonInterfaceJasonLau[] butts;


	public SimonScreenJasonLau(int width, int height) {
		super(width, height);
		
	}

	@Override
	public void run() {
		
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		Thread sequence = new Thread(this);
		text = new TextLabel(50,20,40,40,"It's Simooooon");
		

	}

	@Override
	public void initObjects(ArrayList<Visible> viewObjects) {
		// TODO Auto-generated method stub

	}
	
	public ButtonInterfaceJasonLau getAButton(){
		return null;
	}
	
	public ProgressInterfaceJasonLau getProgress(){
		return null;
		
	}
	
	

}
