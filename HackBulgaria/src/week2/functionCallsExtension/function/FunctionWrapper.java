package week2.functionCallsExtension.function;

public class FunctionWrapper {
	private char unknown;
	private String[] body;
	
	
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
	
	public FunctionWrapper(char unknown, String[] body) {
		this.setUnknown(unknown);
		this.setBody(body);
	}
}
