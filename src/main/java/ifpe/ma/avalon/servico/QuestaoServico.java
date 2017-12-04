/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifpe.ma.avalon.servico;

import ifpe.ma.avalon.entidades.Questao;
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
public class QuestaoServico {
    @PersistenceContext(name = "avalon", type = PersistenceContextType.TRANSACTION)
    private EntityManager entityManager;
    
    public void persistir(Questao questao) {
        entityManager.persist(questao);
    }
    
    public Questao criarQuestao() {
        return new Questao();
    }
}
