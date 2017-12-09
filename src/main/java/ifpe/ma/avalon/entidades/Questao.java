/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifpe.ma.avalon.entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author alex.rilton.bezerra
 */
@Entity
@Table(name = "TB_QUESTAO")
public class Questao implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "ID_QUESTAO")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "TXT_ENUNCIADO", length = 1000, nullable = false)
    private String enunciado;

    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "questao")
    private final List<Alternativa> alternativas;

    public Questao() {
        this.alternativas = new ArrayList<>();
    }

    public List<Alternativa> getAlternativas() {
        return alternativas;
    }

    public void addAlternativa(Alternativa alternativa) {
        for (Alternativa alternativa1 : alternativas) {
            if (alternativa1.compareTo(alternativa) == 0) {
                return;
            }
        }

        alternativa.setQuestao(this);
        alternativas.add(alternativa);
    }

    public String getEnunciado() {
        return enunciado;
    }

    public void setEnunciado(String enunciado) {
        this.enunciado = enunciado;
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
        if (!(object instanceof Questao)) {
            return false;
        }
        Questao other = (Questao) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ifpe.ma.avalon.entidades.Questao[ id=" + id + " ]";
    }

}
