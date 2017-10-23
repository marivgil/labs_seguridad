import org.junit.Before;
import org.junit.Test;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.io.File;
import java.security.Key;


/**
 * Created by maricruz on 21/10/17.
 */
public class TestCifrado {

    private Cifrado cifrado;
    private Cipher aes;
    private File file;
    private Key key;

    @Before
    public void setup() throws Exception{
        this.aes = Cipher.getInstance("AES/ECB/PKCS5Padding");
        //elijo el archivo a cifrar de manera arbitraria
        this.file = new File("/home/maricruz/git/labs_seguridad_/HolaMundo.txt");
        this.key = new SecretKeySpec("una clave de 16 bytes".getBytes(),  0, 16, "AES");
        this.cifrado = new Cifrado(this.aes, this.key);
    }

    @Test
    public void encriptado() throws Exception{
        this.cifrado.encriptado(this.file);
    }

    @Test
    public void desencriptado() throws Exception {
        byte[] enc = this.cifrado.encriptado(this.file);
        this.cifrado.desencriptado(enc);

    }
}
