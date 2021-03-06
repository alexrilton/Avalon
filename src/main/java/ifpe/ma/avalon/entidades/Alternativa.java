/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifpe.ma.avalon.entidades;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author alex.rilton.bezerra
 */
@Entity
@Table(name = "TB_ALTERNATIVA")
public class Alternativa implements Serializable, Comparable<Alternativa> {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "TXT_VALOR", length = 1000, nullable = false)
    private String valor;
    
    @Column(name = "BOL_CORRETA", length = 1000, nullable = false)
    private boolean correta;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_QUESTAO" , referencedColumnName = "ID_QUESTAO", nullable = false)
    private Questao questao;

    public Alternativa() {
    }
    
    public Alternativa(String valor, boolean correta) {
        this.setValor(valor);
        this.setCorreta(correta);
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public boolean getCorreta() {
        return correta;
    }

    public void setCorreta(boolean correta) {
        this.correta = correta;
    }

    public Questao getQuestao() {
        return questao;
    }

    public void setQuestao(Questao questao) {
        this.questao = questao;
    }
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Alternativa)) {
            return false;
        }
        Alternativa other = (Alternativa) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ifpe.ma.avalon.entidades.Alternativa[ id=" + id + " ]";
    }

    @Override
    public int compareTo(Alternativa outra) {
        if (outra == null)
            throw new IllegalArgumentException();
        return this.getValor().compareTo(outra.getValor());
    }
    
}
