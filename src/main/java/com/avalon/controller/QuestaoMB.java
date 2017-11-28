/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.avalon.controller;

import com.avalon.model.Questao;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;



/**
 *
 * @author Ramon Vicente
 */
@ManagedBean(name = "questaoMB")
@RequestScoped
public class QuestaoMB {
    
    private Questao questao;
    
    @EJB
    private QuestaoService questaoService;
    
    @PostConstruct
    public void iniciar() {
       questao = questaoService.criar(); 
    }
    
    public List<Questao> listarQuestoes(){
        
        return this.questaoService.listarQuestoes();
        
    }
    
}
