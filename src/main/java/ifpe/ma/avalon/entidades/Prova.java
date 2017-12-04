/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifpe.ma.avalon.entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 *
 * @author alex.rilton.bezerra
 */
@Entity
@Table(name = "TB_PROVA")
public class Prova implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "ID_PROVA")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToMany
    @JoinTable(name = "TB_PROVA_TEM_QUESTAO", joinColumns = 
            {@JoinColumn(name = "ID_PROVA")}, inverseJoinColumns =
                    {@JoinColumn(name = "ID_QUESTAO")})
    private final List<Questao> questoes;
    
    public Prova() {
        this.questoes = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Questao> getQuestoes() {
        return questoes;
    }

    public boolean addQuestao(Questao questao) {
        if (!questoes.contains(questao))
            return questoes.add(questao);
        return false;
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
        if (!(object instanceof Prova)) {
            return false;
        }
        Prova other = (Prova) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ifpe.ma.avalon.entidades.Prova[ id=" + id + " ]";
    }

}
