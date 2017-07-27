package ioQuiz;

import java.util.ArrayList;
import java.util.Arrays;

public class TestQuiz {
	
	String title;
	int answer;
	String[] option;
	public TestQuiz(String title, int answer, String... option) {
		this.title = title;
		this.answer = answer;
		this.option = option;
	}
	
	public TestQuiz(String title, String answer, String... option) {
		this.title = title;
		this.answer = Integer.parseInt(answer);
		this.option = option;
	}
	
	public String getQuiz() {
		return title + Arrays.toString(option);
	}
	
	public boolean checkAns(String userAns) {
		int intAns = Integer.parseInt(userAns);
		return this.answer == intAns;
	}

	@Override
	public String toString() {
		return "TestQuiz [title=" + title + ", answer=" + answer + ", option=" + Arrays.toString(option) + "]";
	}
	
	
	

}
