package jsngyoon;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.lang.RuntimeException;


public class StringCalculator {
	
	public StringCalculator() {}
	
	public int add(String input) {
		String[] tokens;
		Matcher m = Pattern.compile("//(.)\n(.*)").matcher(input);
		if (m.find()) {
			String customDelimiter = m.group(1);
			tokens = m.group(2).split(customDelimiter);
		}
		else tokens = input.split("[,:]");
		
		return addParsed(tokens);
	}
	
	private int addParsed(String[] tokens) throws RuntimeException {
		int sum = 0;
		for (String token : tokens) {
			if (token.startsWith("-")) throw new RuntimeException();
			sum += Integer.parseInt(token);
		}
		return sum;
	}
	
	public static void main(String[] args) {
		StringCalculator sc = new StringCalculator();
		
		int sum = sc.add("1,2:3");
		System.out.println(sum);
		sum = sc.add("//#\n1#2#3");
		System.out.println(sum);
	}

}
