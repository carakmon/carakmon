package httpserver2.let;
import java.io.OutputStream;
import java.util.Arrays;

public class Quiz {
	String title;
	int answer;
	String[] opt;
	
	public Quiz(String title, String answer, String... opt) {
		this.title = title;
		this.answer = Integer.parseInt(answer);
		this.opt = opt;
	}

	@Override
	public String toString() {
		return "Q." + title + "\n" + Arrays.toString(opt);
	}
	
	public void toHTML(OutputStream out,int quizNum) throws Exception{
		
		out.write(("<h1>" + this.title + "</h1>").getBytes("UTF-8"));
		
		for (int i = 0; i < opt.length; i++) {
			
			int nextQuiz = -1;
			if(i == (answer - 1)) {
				nextQuiz = quizNum + 1;
//				continue;
			}
//			out.write(("<li><a href='quiz.java96?no=-1" + this.opt[i] + "</a></li>").getBytes("UTF-8"));			
			out.write(("<li><a href='quiz.java96?no=" + nextQuiz + "'>" + this.opt[i] + "</a></li>").getBytes("UTF-8"));
			
		}
		return;
	}

	public boolean checkAnswer(int answer) {
		if(answer != this.answer)
			return false;
		return true;
	}

	public void printProblem() {
		System.out.println(title);
		System.out.println(Arrays.toString(opt));
	}
	
	
	
	
	
	
}
