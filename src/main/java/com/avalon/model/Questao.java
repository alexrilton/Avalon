/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.avalon.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Ramon Vicente
 */
@Entity
@Table(name = "questao")
@NamedQuery(name = "Questao.listarQuestoes", query = "SELECT p FROM Questao p")
public class Questao implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long idQuestao;
    
    @Column(name = "descricao", columnDefinition = "TEXT")
    private String descricao;

    public Long getIdQuestao() {
        return idQuestao;
    }

    public void setIdQuestao(Long idQuestao) {
        this.idQuestao = idQuestao;
    }
    
    public String getQuestao() {
        return descricao;
    }

    public void setQuestao(String descricao) {
        this.descricao = descricao;
    }
    
}
