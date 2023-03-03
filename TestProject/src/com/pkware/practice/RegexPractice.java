package 
com.pkware.practice;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexPractice {

	public static void main(String[] args) {
		//Pattern Class
		Pattern ptr = Pattern.compile(".*d");
		Matcher mt = ptr.matcher("sasfasds");
		boolean b1 = mt.matches();
		
		boolean b2 = Pattern.compile(".*").matcher("sasfasds").matches();
		
		boolean b3 = Pattern.matches("s+", "dsdss");
		
		System.out.println(b1+" "+b2+" "+b3);
		
		
		System.out.println(Pattern.matches("[abcd]", "aehfs"));
		
		System.out.println(Pattern.matches("[0-9]{9}", "999932235"));
		
		System.out.println(Pattern.matches("[a-z0-9]+@[a-z]*.com", "divyam@pkware.com"));
		
		System.out.println(Pattern.matches("[^abc]", "dfgh"));
	}

}
