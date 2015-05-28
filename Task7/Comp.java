package Task7;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Comp {

    public static Map CompressFile() throws IOException {
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        int value = 0;
        String line = "", result = "";
        Path path = Paths.get("C:\\Users\\Ahmed\\Desktop", "buf.txt");
        try (BufferedReader br = new BufferedReader(new FileReader(path.toString()))) {
            while ((line = br.readLine()) != null) {
                line = line.replaceAll("\\p{Punct}|\\d", "");
                String res[] = line.split(" ");
                result = line;
                for (int i = 0; i < res.length; i++) {
                    if (map.containsKey(res[i]) == false) {
                        String arr[] = result.split(" ");
                        map.put(res[i], value);
                        result = result.replace(arr[i], value + "");
                        value++;
                    }

                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        Files.write(path, result.getBytes());
        return map;
    }

    public static void deCompress(Map map) throws IOException {
        Path path = Paths.get("C:\\Users\\Ahmed\\Desktop", "buf.txt");
        byte bytes[] = Files.readAllBytes(path);
        String content = new String(bytes);
        String fileContent[] = new String[map.size()];
        Set set = map.entrySet();
        Iterator i = set.iterator();
        while (i.hasNext()) {
            Map.Entry me = (Map.Entry) i.next();
            fileContent[(int) me.getValue()] = me.getKey() + "";

        }
        for (int t = 0; t < fileContent.length; t++) {
            if (content.contains(t + "")) {
                content = content.replaceAll(t + "", fileContent[t]);

            }
        }
        Files.write(path,content.getBytes());
    }

    public static void main(String[] args) throws IOException {

        Map map = Comp.CompressFile();
        Comp.deCompress(map);

    }

}
