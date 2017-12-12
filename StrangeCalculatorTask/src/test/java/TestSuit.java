import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import testsGoogle.CombineGoogleTests;
import testsGoogle.DeductGoogleTests;
import testsGoogle.DevideGoogleTests;
import testsGoogle.MultiplyGoogleTests;
import testsLocal.CombineTests;
import testsLocal.DeductTests;
import testsLocal.DevideTests;
import testsLocal.MultiplyTests;
import testsWeb.CombineWebTests;
import testsWeb.DeductWebTests;
import testsWeb.DevideWebTests;
import testsWeb.MultiplyWebTests;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        CombineTests.class,
        DeductTests.class,
        MultiplyTests.class,
        DevideTests.class,
        CombineGoogleTests.class,
        DeductGoogleTests.class,
        MultiplyGoogleTests.class,
        DevideGoogleTests.class,
        DevideWebTests.class,
        CombineWebTests.class,
        DeductWebTests.class,
        MultiplyWebTests.class
})

public class TestSuit {
}
