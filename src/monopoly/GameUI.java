package monopoly;

import java.util.Scanner;

public class GameUI {
	Board board;
	Scanner sc;
	int playerTurn; // �÷��̾� ��(�� �÷��̾� ��)

	public GameUI(Board board) {
		this.board = board;
		sc = new Scanner(System.in); 
		
	}
	public void setPlayer() {
		System.out.print("�÷��̾� ���� �Է��ϼ���: ");
		int playerNum = Integer.parseInt(sc.nextLine());
		playerTurn = playerNum;
		board.setPlayer(playerNum);
	}
	
	public void init() {
		System.out.println("Welcome");
		int turn = 0; // ù��° �÷��̾� ���� ����
		runGame(turn); // ��ͷ� ���� ����
	}
	
	public void runGame(int turn) {
		System.out.println("�ֻ����� ��������![Enter] ");
//		sc.nextLine();
		
		// �ش� �÷��̾ �̵���Ű��, �ش� Ÿ���� üũ �� ����!!
		if(board.playerMove(turn++)) 
			return;
		
		// �÷��̾� ���ʰ� ��ȯ�ǵ���
		turn = turn % playerTurn;
		
		runGame(turn);
	}

}
