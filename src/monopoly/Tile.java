package monopoly;

public class Tile {
	String name;
	
	public Tile(String name) {
		this.name = name;
	}

	public boolean tileCheck(Player player) {
		// 테스트를 위한 일반 타일 표시
		System.out.println("######## 그냥 타일 ########"); 
		return false;
	}
}