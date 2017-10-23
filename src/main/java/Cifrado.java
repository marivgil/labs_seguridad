import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.security.Key;


/**
 * Created by maricruz on 21/10/17.
 */
public class Cifrado {

    private Cipher aes;
    private Key key;
    private Quine quine;
    private FileReader fileReader;
    private String contenidoArchivoFuente = "";
    private BufferedReader buffer;

    public Cifrado(){}

    public byte[] encriptado(Cipher c, File f) throws Exception{

        this.aes = c;
        this.key = new SecretKeySpec("una clave de 16 bytes".getBytes(),  0, 16, "AES");

        //ENCRYPT_MODE = 1
        this.aes.init(Cipher.ENCRYPT_MODE, this.key);

        String linea = "";
        String str = "";

            this.fileReader = new FileReader(f);
            this.buffer= new BufferedReader(this.fileReader);

            while ((linea = this.buffer.readLine()) != null){
                str.concat(linea);
            }

            this.fileReader.close();
            this.buffer.close();

        byte[] getBytes = new byte[str.length()];

        return this.aes.doFinal(getBytes);
    }


    public byte[] desencriptado(Cipher c, byte[] f) throws Exception{
            this.aes = c;
            //DECRYPT_MODE = 2
            this.aes.init(Cipher.DECRYPT_MODE, this.key);
            return this.aes.doFinal(f);

    }
}
