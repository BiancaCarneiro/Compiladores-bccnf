package rpn;

import java.util.Stack;

public class Main {

    public static double reversePolishNotationSolver(Stack<Token> entry){
        Stack<Double> stack = new Stack<>();

        for (Token token : entry) {
            System.out.println(token);
            if (Regex.isNum(token.lexeme) || Regex.isOP(token.lexeme)){
                switch (token.lexeme) {
                    case "+":
                        stack.push(stack.pop() + stack.pop());
                        break;
                    case "-":
                        double subtrahend = stack.pop();
                        stack.push(stack.pop() - subtrahend);
                        break;
                    case "*":
                        stack.push(stack.pop() * stack.pop());
                        break;
                    case "/":
                        double divisor = stack.pop();
                        stack.push(stack.pop() / divisor);
                        break;
                    default:
                        stack.push(Double.parseDouble(token.lexeme));
                        break;
                }
            }
        }
        if (stack.size() > 0) return stack.pop();
        return 0;
    }

    public static Stack<Token> getTokens(String entry){
        Stack<Token> tokens = new Stack<>();

        for (String token : entry.split("\n")) {
            if (Regex.isNum(token)){
                tokens.push(new Token(TokenType.NUM, token));
            } else if (Regex.isOP(token)){
                switch (token) {
                    case "+":
                        tokens.push(new Token(TokenType.PLUS, token));
                        break;
                    case "-":
                        tokens.push(new Token(TokenType.MINUS, token));
                        break;
                    case "*":
                        tokens.push(new Token(TokenType.STAR, token));
                        break;
                    case "/":
                        tokens.push(new Token(TokenType.SLASH, token));
                        break;
                }
            } else {
                System.out.println("ERROR: Unexpected character: " + token);
                Stack<Token> it = new Stack<>();
                return it;
            }
        }
        return tokens;
    }

    public static void main(String[] args) {
        String expression = "4\n8\n+\n3\n*";
        System.out.println("Result: " + reversePolishNotationSolver(getTokens(expression)));
        expression = "10\n10\n+";
        System.out.println("Result: " + reversePolishNotationSolver(getTokens(expression)));
        expression = "10\ns\n+";
        System.out.println("Result: " + reversePolishNotationSolver(getTokens(expression)));
    }
}
