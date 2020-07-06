package chapter01;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class CountLongWords {

    public static void main(String[] args) throws IOException {
        var contents = new String(Files.readAllBytes(Paths.get("src/main/java/chapter01/CountLongWords.java")), StandardCharsets.UTF_8);
        List<String> words = List.of(contents.split("\\PL+"));
        long count = 0;
        for (String word : words) {
            if (word.length() > 12) {
                count++;
            }
        }
        System.out.println(count);

        count = words.stream().filter(word -> word.length() > 12).count();
        System.out.println(count);

        count = words.parallelStream().filter(w -> w.length() > 12).count();
        System.out.println(count);
    }
}
