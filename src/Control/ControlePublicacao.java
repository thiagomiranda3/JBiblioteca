package Control;

import Model.Publicacao;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Vector;

public class ControlePublicacao {

    private Vector arrayPublicacao = new Vector();
    private String[] aDadosForm;
    private Publicacao objPublicacao;

    public ControlePublicacao() throws Exception {
        desserealizaPublicacao();
    }

    private void desserealizaPublicacao() throws Exception {
        File objFile = new File("publicacao.dat");
        if (objFile.exists()) {
            FileInputStream objFileIS = new FileInputStream("publicacao.dat");
            ObjectInputStream objIS = new ObjectInputStream(objFileIS);
            arrayPublicacao = (Vector) objIS.readObject();
            objIS.close();
        }
    }

    private void serealizaPublicacao() throws Exception {
        FileOutputStream objFileOS = new FileOutputStream("publicacao.dat");
        ObjectOutputStream objOS = new ObjectOutputStream(objFileOS);
        objOS.writeObject(arrayPublicacao);
        objOS.flush();
        objOS.close();
    }

    public void finalizar() throws Exception {
        serealizaPublicacao();
    }

    public Vector getArrayPublicacao() {
        return arrayPublicacao;
    }

    public void setArrayPublicacao(Vector arrayPublicacao) {
        this.arrayPublicacao = arrayPublicacao;
    }
}
