package monopoly;

public class Board {
	// 보드판을 20으로 설정
	int BOARDSIZE = 20;
	Tile[] tiles;
	Player[] players;
	Dice dice;

	public Board() {

		// 주사위 세팅
		dice = new Dice();

		// 타일 세팅
		tiles = new Tile[BOARDSIZE];

		// 각 타일의 종류 섞기
		for (int i = 0; i < tiles.length; i++) {
			if (i % 2 == 0) { // 짝수
				tiles[i] = new CityTile("city " + i, i * 1000);
				continue;
			} // 홀수
			tiles[i] = new Tile("일반 " + i);
		}
	}

	public void setPlayer(int playerNum) {
		players = new Player[playerNum];
		for (int i = 0; i < players.length; i++) {
			// 0번부터의 이름과 초기자금 2만원 세팅
			players[i] = new Player("" + i, 20000);
		}
	}

	public boolean playerMove(int turn) {

		// 현 차례의 플레이어
		Player currentP = players[turn];

		// 랜덤 값만큼 이동하게~
		int afterMove = currentP.move(dice.roll());

		// 한바퀴 돌았을 때 다시 한바퀴 돌도록 인덱스 조정
		if (afterMove >= BOARDSIZE) {
			afterMove = afterMove % BOARDSIZE;
			currentP.setPosition(afterMove);
		}

		// 확인용 출력
		System.out.println("내 이름은 " + currentP.getName() + "번  이동한 위치는 " + currentP.getPosition());

		// 이동한 현재 플레이어에 대한 타일 체크(종류 및 액션)
		return tiles[afterMove].tileCheck(currentP);
	}

}
