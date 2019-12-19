package helpers;

import objects.MSG;
import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;
import test.BaseTest;
import utils.Log;

import java.util.Arrays;
import java.util.List;

/*
JUnit rule for relaunching test if it was failed by defined list of reasons
 */
public class RetryRule implements TestRule {

    private List<Class> exceptionClasses;
    private int attempts;

    public RetryRule(Class... exceptionsClasses) {
        this.exceptionClasses = Arrays.asList(exceptionsClasses);
        this.attempts = BaseTest.retryCount;
    }

    public Statement apply(final Statement base, final Description description) {
        return new Statement() {
            @Override
            public void evaluate() throws Throwable {
                Throwable e = null;
                for (int i = 0; i <= attempts; i++) {
                    try {
                        base.evaluate();
                        return;
                    } catch (Throwable t) {
                        if (i <= attempts - 1) {
                            Log.sysLog(MSG.RULE_RESTART_TEST, i + 1);
                        }
                        e = t;
                        if (!isContainsThrowable(e)) {
                            throw e;
                        }
                    }
                }
                throw e;
            }
        };
    }

    private boolean isContainsThrowable(Throwable t) {
        for (Class clazz : exceptionClasses) {
            if (t.getClass().equals(clazz)) {
                return true;
            }
        }
        return false;
    }
}
