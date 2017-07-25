package monopoly;

import java.util.Scanner;

public class CityTile extends Tile {
	int price; // 입주 금액
	int fee; // 무단침입 금액
	Scanner sc;
	Player owner; // 소유주

	public CityTile(String name, int price) {
		super(name);
		this.price = price;

		// 입주금액의 절반
		this.fee = (int) (price * 0.5);
		this.owner = null;
		sc = new Scanner(System.in);
	}

	@Override
	public boolean tileCheck(Player currentP) { // 현재 플레이어를 받게 된다.
		// 해당 타일의 소유가 없을 때
		if (this.owner == null) {
			// 도시를 살 수 있을 때
			if (price <= currentP.getMoney()) {
				System.out.println("$$$$$$$$$$$주인 없는 도시$$$$$$$$$");
				System.out.println("매입 비용: " + price);
				System.out.println("가진 비용: " + currentP.getMoney());
				System.out.print("당신의 선택[y|n] : ");
				String answer = sc.nextLine();
				if (answer.equals("y")) {
						owner = currentP;
						currentP.setMoney(currentP.getMoney() - price);
						System.out.println("\n[건물매입] 당신의 선택이 빛을 발하길....");
				}else {
					System.out.println("\n좀 더 생각해 볼게요");
				}
			}else { // 비어 있지만 살 수 없을 때
				System.out.println("당신의 능력이 부족하여 도시 계약자를 만나지 못했습니다!!!!");
			}
		} else { // 소유자가 있는 상태
			if (owner != currentP) { // 남의 소유이면
				System.out.println(
						"=================================" 
						+ "\n=============똥 밟았다==============\n"
						+ "=================================");
				
				// 현재 플레이어의 금액 감소
				currentP.setMoney(currentP.getMoney() - fee);
				
				// 소유주의 금액 증가
				owner.setMoney(owner.getMoney()+fee);

				// 확인용 출력
				System.out.println("지불 비용 : " + fee);
				System.out.println("지불 후남은 비용 : " + currentP.getMoney());
				System.out.println("집주인이 보태진 총 금액 : " + owner.getMoney());

				if (currentP.getMoney() < 0) { // 한 명이 파산되었을 때
					System.out.println("\n파산\n");
					System.out.println("          ___________.__             ___________           .___          \r\n"
							+ "          \\__    ___/|  |__   ____   \\_   _____/ ____    __| _/          \r\n"
							+ "  ______    |    |   |  |  \\_/ __ \\   |    __)_ /    \\  / __ |    ______ \r\n"
							+ " /_____/    |    |   |   Y  \\  ___/   |        \\   |  \\/ /_/ |   /_____/ \r\n"
							+ "            |____|   |___|  /\\___  > /_______  /___|  /\\____ |           \r\n"
							+ "                          \\/     \\/          \\/     \\/      \\/          ");
					return true;

				}
			} else { // 본인 소유
				System.out.println("우리 집이네?ㅋㅋㅋㅋ\n사놓길 잘했군!!!");
			}
		}
		System.out.println("현재 플레이어가 가진 돈 : " + currentP.getMoney());
		return false;
	}

}
