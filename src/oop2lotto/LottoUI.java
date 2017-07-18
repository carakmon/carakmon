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
		print("로또 자판기입니다.");
		String str = input("사용하시겠습니까?");

		if (str.equalsIgnoreCase("n"))
			end();

		machine = new LottoMachine(45);
		runTask();
		end();
	}

	//running
	public void runTask() {
		int money = inputInt("돈을 투입하세요.");
		
		
		//거스름돈 계산
		int change = money % 1000;

		if (change > 0) {
			print("거스름돈은 " + change + "원 입니다.");
		}

		
		//로또 뽑기
		for (int i = 0; i < money / 1000; i++) {
			print("번호를 뽑겠습니다.");
			int[] result = machine.select(6);
			print(Arrays.toString(result));
			print("-------------------------------------------");
		}
		
		//반복 질문
		String str = input("계속 하시겠습니까?");

		if (str.equalsIgnoreCase("n"))
			return;
		
		
		runTask();

	}

	//ending
	public void end() {
		print("-------------------------------------------");
		print("사용을 종료하셨습니다.");
		print("로또 자판기를 이용해 주셔서 감사합니다.");
		print("안녕히가세요.");
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
