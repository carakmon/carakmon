package oop2lotto;

import java.util.Arrays;
import java.util.Scanner;

public class LottoUI {

	Scanner sc;
	LottoMachine machine;

	
	//initialize
	public LottoUI() {
		sc = new Scanner(System.in);
	}

	
	//starting
	public void start() {
		print("�ζ� ���Ǳ��Դϴ�.");
		String str = input("����Ͻðڽ��ϱ�?");

		if (str.equalsIgnoreCase("n"))
			end();

		machine = new LottoMachine(45);
		runTask();
		end();
	}

	//running
	public void runTask() {
		int money = inputInt("���� �����ϼ���.");
		
		
		//�Ž����� ���
		int change = money % 1000;

		if (change > 0) {
			print("�Ž������� " + change + "�� �Դϴ�.");
		}

		
		//�ζ� �̱�
		for (int i = 0; i < money / 1000; i++) {
			print("��ȣ�� �̰ڽ��ϴ�.");
			int[] result = machine.select(6);
			print(Arrays.toString(result));
			print("-------------------------------------------");
		}
		
		//�ݺ� ����
		String str = input("��� �Ͻðڽ��ϱ�?");

		if (str.equalsIgnoreCase("n"))
			return;
		
		
		runTask();

	}

	//ending
	public void end() {
		print("-------------------------------------------");
		print("����� �����ϼ̽��ϴ�.");
		print("�ζ� ���Ǳ⸦ �̿��� �ּż� �����մϴ�.");
		print("�ȳ���������.");
		return;
	}

	
	//input & output
	private void print(String string) {
		System.out.println(string);
	}

	private String input(String string) {
		print(string);
		return sc.nextLine();
	}

	private int inputInt(String string) {

		return Integer.parseInt(input(string));

	}

}
