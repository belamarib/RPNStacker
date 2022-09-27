import java.util.*;
import java.io.File;

public class RPNStacker {
    public static void main(String[] args) throws Exception {

        File exp = new File("Calc1.stk");
		Scanner scn = new Scanner(exp);

        List <Token> l = new ArrayList<>();
        Stack <Integer> stack = new Stack<Integer>();

        Token token;
        boolean err = false;

        Integer x, y, result;

        while(scn.hasNextLine()) {
            String expression = scn.nextLine();

            switch (expression) {
                case "+":
                    token = new Token(TokenType.PLUS, expression);
                    l.add(token); 
                    x = stack.pop();
                    y = stack.pop();
                    result = x + y;
                    stack.push(result);
                    break;
                case "-":
                    token = new Token(TokenType.MINUS, expression);
                    l.add(token);
                    x = stack.pop();
                    y = stack.pop();
                    result = x - y;
                    stack.push(result);
                    break;
                case "/":
                    token = new Token(TokenType.SLASH, expression);
                    l.add(token);
                    x = stack.pop();
                    y = stack.pop();
                    result = x / y;
                    stack.push(result);
                    break;
                case "*":
                    token = new Token(TokenType.STAR, expression);
                    l.add(token);
                    x = stack.pop();
                    y = stack.pop();
                    result = x * y;
                    stack.push(result);
                    break;
                default:
                    try {
                        int number = Integer.parseInt(expression);
                        token = new Token(TokenType.NUM, expression);
                        l.add(token);
                        stack.push(number);
                    } catch (NumberFormatException e) {
                        System.out.println("Error: Unexpected character: " + expression);
                        err = true;
                    }
            }

            if (err) {
                l.clear();
                break;
            }
        }

        while (!l.isEmpty()) {
            Token t = l.remove(0);
            System.out.println(t.toString());
        }

        if (!err) {
            System.out.println("Saída: " + stack.pop());
        }
    }
}
