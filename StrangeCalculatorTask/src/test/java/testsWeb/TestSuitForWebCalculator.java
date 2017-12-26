package testsWeb;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        DevideWebTests.class,
        CombineWebTests.class,
        DeductWebTests.class,
        MultiplyWebTests.class
})
public class TestSuitForWebCalculator {
}
