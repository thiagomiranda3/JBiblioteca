
package Model;

import java.io.Serializable;
import java.util.Date;

public class Emprestimo implements Serializable {
    String numExemplar, isbn, codAssociado;
    Date data;

    public String getNumExemplar() {
        return numExemplar;
    }

    public void setNumExemplar(String numExemplar) {
        this.numExemplar = numExemplar;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getCodAssociado() {
        return codAssociado;
    }

    public void setCodAssociado(String codAssociado) {
        this.codAssociado = codAssociado;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }
}
