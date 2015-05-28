package Task1;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class MainTask1 {

    public static void main(String[] args) throws IOException {
        Path path= Paths.get("");
        File file = new File("");
        System.out.println( FileUtils.instance.readFrom(file));
        File file1 = new File("");
        if(!file1.exists())
        {
            file.createNewFile();
        }
        FileUtils.instance.writeFrom(file1);
         System.out.println(FileUtils.instance.readFrom(path));
        
    }

}
