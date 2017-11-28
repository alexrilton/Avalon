package com.avalon.model;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author RamonVicente
 */
@Entity
@Table(name = "provas")
@NamedQueries({
    @NamedQuery(name = "Prova.todasQuestoes", query = "SELECT p FROM Prova p")
})
public class Prova implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long idProva;
    
    @Column(name="questao")
    private String questao;

    public Long getIdProva() {
        return idProva;
    }

    public void setIdProva(Long idProva) {
        this.idProva = idProva;
    }

    public String getQuestao() {
        return questao;
    }

    public void setQuestao(String questao) {
        this.questao = questao;
        
    }
    
    
    
}
