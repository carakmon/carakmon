package httpserver2;

import java.io.FileInputStream;
import java.io.OutputStream;
import java.lang.reflect.Constructor;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Properties;
import java.util.Scanner;

public class ServerMain {
	public static void main(String[] args) throws Exception{
	
		Properties prop = new Properties();
		prop.load(new FileInputStream("C:\\Knaru\\BitCamp\\server.properties"));
		
		ServerSocket server = new ServerSocket(5555);
		
		while(true) {
			
			Socket client = server.accept();
			
			new Thread(()-> {
				try {
					Scanner sc = new Scanner(client.getInputStream());
					String line = sc.nextLine();
							
					System.out.println(line);
					String target = line.split(" ")[1];
					
					if(target.length() < 2) {
						target = "/index.html";
					}
					
					String suffix = target.substring(target.lastIndexOf(".")+1);
					System.out.println("suffix: "+suffix);
					if(suffix.startsWith("java96")){
						String msg = target.split("\\?")[0]; // ¹ÂÁ÷ÀÌ³ª ÄûÁî ¸í
		
						String className = prop.getProperty(msg);
						
						Class clz = Class.forName(className);	
					
						
						Constructor con = clz.getConstructor(String.class, OutputStream.class);
						
						
						Object obj = con.newInstance(target, client.getOutputStream());
						
						
						clz.getMethod("service").invoke(obj);
//						new Musiclet(target, client.getOutputStream()).service();
					
					
					}else if(suffix.startsWith("ico")) {
						
						System.out.println("ico ¹®Á¦");
					
					}
					else {
						System.out.println("static resources");
						
						new StaticAgent(target, suffix, client.getOutputStream()).service();
					}
					
					System.out.println(client);
					sc.close();
					client.close();
				}catch (Exception e) {
					
				}
			}).start();
			
			
		}//while
	}
}