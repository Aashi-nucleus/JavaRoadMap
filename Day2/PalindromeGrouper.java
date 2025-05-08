package JavaRoadmap.Day2;
import java.io.IOException;
import java.nio.file.*;
import java.util.*;
import java.util.function.*;
import java.util.stream.*;

public class PalindromeGrouper {

    @FunctionalInterface
    interface PalindromeChecker {
        boolean isPalindrome(String word);
    }

    public static Map<Integer, List<String>> groupPalindromesByLength(Path filePath) throws IOException {
        Function<String, String> toLowerCase = String::toLowerCase;
        PalindromeChecker checker = word -> word.equals(new StringBuilder(word).reverse().toString());

        try (Stream<String> lines = Files.lines(filePath)) {
            return lines
                .map(String::trim)
                .map(toLowerCase)
                .filter(word -> word.length() > 1) 
                .filter(checker::isPalindrome)
                .distinct()
                .sorted()
                .collect(Collectors.groupingBy(
                    String::length,
                    TreeMap::new, 
                    Collectors.toList()
                ));
        }
    }

    public static void main(String[] args) throws IOException {
        Path path = Paths.get("words.txt"); 
        Map<Integer, List<String>> result = groupPalindromesByLength(path);

        result.forEach((length, palindromes) -> {
            System.out.println("Length " + length + ": " + palindromes);
        });
    }
}
