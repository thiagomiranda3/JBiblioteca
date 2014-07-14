package Control;

import View.LimitePrincipal;

public class ControlePrincipal {

    LimitePrincipal objLimPrincipal;
    ControleAssociado objCtrAssociado;
    ControleEmprestimo objCtrEmprestimo;
    ControleExemplar objCtrExemplar;
    ControlePublicacao objCtrPublicacao;

    public ControleAssociado getObjCtrAssociado() {
        return objCtrAssociado;
    }

    public ControleEmprestimo getObjCtrEmprestimo() {
        return objCtrEmprestimo;
    }

    public ControleExemplar getObjCtrExemplar() {
        return objCtrExemplar;
    }

    public ControlePublicacao getObjCtrPublicacao() {
        return objCtrPublicacao;
    }

    public ControlePrincipal() {
        try {
            objCtrAssociado = new ControleAssociado();
            objCtrExemplar = new ControleExemplar(this);
            objCtrPublicacao = new ControlePublicacao();
            objCtrEmprestimo = new ControleEmprestimo(this);
        } catch (Exception e) {
            System.out.println("Erro na abertura de arquivo!");
        }
    }

    public void inicio() {
        objLimPrincipal = new LimitePrincipal(this);
        objLimPrincipal.janela();
    }

}
