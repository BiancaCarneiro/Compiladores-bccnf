package rpn;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex {
	public static boolean isNum(String token) {
        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(token);

        if (matcher.matches()){
            return true;
        }
        return false;
    }
	
	public static boolean isOP(String token) {
        Pattern pattern = Pattern.compile("[\\+\\-\\*\\/]");
        Matcher matcher = pattern.matcher(token);
        if (matcher.matches()){
            return true;
        }
        return false;
    }

}