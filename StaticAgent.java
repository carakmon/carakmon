package httpserver2;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

public class StaticAgent extends AbstractAgent{
	private Map<String, String> mimeMap;
	private String suffix;

	public StaticAgent(String target, String suffix, OutputStream outputStream) {

		super(target,outputStream);
		
		this.suffix = suffix;
		
		mimeMap = new HashMap<>();
		mimeMap.put("jpg", "Content-Type: image/jpeg\r\n\r\n");
		mimeMap.put("mp3", "Content-Type: audio/mpeg\r\n\r\n");
		mimeMap.put("html", "Content-Type: text/html; charset=UTF-8\r\n\r\n");

	}



	public void service() throws Exception {

		System.out.println("=====================");
		System.out.println(this.target);

		makeHeader();

		out.write(mimeMap.get(this.suffix).getBytes());
		
		InputStream fin = new FileInputStream("C:\\Knaru\\BitCamp"+target);
		
		byte[] buffer = new byte[1024*8];
		
		while (true) {
			int count = fin.read(buffer);
			if(count == -1 ) {
				break;
			}
			out.write(buffer,0,count);
			
		}
		
		

		out.flush();
		fin.close();
	}
}