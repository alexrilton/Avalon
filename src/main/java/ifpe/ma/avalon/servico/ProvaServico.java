/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifpe.ma.avalon.servico;

import ifpe.ma.avalon.entidades.Prova;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

/**
 *
 * @author alex.rilton.bezerra
 */
@Stateless
@LocalBean
public class ProvaServico {
    @PersistenceContext(name = "avalon", type = PersistenceContextType.TRANSACTION)
    private EntityManager entityManager;
    
    public void persistir(Prova prova) {
        entityManager.persist(prova);
    }
    
    public Prova criarQuestao() {
        return new Prova();
    }
}
