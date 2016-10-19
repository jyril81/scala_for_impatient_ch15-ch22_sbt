package ch15.five;

import java.io.IOException;

public class LinesDriver {
    public static void main(String[] args) {
        readLines("C:\\Users\\jyril\\git\\scala_for_impatient_ch15-ch22_sbt\\src\\main\\resources\\data.txt");

    }

    private static void readLines(String s) {
        try {
            System.out.println(Lines.lines(s));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
