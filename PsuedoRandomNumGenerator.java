package org.psuedoRandomNumGenerator;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.concurrent.ThreadLocalRandom;

/* PsuedoRandomLong 64-bit Genarator
*       Creates a secret random Long that will be a part of generating a Server Cookie
 */

public class PsuedoRandomLongGenarator{

    public static void main(String[] args) {

        // Generate a Psuedo-random 64bit number
        Long serverPsuedoRandNumber =
                ThreadLocalRandom.current().nextLong();

        // Send rand num to serverSecret.txt file
        String fileName = "serverSecret.txt";

        try {
            FileWriter fileWriter = new FileWriter(fileName);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            bufferedWriter.write(Long.toUnsignedString(serverPsuedoRandNumber));
            bufferedWriter.close();
        }
        catch(IOException e) {
            System.out.println("Error Writing to file: " + fileName);
        }
        System.exit(0);
    }
}
