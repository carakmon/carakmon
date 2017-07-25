package monopoly;

public class Board {
	// �������� 20���� ����
	int BOARDSIZE = 20;
	Tile[] tiles;
	Player[] players;
	Dice dice;

	public Board() {

		// �ֻ��� ����
		dice = new Dice();

		// Ÿ�� ����
		tiles = new Tile[BOARDSIZE];

		// �� Ÿ���� ���� ����
		for (int i = 0; i < tiles.length; i++) {
			if (i % 2 == 0) { // ¦��
				tiles[i] = new CityTile("city " + i, i * 1000);
				continue;
			} // Ȧ��
			tiles[i] = new Tile("�Ϲ� " + i);
		}
	}

	public void setPlayer(int playerNum) {
		players = new Player[playerNum];
		for (int i = 0; i < players.length; i++) {
			// 0�������� �̸��� �ʱ��ڱ� 2���� ����
			players[i] = new Player("" + i, 20000);
		}
	}

	public boolean playerMove(int turn) {

		// �� ������ �÷��̾�
		Player currentP = players[turn];

		// ���� ����ŭ �̵��ϰ�~
		int afterMove = currentP.move(dice.roll());

		// �ѹ��� ������ �� �ٽ� �ѹ��� ������ �ε��� ����
		if (afterMove >= BOARDSIZE) {
			afterMove = afterMove % BOARDSIZE;
			currentP.setPosition(afterMove);
		}

		// Ȯ�ο� ���
		System.out.println("�� �̸��� " + currentP.getName() + "��  �̵��� ��ġ�� " + currentP.getPosition());

		// �̵��� ���� �÷��̾ ���� Ÿ�� üũ(���� �� �׼�)
		return tiles[afterMove].tileCheck(currentP);
	}

}
