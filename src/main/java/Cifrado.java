import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import java.io.File;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;

/**
 * Created by maricruz on 21/10/17.
 */
public class Cifrado {

    private Cipher aes;
    private Key key;

    /**
     *
     * @param c cipher
     * @param f archivo a cifrar
     * @return
     * @throws InvalidKeyException
     * @throws NoSuchAlgorithmException
     * @throws BadPaddingException
     * @throws IllegalBlockSizeException
     */
    public byte[] encriptado(Cipher c, File f) throws InvalidKeyException, NoSuchAlgorithmException,
            BadPaddingException, IllegalBlockSizeException {

        this.aes = c;

        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
        keyGenerator.init(128);
        this.key = keyGenerator.generateKey();

        //ENCRYPT_MODE = 1
        this.aes.init(Cipher.ENCRYPT_MODE, this.key);
        byte[] getBytes = new byte[(int) f.length()];
        return this.aes.doFinal(getBytes);
    }

    /**
     *
     * @param c
     * @param f
     * @return
     * @throws InvalidKeyException
     * @throws BadPaddingException
     * @throws IllegalBlockSizeException
     * @throws NoSuchAlgorithmException
     */
    public byte[] desencriptado(Cipher c, byte[] f) throws InvalidKeyException, BadPaddingException,
            IllegalBlockSizeException, NoSuchAlgorithmException {

            this.aes = c;

            //DECRYPT_MODE = 2
            this.aes.init(Cipher.DECRYPT_MODE, this.key);
            return this.aes.doFinal(f);

    }
}
