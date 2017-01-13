package simonJason;

import java.awt.Graphics2D;

import guiCompononets.Visible;

public interface ProgressInterfaceJasonLau extends Visible {

	void gameOver();

	void setSequenceSize(int size);

	void setRound(int round);
	
	void update(Graphics2D g);

}
