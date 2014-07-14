package Control;

import Model.Emprestimo;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Date;
import java.util.Vector;

public class ControleEmprestimo {

    private ControlePrincipal objCtrPrincipal;
    private Vector aDadosForm, arrayEmprestimo = new Vector();
    private Emprestimo objEmprestimo;

    public ControleEmprestimo(ControlePrincipal ctrPrincipal) throws Exception {
        objCtrPrincipal = ctrPrincipal;
        desserealizaEmprestimo();
    }
    
    private void desserealizaEmprestimo() throws Exception {
        File objFile = new File("emprestimos.dat");
        if (objFile.exists()) {
            FileInputStream objFileIS = new FileInputStream("emprestimos.dat");
            ObjectInputStream objIS = new ObjectInputStream(objFileIS);
            arrayEmprestimo = (Vector) objIS.readObject();
            objIS.close();
        }
    }

    private void serealizaEmprestimo() throws Exception {
        FileOutputStream objFileOS = new FileOutputStream("emprestimos.dat");
        ObjectOutputStream objOS = new ObjectOutputStream(objFileOS);
        objOS.writeObject(arrayEmprestimo);
        objOS.flush();
        objOS.close();
    }

    public Vector getArrayEmprestimo() {
        return arrayEmprestimo;
    }

    public void setArrayEmprestimo(Vector arrayEmprestimo) {
        this.arrayEmprestimo = arrayEmprestimo;
    }

    public void finalizar() throws Exception {
        serealizaEmprestimo();
    }
}
