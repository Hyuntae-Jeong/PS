package BKJ_2920;

import java.io.*;
import java.util.StringTokenizer;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        StringTokenizer token = new StringTokenizer(br.readLine());
        int firstInput = Integer.parseInt(token.nextToken());
        if (firstInput != 1 && firstInput != 8) {
            System.out.print("mixed");
            return;
        }

        if (firstInput == 1) {
            for (int i = 2; i <= 8;  i++){
                if (Integer.parseInt(token.nextToken()) != i) {
                    System.out.print("mixed");
                    return;
                }
            }
            System.out.print("ascending");
        } else if (firstInput == 8) {
            for (int i = 7; i >= 1; i --){
                if (Integer.parseInt(token.nextToken()) != i) {
                    System.out.print("mixed");
                    return;
                }
            }
            System.out.print("descending");
        }
    }
}

public class MusicalScale {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/BKJ_2920/input.txt"));
        Main.main(args);
    }
}
