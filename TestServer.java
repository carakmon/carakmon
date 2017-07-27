package ioQuiz;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import org.xml.sax.InputSource;

public class TestServer {
	
	public static void main(String[] args) throws Exception {
		ArrayList<TestQuiz> quiz = new ArrayList<>();
		//TestQuiz[] quiz = new TestQuiz[10];
		InputStream in = new FileInputStream("C:\\Knaru\\BitCamp\\Quiz.txt");
		Scanner fileSC = new Scanner(in);
		
		for (int i = 0; i < 10; i++) {
			String str = fileSC.nextLine();
			String[] arr = str.split(",");
			TestQuiz tempQ = new TestQuiz(arr[0], Integer.parseInt(arr[1]), Arrays.copyOfRange(arr, 2, arr.length));
			quiz.add(tempQ);
			
		}
		
		//System.out.println(quiz.toString());
		fileSC.close();	

		System.out.println("---------------------------------");
		ServerSocket server = new ServerSocket(5555);
		Socket socket = server.accept();
		System.out.println("connected");
		
		for (int i = 0; i < 10; i++) {
			OutputStream out = socket.getOutputStream();
			
			byte[] msg = (quiz.get(i).getQuiz() + "\n").getBytes();
			
			out.write(msg);
			
//			InputStream userIN = socket.getInputStream();
//			Scanner inSc = new Scanner(userIN);
//			
//			String userAns = inSc.nextLine();
//			boolean right = quiz.get(i).checkAns(userAns);
//			
//			msg = "Á¤´ä".getBytes();
//			out.write(msg);
			
		}
		
		
		
		
		socket.close();
		server.close();
		
	}

}
