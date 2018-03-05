import java.util.Timer;
public class Main {
    public static void main(String[] args) {
        Timer t  = new Timer();
        PsuedoRandomLongGenerator randomNumber = new PsuedoRandomLongGenerator();
        t.scheduleAtFixedRate(randomNumber, 0, 5000);


    }
}
