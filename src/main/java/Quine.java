/**
 * Created by maricruz on 07/09/17.
 */
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Quine {

    private FileReader fileReader;
    private String contenidoArchivoFuente = "";
    private BufferedReader buffer;

    public Quine(){}

    public String leerArchivoFuente(File archivo){

        File archivoFuente = archivo;
        String linea = "";

        try {

            this.fileReader = new FileReader(archivoFuente);
            this.buffer= new BufferedReader(this.fileReader);

            while ((linea = this.buffer.readLine()) != null){
                System.out.println(linea);
            }

            this.fileReader.close();
            this.buffer.close();

        }catch (Exception e){
            System.out.println("Opss... algo salio mal :S");
            //throw new Exception(e.getMessage());
        }
        return contenidoArchivoFuente;
    }

}
