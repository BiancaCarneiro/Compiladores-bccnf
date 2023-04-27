package rpn;

public class Regex {
	public static boolean isNum(String token) {
        for (int i = 0; i < token.length(); i++) {
            switch (token.charAt(i)) {
                case '0':
                    return true;
                case '1':
                    return true;
                case '2':
                    return true;
                case '3':
                    return true;
                case '4':
                    return true;
                case '5':
                    return true;
                case '6':
                    return true;
                case '7':
                    return true;
                case '8':
                    return true;
                case '9':
                    return true;
            default:
                    return false;
            }
        }
        return false;
    }
	
	public static boolean isOP(String token) {
        for (int i = 0; i < token.length(); i++) {
            switch (token.charAt(i)) {
                case '+':
                    return true;
                case '-':
                    return true;
                case '*':
                    return true;
                case '/':
                    return true;
                default:
                    return false;
            }
        }
        return false;
    }

}