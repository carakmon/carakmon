package monopoly;

public class Player {
	String name; // 번호로 이름
	private int money, position; // 가진 돈과 현재 위치

	public Player(String name, int money) {
		this.name = name;
		this.money = money; // 모든 플레이어에게 동일하게 세팅
		this.position = 0; // 0으로 시작
	}

	public int move(int movePoint) {
		position += movePoint;
		System.out.println("주사위 값: " + movePoint);
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
