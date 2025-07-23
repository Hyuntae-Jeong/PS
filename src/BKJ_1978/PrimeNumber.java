package BKJ_1978;

import java.io.*;
import java.util.StringTokenizer;

class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[] primeNumbers = new int[1001];

    public static StringTokenizer tokenize(String input){
        return new StringTokenizer(input);
    }

    public static void main(String[] args) throws IOException {
        StringTokenizer token = tokenize(br.readLine());
        int N = Integer.parseInt(token.nextToken());           // count(N) <= 100, N <= 1000

        getPrimeNumberList();
        int result = countPrimeNumbers();

        System.out.println(result);
    }

    public static void getPrimeNumberList(){
        primeNumbers[1] = 1;

        for (int i = 2; i <= 1000; i++){
            if (primeNumbers[i] == 0) {
                for (int j = i + i; j <= 1000; j += i){
                    primeNumbers[j]++;
                }
            }
        }
    }

    public static int countPrimeNumbers() throws IOException {
        StringTokenizer token = tokenize(br.readLine());

        int result = 0;
        while (token.hasMoreTokens()) {
            if (primeNumbers[Integer.parseInt(token.nextToken())] == 0) {
                result++;
            }
        }

        return result;
    }
}

public class PrimeNumber {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/BKJ_1978/input.txt"));
        Main.main(args);
    }
}
