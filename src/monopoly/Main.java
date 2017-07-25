package monopoly;

public class Main {
	public static void main(String[] args) {

		Board board = new Board();

		GameUI ui = new GameUI(board);

		ui.setPlayer(); // 持失切 vs set五社球

		ui.init();

	}
}
