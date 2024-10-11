package utility;

import pages.PageObjectManager;
import resources.Base;

import java.io.IOException;

public class TestContextSetup {
    public PageObjectManager pom;
    public Base base;
    public TestContextSetup() throws IOException {
        base = new Base();
        pom = new PageObjectManager(base.initializeDriver());

    }


}
