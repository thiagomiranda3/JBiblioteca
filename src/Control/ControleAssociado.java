package Control;

import Model.Associado;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Vector;

public class ControleAssociado {

    private Vector arrayAssociados = new Vector();
    private String[] aDadosForm;
    private Associado objAssociado;

    public ControleAssociado() throws Exception {
        desserealizaAssociado();
    }

    private void desserealizaAssociado() throws Exception {
        File objFile = new File("associados.dat");
        if (objFile.exists()) {
            FileInputStream objFileIS = new FileInputStream("associados.dat");
            ObjectInputStream objIS = new ObjectInputStream(objFileIS);
            arrayAssociados = (Vector) objIS.readObject();
            objIS.close();
        }
    }

    private void serealizaAssociado() throws Exception {
        FileOutputStream objFileOS = new FileOutputStream("associados.dat");
        ObjectOutputStream objOS = new ObjectOutputStream(objFileOS);
        objOS.writeObject(arrayAssociados);
        objOS.flush();
        objOS.close();
    }

    public void finalizar() throws Exception {
        serealizaAssociado();
    }

    public Vector getArrayAssociados() {
        return arrayAssociados;
    }

    public void setArrayAssociados(Vector arrayAssociados) {
        this.arrayAssociados = arrayAssociados;
    }
}
