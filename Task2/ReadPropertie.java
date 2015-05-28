package Task2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReadPropertie {

    public static void main(String[] args) {
        System.out.println(parseProperties());

    }

    public static Map<String, String> parseProperties() {
        List<String> list = new ArrayList<String>();
        String line = "";
        int i = 0;
        try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Ahmed\\Desktop\\mekliov.txt"))) {
            while ((line = br.readLine()) != null) {

                list.add(i, line);
                i++;

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        String res = "";
        HashMap<String, String> map = new HashMap<String, String>();
        for (String a : list) {

            if (a.startsWith("#") != true) {
                String key = a.substring(0, a.indexOf("="));
                String value = a.substring(a.indexOf("=") + 1);
                map.put(key, value);

            }
        }
        return map;
    }
}
