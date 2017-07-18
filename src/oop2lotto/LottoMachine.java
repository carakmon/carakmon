package oop2lotto;

import java.util.Arrays;
import java.util.stream.IntStream;

public class LottoMachine {
	LottoBall[] balls;

	public LottoMachine(int num) {
		super();
		balls = new LottoBall[num];
		for (int i = 0; i < num; i++) {
			balls[i] = new LottoBall(i + 1);
		}

	}

	public int[] select(int num) {
		int[] result = new int[num];

		for (int i = 0; i < num; i++) {
			int idx = (int) (Math.random() * balls.length);

			if (balls[idx].askSelected()) {
				i--;
				continue;
			}

			result[i] = balls[idx].num;

		} // end for

		reset();

		return result;
	}

	private void reset() {

		for (LottoBall lottoBall : balls) {
			lottoBall.reset();
		}

	}

}
