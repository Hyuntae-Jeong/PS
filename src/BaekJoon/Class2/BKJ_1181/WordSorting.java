package BaekJoon.Class2.BKJ_1181;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;


class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static ArrayList<String> words;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        words = new ArrayList<String>(N);

        getWords();
        sortWords();
        printWords();
    }


    private static void sortWords() {
        words.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() == o2.length()) {
                    return o1.compareTo(o2);
                } /*else if (o1.length() < o2.length()) {
                    return -1;
                } else return 1;*/
                return o1.length() - o2.length();
            }
        });
    }

    public static void getWords() throws IOException {
        String word;
        for (int i = 0; i < N; i++) {
            word = br.readLine();
            if (!words.contains(word)) words.add(word);
        }
    }

    public static void printWords() {
        StringBuilder sb = new StringBuilder();

        for (String word : words) sb.append(word).append("\n");

        System.out.println(sb);
    }
}

public class WordSorting {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/BaekJoon.Class2.BKJ_1181/input.txt"));
        Main.main(args);
    }
}
