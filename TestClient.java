package ioQuiz;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class TestClient {

	public static void main(String[] args) throws Exception {

		Socket socket = new Socket("192.168.0.33", 5555);

		System.out.println(socket);
		InputStream in = socket.getInputStream();
		OutputStream out = socket.getOutputStream();
		Scanner sc = new Scanner(in);

		
		for (int i = 0; i < 10; i++) {
	
		System.out.println(sc.nextLine());
//			byte[] msg = sc.nextLine().getBytes();
//			System.out.println(msg.toString());
//			msg = sc.nextLine().getBytes();
//			in.read(msg);
//			
		}

		socket.close();
	}

}
