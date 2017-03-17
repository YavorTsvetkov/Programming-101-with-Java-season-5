package week2.functionCallsExtension.function;

public class Function {
	private String name;
	private char unknown;
	private String[] body;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public char getUnknown() {
		return unknown;
	}
	public void setUnknown(char unknown) {
		this.unknown = unknown;
	}
	public String[] getBody() {
		return body;
	}
	public void setBody(String[] body) {
		this.body = body;
	}
	
	public Function(String line) {
		int i = line.indexOf(" ");
		this.setName(line.substring(0, i));
		
		this.setUnknown(line.charAt(i + 1));
		
		int equalIndex = line.indexOf("=");
		
		String[] body = line.substring(equalIndex + 2, line.length()).split(" ");
		this.setBody(body);
	}
}
