package Task7;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Compress {
    public static String compress(Path filePath) throws IOException {

        List map = new ArrayList();
        byte bytes[] = Files.readAllBytes(filePath);
        String stamp = new String(bytes);
        String result = stamp;
        stamp = stamp.replaceAll("\\p{Punct}|\\d", "");
        String[] str = stamp.split(" ");
        int value = 0;
        for (int i = 0; i < str.length; i++) {
           if (map.contains(str[i]) == false) {
                map.add(str[i]);
                String array[] = stamp.split(" ");
                stamp = stamp.replaceAll(array[i], value + "");
                value++;
            }

        }

        Files.write(filePath, stamp.getBytes());
        return result;
    }

    public static void main(String[] args) throws IOException {
        String map = "";
        Path path = Paths.get("C:\\Users\\Ahmed\\Desktop", "buf.txt");
        map = Compress.compress(path);

        Compress.deCompress(map, path);

    }

    public static void deCompress(String result, Path path) throws IOException {
        Files.write(path, result.getBytes());

    }
}
