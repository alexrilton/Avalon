/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.avalon.controller;

import com.avalon.model.Questao;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.Query;

/**
 *
 * @author Ramon Vicente
 */
@Stateless
@LocalBean 
@TransactionManagement(TransactionManagementType.CONTAINER)
public class QuestaoService {
    
    @PersistenceContext(name = "avalon", type = PersistenceContextType.TRANSACTION)
    private EntityManager entityManager;
    
    @TransactionAttribute(TransactionAttributeType.SUPPORTS)
    public Questao criar() {
        return new Questao();
    }
    
    @TransactionAttribute(TransactionAttributeType.SUPPORTS)
    public List<Questao> listarQuestoes(){
        
        Query query = entityManager.createNamedQuery("Questao.listarQuestoes");
        return query.getResultList();
    }
    
}
