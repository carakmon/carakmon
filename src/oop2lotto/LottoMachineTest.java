package oop2lotto;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class LottoMachineTest {
	
	LottoMachine machine;

	@Before
	public void setUp() throws Exception {
		machine = new LottoMachine(45);
	}

	@Test
	public void test() {
		int[] result = machine.select(6);
		
		for (int i : result) {
			System.out.println(i);
		}
	}

}
