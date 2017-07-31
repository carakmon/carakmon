package httpserver;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ImageServer {
	// bad code
	public static void main(String[] args) throws Exception {

		ServerSocket server = new ServerSocket(5555);
		System.out.println("Server ready....");

		while (true) {

			new Thread(() -> {

				try (Socket client = server.accept();
						OutputStream out = client.getOutputStream();
						Scanner inSC = new Scanner(client.getInputStream())) {

					String str = inSC.nextLine();
					String[] arr = str.split(" ");
					String target = arr[1];

					if (target.length() > 1) {
						target = target.substring(1);

					} else {
						target = "MP3.html";
					}

					String type = target.substring(target.lastIndexOf(".") + 1);

					System.out.println(type);

					System.out.println("------------------------");
					System.out.println(target);
					System.out.println("------------------------");

					// String msg = "<h1>Hello World</h1>";

					out.write(new String("HTTP/1.1 200 OK\r\n").getBytes());
					out.write(new String("Cache-Control: private\r\n").getBytes());
					// out.write(new String("Content-Length: 1585161\r\n").getBytes());

					if (type.equalsIgnoreCase("jpg")) {
						out.write(new String("Content-Type: image/jpeg; charset=UTF-8\r\n\r\n").getBytes());
					} else if (type.equalsIgnoreCase("mp3")) {
						out.write(new String("Content-Type: audio/mpeg; charset=UTF-8\r\n\r\n").getBytes());
					} else {
						out.write(new String("Content-Type: text/html; charset=UTF-8\r\n\r\n").getBytes());

					}

					// out.write(msg.getBytes());

					InputStream in;

					if (type.equalsIgnoreCase("mp3")) {
						in = new FileInputStream("C:\\Knaru\\Song\\" + target);
					} else {
						in = new FileInputStream("C:\\Knaru\\BitCamp\\" + target);
					}

					byte[] buffer = new byte[1024 * 8];
					while (true) {

						int count = in.read(buffer);
						if (count == -1) {
							break;
						}
						out.write(buffer, 0, count);
					}

					in.close();
					out.flush();

				} catch (Exception e) {
					System.out.println(e.getMessage());
				}

				// out.close();
				// client.close();

			}).start();
		} // end while
	}
}
