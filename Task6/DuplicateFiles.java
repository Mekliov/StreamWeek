package Task6;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class DuplicateFiles {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get("C:\\Users\\Ahmed\\Desktop");
        File file = path.toFile();
        File[] directory = file.listFiles();
        for (File filesInDirectory : directory) {
            if (filesInDirectory.isFile()) {
                if (Files.isSymbolicLink(filesInDirectory.toPath())) {
                    if (Files.readSymbolicLink(filesInDirectory.toPath()) != null) {
                        System.out.println(Files.readSymbolicLink(filesInDirectory.toPath()));
                    }
                }

            }
        }
    }

}
