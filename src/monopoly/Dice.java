package monopoly;

import java.util.Scanner;

public class Dice {
	Scanner sc = new Scanner(System.in);
	
	public int roll() {
		// 1~6 ĭ
//		int result = (int)(Math.random() * 6) + 1; 
		int result = sc.nextInt(); // �׽��� ���� ���� �Է�
		return result;
	}
}
