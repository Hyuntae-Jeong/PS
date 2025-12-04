package BaekJoon.Class2.BKJ_4153;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        Main.solve();
    }

    public static StringTokenizer tokenize(String input) {
        if (input.equals("0 0 0")) return null;
        return new StringTokenizer(input);
    }

    public static Boolean evaluate(int a, int b, int c) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(a); list.add(b); list.add(c);

        Integer max = Math.max(a, Math.max(b, c));
        list.remove(max);

        return max * max == list.get(0) * list.get(0) + list.get(1) * list.get(1);
    }

    public static void solve() throws IOException {

        StringBuilder sb = new StringBuilder();
        StringTokenizer tokenizer;

        while ( ( tokenizer = tokenize(br.readLine()) ) != null ) {

            int a = Integer.parseInt(tokenizer.nextToken());
            int b = Integer.parseInt(tokenizer.nextToken());
            int c = Integer.parseInt(tokenizer.nextToken());

            if(evaluate(a, b, c)) sb.append("right\n");
            else sb.append("wrong\n");
        }

        System.out.println(sb);
    }
}

public class RightAngledTriangle {
    public static void main(String[] args) throws Exception {
        // 입출력은 BufferedReader, Integer.parseInt가 0.6초, Scanner가 4.8초로 차이가 크다
        // 출력도 BufferedWriter는 1초, System.out.print는 30초.. 하지만 int를 출력할 수 없다는 단점 존재
        // -> 이 경우는 StringBuilder로 출력할 거 다 모은다음에 system.out.println()으로 출력하기 (별 차이 없으니 이거를 기본으로 연습하기)

        System.setIn(new FileInputStream("src/BaekJoon.Class2.BKJ_4153/input.txt"));
        Main.main(args);
    }
}
