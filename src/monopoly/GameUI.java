package monopoly;

import java.util.Scanner;

public class GameUI {
	Board board;
	Scanner sc;
	int playerTurn; // 플레이어 턴(총 플레이어 수)

	public GameUI(Board board) {
		this.board = board;
		sc = new Scanner(System.in); 
		
	}
	public void setPlayer() {
		System.out.print("플레이어 수를 입력하세요: ");
		int playerNum = Integer.parseInt(sc.nextLine());
		playerTurn = playerNum;
		board.setPlayer(playerNum);
	}
	
	public void init() {
		System.out.println("Welcome");
		int turn = 0; // 첫번째 플레이어 부터 시작
		runGame(turn); // 재귀로 게임 진행
	}
	
	public void runGame(int turn) {
		System.out.println("주사위를 굴리세요![Enter] ");
//		sc.nextLine();
		
		// 해당 플레이어를 이동시키고, 해당 타일을 체크 후 동작!!
		if(board.playerMove(turn++)) 
			return;
		
		// 플레이어 차례가 순환되도록
		turn = turn % playerTurn;
		
		runGame(turn);
	}

}
