package src.week1.parser;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;

public class Parser {
	
	private static String[] readToArray(String filename) {
        List<String> contents = new LinkedList<String>();
        try{
            contents = read(filename);
        }catch(IOException e){
            e.printStackTrace();
            return null;
        }
        return contents.toArray(new String[contents.size()]);
    }
	
	private static List<String> read(String filename) throws java.io.IOException {
        return Files.readAllLines(Paths.get(filename));
    }
	
	public static void main(String[] args) {
		if(args.length < 1) {
			System.out.println("File not provided");
			return;
		}

		boolean inObject = false;
		boolean lastWasPair = false;

		String[] content = readToArray(args[0]);

		for(String line: content) {
			if(isEmpty(line.trim())) {
				if(inObject) {
					inObject = false;
					printObjectEnd();
				}
				lastWasPair = false;
				continue;
			}
			if(isObject(line)) {
				if(inObject) {
					printObjectEnd();
				}
				printObject(getObject(line).trim());
				lastWasPair = false;
				inObject = true;
				continue;
			}
			line = trimComment(line);

			if(isKeyVal(line)) {
				if(lastWasPair) {
					System.out.println(",");
				}
				String[] kvPair = getKeyValPair(line);
				printKeyValPair(kvPair[0].trim(), kvPair[1].trim());
				lastWasPair = true;
				continue;
			}
			System.out.println("ERROR");
		}
		System.out.println();
		System.out.println("}");
	}

	public static boolean isObject(String line) {
		return line.startsWith("[") && line.endsWith("]");
	}

	public static boolean isKeyVal(String line) {
		return line.contains("=");
	}

	public static boolean isEmpty(String line) {
		return line.isEmpty();
	}

	public static String getObject(String line) {
		return line.substring(1, line.length() - 1);
	}

	public static String[] getKeyValPair(String line) {
		int equalsSign = line.indexOf("=");
		String[] pair = line.split("=", equalsSign + 1);

		return pair;
	}

	public static void printObject(String name) {
		System.out.println("\""+name+"\": {");
	}

	public static void printKeyValPair(String key, String value) {
		System.out.print("    \""+key+"\": \""+value+"\"");	
	}

	public static void printObjectEnd() {
		System.out.println();
		System.out.println("},");
	}

	public static String trimComment(String line) {
		if (line.indexOf(";") > 0)
			return line.substring(0, line.indexOf(";"));
		return line;
	}
}
