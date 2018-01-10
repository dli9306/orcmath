package mystuff;

public class MoveFahad implements MoveInterfaceDavid {
	
	private ButtonInterfaceDavid b;

	public MoveFahad(ButtonInterfaceDavid button) {
		this.b = button;
	}

	@Override
	public ButtonInterfaceDavid getButton() {
		return b;
	}

	@Override
	public void getMove(int bIndex) {
		// TODO Auto-generated method stub

	}

}
