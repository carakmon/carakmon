package monopoly;

import java.util.Scanner;

public class CityTile extends Tile {
	int price; // ���� �ݾ�
	int fee; // ����ħ�� �ݾ�
	Scanner sc;
	Player owner; // ������

	public CityTile(String name, int price) {
		super(name);
		this.price = price;

		// ���ֱݾ��� ����
		this.fee = (int) (price * 0.5);
		this.owner = null;
		sc = new Scanner(System.in);
	}

	@Override
	public boolean tileCheck(Player currentP) { // ���� �÷��̾ �ް� �ȴ�.
		// �ش� Ÿ���� ������ ���� ��
		if (this.owner == null) {
			// ���ø� �� �� ���� ��
			if (price <= currentP.getMoney()) {
				System.out.println("$$$$$$$$$$$���� ���� ����$$$$$$$$$");
				System.out.println("���� ���: " + price);
				System.out.println("���� ���: " + currentP.getMoney());
				System.out.print("����� ����[y|n] : ");
				String answer = sc.nextLine();
				if (answer.equals("y")) {
						owner = currentP;
						currentP.setMoney(currentP.getMoney() - price);
						System.out.println("\n[�ǹ�����] ����� ������ ���� ���ϱ�....");
				}else {
					System.out.println("\n�� �� ������ ���Կ�");
				}
			}else { // ��� ������ �� �� ���� ��
				System.out.println("����� �ɷ��� �����Ͽ� ���� ����ڸ� ������ ���߽��ϴ�!!!!");
			}
		} else { // �����ڰ� �ִ� ����
			if (owner != currentP) { // ���� �����̸�
				System.out.println(
						"=================================" 
						+ "\n=============�� ��Ҵ�==============\n"
						+ "=================================");
				
				// ���� �÷��̾��� �ݾ� ����
				currentP.setMoney(currentP.getMoney() - fee);
				
				// �������� �ݾ� ����
				owner.setMoney(owner.getMoney()+fee);

				// Ȯ�ο� ���
				System.out.println("���� ��� : " + fee);
				System.out.println("���� �ĳ��� ��� : " + currentP.getMoney());
				System.out.println("�������� ������ �� �ݾ� : " + owner.getMoney());

				if (currentP.getMoney() < 0) { // �� ���� �Ļ�Ǿ��� ��
					System.out.println("\n�Ļ�\n");
					System.out.println("          ___________.__             ___________           .___          \r\n"
							+ "          \\__    ___/|  |__   ____   \\_   _____/ ____    __| _/          \r\n"
							+ "  ______    |    |   |  |  \\_/ __ \\   |    __)_ /    \\  / __ |    ______ \r\n"
							+ " /_____/    |    |   |   Y  \\  ___/   |        \\   |  \\/ /_/ |   /_____/ \r\n"
							+ "            |____|   |___|  /\\___  > /_______  /___|  /\\____ |           \r\n"
							+ "                          \\/     \\/          \\/     \\/      \\/          ");
					return true;

				}
			} else { // ���� ����
				System.out.println("�츮 ���̳�?��������\n����� ���߱�!!!");
			}
		}
		System.out.println("���� �÷��̾ ���� �� : " + currentP.getMoney());
		return false;
	}

}
