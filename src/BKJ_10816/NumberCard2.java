package BKJ_10816;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, M, RANGE = 10_000_000, SIZE = 20_000_001;
    static int[] counts = new int[SIZE];
    
    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        initializeCounts();
        
        M = Integer.parseInt(br.readLine());
        printCounts();
    }
    
    public static void initializeCounts() throws IOException {
        StringTokenizer token = new StringTokenizer(br.readLine());
        
        for (int i = 0; i < N; i++)
            counts[Integer.parseInt(token.nextToken()) + RANGE]++;
    }
    
    public static void printCounts() throws IOException {
        StringTokenizer token = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < M; i++)
            sb.append(counts[Integer.parseInt(token.nextToken()) + RANGE]).append(" ");
        
        System.out.println(sb);
    }
}

public class NumberCard2 {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/BKJ_10816/input.txt"));
        Main.main(args);
    }
}
