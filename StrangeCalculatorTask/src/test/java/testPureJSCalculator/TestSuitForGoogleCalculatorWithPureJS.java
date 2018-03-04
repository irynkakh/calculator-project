package testPureJSCalculator;


import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        CombineGoogleCalculatorWithPureJSTests.class,
        DeductGoogleCalculatorWithPureJSTests.class,
        MultiplyGoogleCalculatorWithPureJSTests.class,
        DevideGoogleCalculatorWithPureJSTests.class,
})
public class TestSuitForGoogleCalculatorWithPureJS {
}
