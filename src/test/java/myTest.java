import drivers.DriverSleep;
import org.junit.Test;
import test.BaseTest;

public class myTest extends BaseTest {

    @Test
    public void sampleTest() {
        System.out.println("xxxx");
        DriverSleep.sleep(3000);
    }
}
