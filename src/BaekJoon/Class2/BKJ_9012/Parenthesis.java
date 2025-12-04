package BaekJoon.Class2.BKJ_9012;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.EmptyStackException;
import java.util.Stack;

class Main {
    static int N;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            sb.append(judgeParenthesis()).append("\n");
        }

        System.out.println(sb);
    }

    public static String judgeParenthesis() throws IOException {
        String inputString = br.readLine();
        Stack<Integer> stack = new Stack<Integer>();

        for (int i = 0; i < inputString.length(); i++){
            if (inputString.charAt(i) == '(') {
                stack.push(Integer.valueOf(1));
            } else {
                try {
                    stack.pop();
                } catch (EmptyStackException e){
                    // ) 괄호에 대한 짝이 없을 때
                    return "NO";
                }
            }
        }
        
        // 입력 다 끝났는데 아직 짝이 없는 ( 괄호가 남아있으면 실패
        if (stack.empty()) return "YES";
        else return "NO";
    }

}

public class Parenthesis {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/BaekJoon.Class2.BKJ_9012/input.txt"));
        Main.main(args);
    }
}
