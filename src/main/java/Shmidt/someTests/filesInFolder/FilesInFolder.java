package Shmidt.someTests.filesInFolder;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class FilesInFolder {
    public static void main(String[] args) throws IOException {
        String path = "C:\\Users\\Алексей\\IdeaProjects\\atSchool_shmidt_as\\src\\Shmidt";
        var lst = Files.walk(Paths.get(path))
                .filter(Files::isRegularFile)
                .collect(Collectors.toList());

        for (var f : lst)
            System.out.println(f.toFile().getName());

    }

    List<String> getAllFileNames(String path) throws IOException {
        var lst = Files.walk(Paths.get(path))
                .filter(Files::isRegularFile)
                .collect(Collectors.toList());

return null;
    }
}
