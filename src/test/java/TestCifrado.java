import org.junit.Before;
import org.junit.Test;

import javax.crypto.Cipher;
import java.io.File;


/**
 * Created by maricruz on 21/10/17.
 */
public class TestCifrado {

    private Cifrado cifrado;
    private Cipher aes;
    private File file;

    @Before
    public void setup() throws Exception{
        this.cifrado = new Cifrado();
        this.aes = Cipher.getInstance("AES/ECB/PKCS5Padding");
        //elijo el archivo a cifrar de manera arbitraria
        this.file = new File("/home/maricruz/git/labs_seguridad_/HolaMundo.txt");
    }

    @Test
    public void encriptado() throws Exception{

        byte[] encriptado = this.cifrado.encriptado(this.aes, this.file);

        //imprimo el texto cifrado
        for (byte b : encriptado) {
            System.out.print(Integer.toHexString(0xFF & b));
        }
    }

    @Test
    public void desencriptado() throws Exception {

        byte[] encriptado = this.cifrado.encriptado(this.aes, this.file);

        byte[] desencriptado = this.cifrado.desencriptado(this.aes, encriptado);

        //imprimo el texto cifrado
        System.out.println(new String(desencriptado));

    }
}
