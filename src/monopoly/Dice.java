package monopoly;

import java.util.Scanner;

public class Dice {
	Scanner sc = new Scanner(System.in);
	
	public int roll() {
		// 1~6 칸
//		int result = (int)(Math.random() * 6) + 1; 
		int result = sc.nextInt(); // 테스를 위한 직접 입력
		return result;
	}
}
