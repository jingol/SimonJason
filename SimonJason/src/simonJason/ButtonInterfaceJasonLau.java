package simonJason;

import java.awt.Color;

import guiCompononets.Action;
import guiCompononets.Clickable;

public interface ButtonInterfaceJasonLau extends Clickable {

	public void setAction(Action a);

	public void highlight();

	public void dim();

	public void setColor(Color color);

	public void setX(int x);

	public void setY(int y);
	
}
