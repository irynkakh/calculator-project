package testsGoogle;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        CombineGoogleTests.class,
        DeductGoogleTests.class,
        MultiplyGoogleTests.class,
        DevideGoogleTests.class
})

public class TestSuitForGoogleCalculator {
}

