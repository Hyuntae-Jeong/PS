package BKJ_2753;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int year;

    public static void main(String[] args) throws IOException {
        year = Integer.parseInt(br.readLine());

        if (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0)) System.out.print("1");
        else System.out.print("0");
    }
}

public class LeapYear {
    public static void main(String[] args) throws IOException {
        Main.main(args);
    }
}
