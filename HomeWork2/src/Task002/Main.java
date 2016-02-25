package Task002;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

/**
 * Created by Рустам on 24.02.2016.
 */
public class Main {
    public static void main(String[] args) {
        Result rs = JUnitCore.runClasses(TestMatrix2x2.class);
        for (Failure f : rs.getFailures()){
            System.out.println(f);
        }
    }
}
