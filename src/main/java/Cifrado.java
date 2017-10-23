import javax.crypto.*;
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

    public Cifrado(Cipher c, Key k){
        this.aes = c;
        this.key = k;
    }

    public byte[] encriptado(File f) throws Exception{

        String linea;
        String texto = "";

        FileReader fileReader = new FileReader(f);
        BufferedReader buffer = new BufferedReader(fileReader);

        while ((linea = buffer.readLine()) != null){
            texto=texto+linea;
        }

        fileReader.close();
        buffer.close();

        this.aes.init(Cipher.ENCRYPT_MODE, this.key);
        return this.aes.doFinal(texto.getBytes());

    }


    public byte[] desencriptado(byte[] f) throws Exception{

        this.aes.init(Cipher.DECRYPT_MODE, this.key);
        return this.aes.doFinal(f);
    }
}
