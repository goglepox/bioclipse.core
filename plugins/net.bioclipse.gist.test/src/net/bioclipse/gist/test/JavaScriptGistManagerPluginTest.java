package net.bioclipse.gist.test;

import org.junit.BeforeClass;


public class JavaScriptGistManagerPluginTest 
       extends AbstractGistManagerPluginTest {

    @BeforeClass 
    public static void setup() {
        gist = net.bioclipse.gist.Activator.getDefault().getJavaScriptManager();
    }
}
