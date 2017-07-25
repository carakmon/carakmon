package monopoly;

public class Player {
	String name; // ��ȣ�� �̸�
	private int money, position; // ���� ���� ���� ��ġ

	public Player(String name, int money) {
		this.name = name;
		this.money = money; // ��� �÷��̾�� �����ϰ� ����
		this.position = 0; // 0���� ����
	}

	public int move(int movePoint) {
		position += movePoint;
		System.out.println("�ֻ��� ��: " + movePoint);
		return position;
	}

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}
	

}
