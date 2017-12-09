/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifpe.ma.avalon;

import ifpe.ma.avalon.entidades.Alternativa;
import ifpe.ma.avalon.entidades.Questao;
import ifpe.ma.avalon.servico.QuestaoServico;
import javax.ejb.embeddable.EJBContainer;
import javax.naming.NamingException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author alex.rilton.bezerra
 */
public class QuestaoTeste {
    private static EJBContainer eJBContainer;
    private QuestaoServico questaoServico;
    
    public QuestaoTeste() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        eJBContainer = EJBContainer.createEJBContainer();
    }
    
    @AfterClass
    public static void tearDownClass() {
        eJBContainer.close();
    }
    
    @Before
    public void setUp() throws NamingException{
        questaoServico = (QuestaoServico) eJBContainer.getContext().lookup("java:global/AvalonGit/QuestaoServico!ifpe.ma.avalon.servico.QuestaoServico");
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void criarQuestaoValida(){

        Questao questao = questaoServico.criarQuestao();
        assertNotNull(questao);
        questao.setEnunciado("Qual a capital da Austrália");
        Alternativa alternativa =  new Alternativa("Sidney", false); 
        Alternativa alternativa1 = new Alternativa("Cramberra", true);
        questao.addAlternativa(alternativa);
        questao.addAlternativa(alternativa1);
        questaoServico.persistir(questao);
        assertNotNull(questao.getId());
    }
}
