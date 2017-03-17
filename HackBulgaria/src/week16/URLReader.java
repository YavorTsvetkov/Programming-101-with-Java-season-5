package week16;

import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class URLReader {
	public static void main(String[] args) throws Exception {
		URL webURL = new URL("http://:www.technopolis.bg/bg/");
		String content = GetURL(webURL);
		String regex = "href=\"(.*?)\"";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(content);
		
		
		
	}
	
	public static String GetURL(URL url) {
		
	}
}
