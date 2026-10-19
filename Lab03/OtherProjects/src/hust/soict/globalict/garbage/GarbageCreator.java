package hust.soict.globalict.garbage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Builds a String from a file with the + operator. Every += creates a brand
 * new String and throws the old one away, so a large file produces a huge
 * amount of garbage and the program slows to a crawl.
 *
 * Usage: pass a file path as the first argument (pick a large file, a few MB).
 */
public class GarbageCreator {

    public static void main(String[] args) throws IOException {
        String filename = args.length > 0 ? args[0] : "test.exe";
        byte[] inputBytes = Files.readAllBytes(Paths.get(filename));

        long startTime = System.currentTimeMillis();
        String outputString = "";
        for (byte b : inputBytes) {
            outputString += (char) b;
        }
        long endTime = System.currentTimeMillis();

        System.out.println("Read " + inputBytes.length + " bytes, string length " + outputString.length());
        System.out.println("Time with + operator: " + (endTime - startTime) + " ms");
    }
}
