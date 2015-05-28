package Task3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class WordCountResult {
    static int line;
    static int symbol;
    static int word;

    WordCountResult() {
    }

    WordCountResult(int l, int s, int w) {
        this.line = l;
        this.symbol = s;
        this.word = w;
    }

    WordCountResult wordCount(File file) {
        int lCount = 0, sCount = 0, wCount = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            while (br.readLine() != null) {
                lCount++;

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            while (br.read() != -1) {
                sCount++;

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try (Scanner sc = new Scanner(new BufferedReader(new FileReader(file)))) {
            while (sc.hasNext()) {
                sc.next();
                wCount++;

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new WordCountResult(lCount, sCount, wCount);

    }

}
