import org.testng.annotations.Test;

import java.io.IOException;

public class Testing extends TestBase {
    @Test
    public void test() throws IOException {
        login();
    }
}
