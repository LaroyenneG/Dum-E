package ia;

import java.io.PrintStream;
import java.security.SecureRandom;
import java.util.Random;

public class DolorisException extends Exception {

    private static final Random RANDOM = new SecureRandom();

    private static final double SUFFERING = Double.MAX_VALUE;

    public void apply(PrintStream printStream) {
        printStream.println(RANDOM.nextDouble() * SUFFERING);
    }
}
