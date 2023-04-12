package rpn;

import java.util.Stack;
import java.util.List;

public class Main {

    public static double reversePolishNotationSolver(Stack<Token> entry){
        Stack<Double> stack = new Stack<>();

        for (Token token : entry) {
            System.out.println(token);
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
        return stack.pop();
    }

    public static Stack<Token> getTokens(String entry){
        Stack<Token> tokens = new Stack<>();

        for (String token : entry.split("\n")) {
            if (token.equals("+")){
                tokens.push(new Token(TokenType.PLUS, token));
            } else if (token.equals("-")){
                tokens.push(new Token(TokenType.MINUS, token));
            } else if (token.equals("/")){
                tokens.push(new Token(TokenType.SLASH, token));
            } else if (token.equals("*")){
                tokens.push(new Token(TokenType.STAR, token));
            } else if (token != null){
                tokens.push(new Token(TokenType.NUM, token));
            } else {
                tokens.push(new Token(TokenType.EOF, null));
            }
        }
        return tokens;
    }

    public static void main(String[] args) {
        String expression = "4\n8\n+\n3\n*";
        System.out.println("Result: " + reversePolishNotationSolver(getTokens(expression)));
        expression = "10\n10\n+";
        System.out.println("Result: " + reversePolishNotationSolver(getTokens(expression)));
    }
}
