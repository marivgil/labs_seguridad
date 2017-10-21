import org.junit.Before;
import org.junit.Test;

import java.io.File;

/**
 * Created by maricruz on 07/09/17.
 */
public class TestQuine {

    private Quine quine;
    private File file;

    @Before
    public void setup() {
        this.quine = new Quine();
        this.file = new File("/home/maricruz/git/labs_seguridad_/src/main/java/Quine.java");
    }

    @Test
    public void test_Quine(){

        this.quine.leerArchivoFuente(this.file);

    }
}
