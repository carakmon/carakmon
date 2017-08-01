package httpserver2.let;

import java.io.File;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import httpserver2.AbstractAgent;

public class Quizlet extends AbstractAgent {
	Integer quizNum = 0;
	Map<Integer, Quiz> hash = new HashMap<>();

	public Quizlet(String target, OutputStream out) {
		super(target, out);
		try {
			this.quizNum = Integer.parseInt(target.substring(target.lastIndexOf("=") + 1));
			
		}catch(Exception e) {
			System.out.println(this.quizNum);
			
			this.quizNum = 1;
		}
	}

	@Override
	public void service() throws Exception {
		File file = new File("C:\\Knaru\\BitCamp\\Quiz.txt");
		Scanner fileScanner = new Scanner(file);


		Quiz[] quizes = new Quiz[10];
		

		// 파일을 라일별로 읽으면서 퀴즈배열을 저장
		for (int i = 0; i < quizes.length; i++) {
			try {
				String line = fileScanner.nextLine();
				String[] lineArr = line.split(",");
				quizes[i] = new Quiz(lineArr[0], lineArr[1], Arrays.copyOfRange(lineArr, 2, lineArr.length));
//				System.out.println(quizes[i].title);
			} catch (Exception e) {
				break;
			}
		} // 퀴즈 배열제작

		makeHeader();

		out.write("Content-Type: text/html; charset=UTF-8\r\n\r\n".getBytes());
		if(quizNum < 0) {
			out.write(("<h1>틀렸습니다.</h1>").getBytes("UTF-8"));
			return;
		}else if (quizNum > quizes.length) {
			out.write(("<h1>축하합니다. 모든 문제를 맞추셨군요.</h1>").getBytes("UTF-8"));
			return;
		}
		quizes[quizNum -1].toHTML(out,quizNum);
//		out.write(("<li>" + quizes[quizNum - 1].toHTML() + "</li>").getBytes("UTF-8"));// 넘버를 받아서 해당하는 문제 보여줌
////		out.write(("<li>" + quizes[quizNum - 1].opt[0] + "</li>").getBytes("UTF-8"));
////		out.write(("<li>" + quizes[quizNum - 1].opt[1] + "</li>").getBytes("UTF-8"));

	}

}
