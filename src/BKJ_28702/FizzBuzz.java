package BKJ_28702;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int number = 1, index = 1;

        for (int i = 0; i < 3; i++) {
            String word = br.readLine();

            switch(word) {
                case "FizzBuzz":
                case "Fizz":
                case "Buzz":
                    break;
                default:
                    number = Integer.parseInt(word);
                    index = i;
                    break;
            }
        }

        int resultNum = number + (3 - index);
        if (resultNum % 15 == 0) {
            System.out.print("FizzBuzz");
        } else if (resultNum % 3 == 0) {
            System.out.print("Fizz");
        } else if (resultNum % 5 == 0) {
            System.out.print("Buzz");
        } else {
            System.out.print(resultNum);
        }
    }
}

public class FizzBuzz {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/BKJ_28702/input.txt"));
        Main.main(args);
    }
}
