package BaekJoon.Class1.BKJ_2884;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        StringTokenizer token = new StringTokenizer(br.readLine());
        int hour = Integer.parseInt(token.nextToken());
        int minute = Integer.parseInt(token.nextToken());

        minute -= 45;
        if (minute < 0) {
            minute += 60;
            hour -= 1;
            if (hour < 0) {
                hour += 24;
            }
        }
        System.out.printf("%d %d", hour, minute);
    }
}

public class AlarmClock {
    public static void main(String[] args) throws IOException {
        Main.main(args);
    }
}
