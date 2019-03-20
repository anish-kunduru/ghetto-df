package org.target.recruiting;

import org.junit.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

/**
 * Unit test for simple App.
 */
public class AppTest {

    private  static final String ROOT_DIR = "testDir";
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue() {
        assertTrue(true);
    }

    @Test
    public void testListOfFiles() throws IOException {
        assertSame(2, App.getListOfFiles(getFile(ROOT_DIR + "/sampleDirectory")).size());
    }

    @Test
    public void testNestedListOfFiles() throws IOException {
        assertSame(3, App.getListOfFiles(getFile(ROOT_DIR)).size());
    }

    private File getFile(String directory){
        return new File(getClass().getClassLoader().getResource(directory).getFile());
    }
}
