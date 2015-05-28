package Task1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;

public class FileUtils {
    static FileUtils instance = null;

    public static FileUtils getInstance() {
        if (instance == null) {
            instance = new FileUtils();
        }
        return instance;
    }

    private FileUtils() {

    }

    public static String readFrom(File path) {
        StringBuilder sb = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            while (br.readLine() != null) {
                sb.append(br.readLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return sb.toString();

    }

    public static void writeFrom(File file) {

        String message = "new File was Craeted";
        try (BufferedWriter br = new BufferedWriter(new FileWriter(file))) {
            br.write(message);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static String readFrom(Path path) {
        StringBuilder sb = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(path.toString()))) {
            while (br.readLine() != null) {
                sb.append(br.readLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return sb.toString();

    }
}
