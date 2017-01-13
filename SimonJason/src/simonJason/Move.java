package simonJason;

public class Move implements MoveInterfaceJasonLau {

	private ButtonInterfaceJasonLau b;
	
	public Move(ButtonInterfaceJasonLau b) {
		// TODO Auto-generated constructor stub
		this.b = b;
	}

	@Override
	public ButtonInterfaceJasonLau getButton() {
		// TODO Auto-generated method stub
		return b;
	}
}
