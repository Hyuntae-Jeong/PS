package BaekJoon.Class3.BKJ_1620;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.StringTokenizer;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, M;

    public static void main(String[] args) throws IOException {
        StringTokenizer token = new StringTokenizer(br.readLine());
        N = Integer.parseInt(token.nextToken());
        M = Integer.parseInt(token.nextToken());

        getInput();
        printAnswer();
    }

    static HashMap<String, Integer> nameToNumber;
    static HashMap<Integer, String> numberToName;

    static void getInput() throws IOException {
        nameToNumber = new HashMap<>();
        numberToName = new HashMap<>();

        for (int i = 1; i <= N; i++) {
            String name = br.readLine();
            nameToNumber.put(name, i);
            numberToName.put(i, name);
        }
    }

    static void printAnswer() throws IOException {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < M; i++) {
            String input = br.readLine();
            try {
                sb.append(numberToName.get(Integer.parseInt(input))).append("\n");
            } catch (NumberFormatException e) {
                sb.append(nameToNumber.get(input)).append("\n");
            }
        }

        System.out.print(sb);
    }
}

public class Pokemon {
    public static void main(String[] args) throws IOException {
        System.setIn(Files.newInputStream(Paths.get("src/BaekJoon/Class3/BKJ_1620/input.txt")));
        Main.main(args);
    }
}
