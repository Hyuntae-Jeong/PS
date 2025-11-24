package BKJ_1918;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        String token = br.readLine();
        char[] tokens = token.toCharArray();
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for (char c : tokens) {
            switch (c){
                case '(':
                    stack.push(c);
                    break;
                case ')':
                    while (!stack.isEmpty()) {
                        if (stack.peek().equals('(')) {
                            stack.pop();
                            break;
                        }
                        sb.append(stack.pop());
                    }
                    break;
                case '*':
                case '/':
                    while (!stack.isEmpty()) {
                        if (stack.peek().equals('(') || stack.peek().equals('+') || stack.peek().equals('-')) break;
                        sb.append(stack.pop());
                    }
                    stack.push(c);
                    break;
                case '+':
                case '-':
                    while (!stack.isEmpty()) {
                        if (stack.peek().equals('(')) break;
                        sb.append(stack.pop());
                    }
                    stack.push(c);
                    break;
                default:
                    sb.append(c);
            }
        }

        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        System.out.println(sb);
    }
}

public class PostfixNotation {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/BKJ_1918/input.txt"));
        Main.main(args);
    }
}

