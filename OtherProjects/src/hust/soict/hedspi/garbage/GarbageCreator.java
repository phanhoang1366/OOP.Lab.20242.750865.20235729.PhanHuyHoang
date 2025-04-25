package hust.soict.hedspi.garbage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class GarbageCreator {
    public static void main(String[] args) throws IOException {
        // Create test.bin using the following command:
        // $ dd if=/dev/random of=test.bin bs=1 count=1048576
        String fileName = "test.bin";
        byte[] inputBytes = { 0 };
        long startTime, endTime;

        inputBytes = Files.readAllBytes(Paths.get(fileName));
        startTime = System.currentTimeMillis();
        String outputString = "";
        for (byte b : inputBytes) {
            outputString += b;
        }
        endTime = System.currentTimeMillis();
        System.out.println("Time taken to concatenate strings: " + (endTime - startTime) + " ms");
    }
}
