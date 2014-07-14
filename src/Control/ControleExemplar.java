package Control;

import Model.Exemplar;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Vector;

public class ControleExemplar {

    private Vector arrayExemplar = new Vector();
    private ControlePrincipal objCtrPrincipal;
    private String[] aDadosForm;
    private Exemplar objExemplar;

    public ControleExemplar(ControlePrincipal ctrPrincipal) throws Exception {
        objCtrPrincipal = ctrPrincipal;
        desserealizaExemplar();
    }

    private void desserealizaExemplar() throws Exception {
        File objFile = new File("exemplar.dat");
        if (objFile.exists()) {
            FileInputStream objFileIS = new FileInputStream("exemplar.dat");
            ObjectInputStream objIS = new ObjectInputStream(objFileIS);
            arrayExemplar = (Vector) objIS.readObject();
            objIS.close();
        }
    }

    private void serealizaExemplar() throws Exception {
        FileOutputStream objFileOS = new FileOutputStream("exemplar.dat");
        ObjectOutputStream objOS = new ObjectOutputStream(objFileOS);
        objOS.writeObject(arrayExemplar);
        objOS.flush();
        objOS.close();
    }

    public void finalizar() throws Exception {
        serealizaExemplar();
    }

    public Vector getArrayExemplar() {
        return arrayExemplar;
    }

    public void setArrayExemplar(Vector arrayExemplar) {
        this.arrayExemplar = arrayExemplar;
    }
}
