package org.psuedoRandomNumGenerator;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.concurrent.ThreadLocalRandom;
import java.util.TimerTask;

/* PsuedoRandomLong 64-bit Genarator
*       Creates a secret random Long that will be a part of generating a Server Cookie
 */

public class PsuedoRandomLongGenarator extends TimerTask {

    public Long serverPsuedoRandNumber;
    public String fileName;
    public PsuedoRandomLongGenerator(){
        serverPsuedoRandNumber = ThreadLocalRandom.current().nextLong();

        fileName = "/var/log/serverSecret.txt";

        try {
            FileWriter fileWriter = new FileWriter(fileName);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            bufferedWriter.write(Long.toUnsignedString(serverPsuedoRandNumber));
            bufferedWriter.close();
        }
        catch(IOException e) {
            System.out.println("Error Writing to file: " + fileName);
        }
    }

    @Override
    public void run() {

        // Generate a Psuedo-random 64bit number
        serverPsuedoRandNumber =
                ThreadLocalRandom.current().nextLong();


        try {
            FileWriter fileWriter = new FileWriter(fileName);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            bufferedWriter.write(Long.toUnsignedString(serverPsuedoRandNumber));
            bufferedWriter.close();
        }
        catch(IOException e) {
            System.out.println("Error Writing to file: " + fileName);
        }
    }
}
