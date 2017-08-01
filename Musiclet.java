package httpserver2.let;

import java.io.OutputStream;

import httpserver2.AbstractAgent;

public class Musiclet extends AbstractAgent {

	public Musiclet(String target, OutputStream out) {
		super(target, out);
		
	}

	@Override
	public void service() throws Exception {
		
		makeHeader();
		out.write("Content-Type: text/html; charset=UTF-8\r\n\r\n".getBytes());
		out.write("<style>".getBytes());
		out.write("li {List-style:none}".getBytes());
		out.write("".getBytes());
		out.write("iframe {".getBytes());
		out.write("  width:0px;".getBytes());
		out.write("  height:0px;".getBytes());
		out.write("  border:0px;".getBytes());
		out.write("}".getBytes());
		out.write("</style>".getBytes());
		out.write("".getBytes());
		out.write("<div>".getBytes());
		out.write("  <ul>".getBytes());
		out.write("  <li><a href='aaa.mp3' target='song'>aaa.mp3</a></li>".getBytes());
		out.write("  <li><a href='bbb.mp3' target='song'>bbb.mp3</a></li>".getBytes());
		out.write("  <li><a href='ccc.mp3' target='song'>ccc.mp3</a></li>".getBytes());
		out.write("  </ul>".getBytes());
		out.write("</div>".getBytes());
		out.write("<iframe name = 'song'>".getBytes());
		out.write("  ".getBytes());
		out.write("</iframe>".getBytes());
		
	}

}
