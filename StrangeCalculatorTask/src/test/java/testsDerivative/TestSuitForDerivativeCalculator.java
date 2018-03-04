package testsDerivative;


import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        CombineDerivativeTests.class,
        DeductDerivativeTests.class,
        MultiplyDerivativeTests.class,
})

public class TestSuitForDerivativeCalculator {
}
