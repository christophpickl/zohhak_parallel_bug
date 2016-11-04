package pickl;

import com.googlecode.zohhak.api.TestWith;
import com.googlecode.zohhak.api.runners.ZohhakRunner;
import org.junit.runner.RunWith;

@RunWith(ZohhakRunner.class)
public class ZohhakParallelBugTest {

    // removing the linefeed (\n) will make the build pass again!
    //    @TestWith(value = {"foobar"})
    @TestWith(value = {"foo\nbar"})
    public void testMethod(String value) { }

}
