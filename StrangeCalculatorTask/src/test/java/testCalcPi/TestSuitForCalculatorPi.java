package testCalcPi;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        CombinePiTests.class,
        DeductPiTests.class,
        MultiplyPiTests.class,
        DevidePiTests.class
})
public class TestSuitForCalculatorPi {
}
