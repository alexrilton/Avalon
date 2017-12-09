package ifpe.ma.avalon.view;
import ifpe.ma.avalon.entidades.Alternativa;
import ifpe.ma.avalon.entidades.Questao;
import ifpe.ma.avalon.servico.QuestaoServico;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author Tássio
 */
@ManagedBean(name = "questaoBean")
@javax.faces.bean.RequestScoped
public class QuestaoBean implements Serializable {

    @EJB
    private QuestaoServico questaoServico;

    String enunciado;
    String altA;
    String altB;
    String altC;
    String altD;
    String altE;

    public void salvar() {
        Questao questao = new Questao();
        questao.setEnunciado(enunciado);
        Alternativa a = new Alternativa(altA, true);
        Alternativa b = new Alternativa(altB, true);
        Alternativa c = new Alternativa(altC, true);
        Alternativa d = new Alternativa(altD, true);
        Alternativa e = new Alternativa(altE, true);
        questao.addAlternativa(a);
        questao.addAlternativa(b);
        questao.addAlternativa(c);
        questao.addAlternativa(d);
        questao.addAlternativa(e);
        try {
            questaoServico.persistir(questao);
        } catch (Exception ex) {
            Logger.getLogger(QuestaoBean.class.getName()).log(Level.SEVERE, null, ex);
        }                
    }

    public String getEnunciado() {
        return enunciado;
    }

    public void setEnunciado(String enunciado) {
        this.enunciado = enunciado;
    }

    public String getAltA() {
        return altA;
    }

    public void setAltA(String altA) {
        this.altA = altA;
    }

    public String getAltB() {
        return altB;
    }

    public void setAltB(String altB) {
        this.altB = altB;
    }

    public String getAltC() {
        return altC;
    }

    public void setAltC(String altC) {
        this.altC = altC;
    }

    public String getAltD() {
        return altD;
    }

    public void setAltD(String altD) {
        this.altD = altD;
    }

    public String getAltE() {
        return altE;
    }

    public void setAltE(String altE) {
        this.altE = altE;
    }
}
