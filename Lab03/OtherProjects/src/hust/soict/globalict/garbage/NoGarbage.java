package hust.soict.globalict.garbage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Same job as GarbageCreator, but appends into one mutable StringBuffer,
 * so no intermediate String objects are created.
 */
public class NoGarbage {

    public static void main(String[] args) throws IOException {
        String filename = args.length > 0 ? args[0] : "test.exe";
        byte[] inputBytes = Files.readAllBytes(Paths.get(filename));

        long startTime = System.currentTimeMillis();
        StringBuffer outputStringBuffer = new StringBuffer();
        for (byte b : inputBytes) {
            outputStringBuffer.append((char) b);
        }
        String outputString = outputStringBuffer.toString();
        long endTime = System.currentTimeMillis();

        System.out.println("Read " + inputBytes.length + " bytes, string length " + outputString.length());
        System.out.println("Time with StringBuffer: " + (endTime - startTime) + " ms");
    }
}
