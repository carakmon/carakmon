package monopoly;

public class Main {
	public static void main(String[] args) {

		Board board = new Board();

		GameUI ui = new GameUI(board);

		ui.setPlayer(); // ������ vs set�޼ҵ�

		ui.init();

	}
}
