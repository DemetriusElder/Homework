package Regex;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexPatterns {
	
	public static boolean testName(String name) {
		return name.matches("(^[A-Z]{0,2})([a-z]*)([-]?)([A-Z]{0,2})([a-z]*)(\\s)([A-Z]{0,2})([a-z]*)([-]?)([A-Z]{0,2})([a-z]*)$");
	}
	public static boolean testPhoneNumber(String phoneNumber) {
		return phoneNumber.matches("(^[(])([7][7][0]|[4][0][4]|[6][7][8])([)])(\\d{3})([-])(\\d{4})$");
	}
	public static boolean testEmail(String email) {
		return email.matches("(^[a-zA-Z])(\\w*)([\\W]*)([@]{1})([a-zA-Z])(\\w)([^@.]*)([.][c][o][m]|[.][o][r][g]|[.][n][e][t])$");
	}
	public static boolean testAddress(String adress) {
		return adress.matches("(^\\d{0,5})(\\s)(.*)(\\n)([^\\d]*)([^\\s\\d])(\\s?)([,]?)(\\s?)([A-Z]{2})(\\s{0,})(\\d{0,5})$");
	}
	public static boolean testJavaExecutable(String java) {
		return java.matches("(^.*)(public)(\\s)(static)(\\s)(void)(\\s)(main)(\\()(String)(\\[)(\\])(\\s)(args)(\\))(.*)$");
	}

}
