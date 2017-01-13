package simonJason;

public class Move implements MoveInterfaceJasonLau {

	private ButtonInterfaceDavidS b;
	
	public Move(ButtonInterfaceDavidS b) {
		// TODO Auto-generated constructor stub
		this.b = b;
	}

	@Override
	public ButtonInterfaceDavidS getButton() {
		// TODO Auto-generated method stub
		return b;
	}
}
