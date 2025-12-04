package BaekJoon.Class2.BKJ_2775;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int tc = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        int floor, room;
        for(int t = 0; t < tc; t++) {
            floor = Integer.parseInt(br.readLine());
            room = Integer.parseInt(br.readLine());

            int[][] apt = new int[floor + 1][room + 1];
            // floor 0 initialization
            for (int i = 1; i <= room; i++) {
                apt[0][i] = i;
            }

            for (int i = 1; i <= floor; i++) {
                for (int j = 1; j <= room; j++) {
                    apt[i][j] = apt[i-1][j] + apt[i][j-1];
                }
            }

            sb.append(apt[floor][room]).append("\n");
        }

        System.out.print(sb);
    }
}

public class WomanPresident {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/BaekJoon.Class2.BKJ_2775/input.txt"));
        Main.main(args);
    }
}
