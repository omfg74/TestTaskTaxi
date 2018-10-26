package com.omfgdevelop.maximtesttask;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import com.omfgdevelop.maximtesttask.model.Credentials;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        Credentials credentials = new Credentials();
        credentials.setLogin("test_user");
        credentials.setPassword("test_pass");

//        EmployeeRequestInterface employeeRequestInterface = new EmployeeRequest();
//        employeeRequestInterface.getEmoloyees(credentials, appContext);
        assertEquals("com.omfgdevelop.maximtesttask", appContext.getPackageName());
    }
}
