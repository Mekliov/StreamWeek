package Task4;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Encoding {
    public static void fixEncoding(Path path) throws IOException {
        byte[] result = Files.readAllBytes(path);
        FileOutputStream fos= new FileOutputStream("C:\\Users\\Ahmed\\Desktop\\dest.txt");
        String stamp= new String(result,"Windows-1251");
        File fi= new File("C:\\Users\\Ahmed\\Desktop\\vest.txt");
        if(!fi.exists())
        {
            fi.createNewFile();
        }
        BufferedWriter br= new BufferedWriter(new FileWriter(fi));
        br.write(stamp);
      
       
        }
      
    

    public static void main(String[] args) throws IOException {
        Path path = Paths.get("C:\\Users\\Ahmed\\Desktop", "lost.s04e11.hdtv.xvid-2hd.srt");
        Encoding.fixEncoding(path);
    }
}
