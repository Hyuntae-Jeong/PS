package BKJ_2798;

import java.io.*;
import java.util.StringTokenizer;

class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, M, cardCount = 0, max = -1;
    static int[] cards;

    public static StringTokenizer tokenize(String input){
        return new StringTokenizer(input);
    }

    public static void main(String[] args) throws IOException {
        StringTokenizer token = tokenize(br.readLine());

        N = Integer.parseInt(token.nextToken());
        M = Integer.parseInt(token.nextToken());

        readCards();

        System.out.print(findBlackJack());
    }

    public static void readCards() throws IOException {
        StringTokenizer token = tokenize(br.readLine());
        cards = new int[N];
        int card;

        while (token.hasMoreTokens()) {
            card = Integer.parseInt(token.nextToken());
            if (card < M) cards[cardCount++] = card;
        }
    }

    public static int findBlackJack() {
        int i, j, k, sum;

        for (i = 0; i < cardCount - 2; i++) {
            sum = cards[i];
            
            for (j = i + 1; j < cardCount - 1; j++) {
                if (sum + cards[j] >= M) continue;
                sum += cards[j];

                for (k = j + 1; k < cardCount; k++) {
                    sum += cards[k];

                    if (sum <= M && sum > max){
                        max = sum;
                        if (max == M) return max;
                    }

                    sum -= cards[k];
                }
                sum -= cards[j];
            }
        }

        return max;
    }
}


public class Blackjack {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/BKJ_2798/input.txt"));
        Main.main(args);
    }
}
