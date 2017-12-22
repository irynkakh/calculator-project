package testsLocal;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        CombineTests.class,
        DeductTests.class,
        MultiplyTests.class,
        DevideTests.class,
})

public class TestSuitForLocalCalculator {
}
