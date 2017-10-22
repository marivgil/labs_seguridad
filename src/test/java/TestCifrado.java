import org.junit.Before;
import org.junit.Test;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.File;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;


/**
 * Created by maricruz on 21/10/17.
 */
public class TestCifrado {

    private Cifrado cipher;
    private Cipher aes;
    private File file;

    @Before
    public void setup() throws NoSuchPaddingException, NoSuchAlgorithmException {
        this.cipher = new Cifrado();
        this.aes = Cipher.getInstance("AES/ECB/PKCS5Padding");
        //elijo el archivo a cifrar de manera arbitraria
        this.file = new File("/home/maricruz/git/labs_seguridad_/README.md");
    }

    @Test
    public void encriptado() throws IllegalBlockSizeException,
            BadPaddingException, NoSuchAlgorithmException, InvalidKeyException {

        byte[] encriptado = this.cipher.encriptado(this.aes, this.file);

        //imprimo el texto cifrado
        for (byte b : encriptado) {
            System.out.print(Integer.toHexString(0xFF & b));
        }
    }

    @Test
    public void desencriptado() throws IllegalBlockSizeException,
            BadPaddingException, NoSuchAlgorithmException, InvalidKeyException {

        byte[] encriptado = this.cipher.encriptado(this.aes, this.file);

        byte[] desencriptado = this.cipher.desencriptado(this.aes, encriptado);

        //imprimo el texto cifrado
        for (byte b : desencriptado) {
            System.out.print(Integer.toHexString(0xFF & b));
        }
    }
}
