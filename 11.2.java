
import java.nio.file.*;
import java.nio.file.attribute.*;
import java.io.*;
import java.util.*;

 class LogAnalyzer {
    public static void main(String[] args) throws IOException {
        String[] files = {"log1.txt", "log2.txt", "log3.txt"};
        String keyword = "ERROR";
        int totalLines = 0, matches = 0;

        Files.write(Path.of(files[0]), Arrays.asList("INFO Started", "ERROR Failed"));
        Files.write(Path.of(files[1]), Arrays.asList("INFO Running", "ERROR Timeout"));
        Files.write(Path.of(files[2]), Arrays.asList("INFO Completed", "INFO Closed"));

        for (String file : files) {
            Path path = Path.of(file);
            int lines = 0;

            try (BufferedReader br = Files.newBufferedReader(path)) {
                String line;

                while ((line = br.readLine()) != null) {
                    lines++;
                    totalLines++;

                    if (line.contains(keyword))
                        matches++;
                }
            }

            BasicFileAttributes attr =
                    Files.readAttributes(path, BasicFileAttributes.class);

            System.out.println(file + " size: " + attr.size() + " bytes");
            System.out.println(file + " lines: " + lines);
        }

        System.out.println("Total lines: " + totalLines);
        System.out.println("Lines containing " + keyword + ": " + matches);
    }
}
