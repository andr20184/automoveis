package org.ltpo.DAO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.ltpo.models.Automoveis;


import java.util.List;

public class AutomoveisDAO {
    private EntityManagerFactory emf;
    private EntityManager em;

    public AutomoveisDAO(){
        emf = Persistence.createEntityManagerFactory("automoveisPU");
        em = emf.createEntityManager();
    }

    public void salvar(Automoveis automoveis) {
        try {

            em.getTransaction().begin();
            em.persist(automoveis);
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
        }
    }

    public List<Automoveis> buscarTodos(){
        return em.createQuery("SELECT a FROM Automoveis a", Automoveis.class).getResultList();
    }

    public  Automoveis buscarPorId(int id){
        return em.find(Automoveis.class, id);
    }

    public void fechar(){
        em.close();
        emf.close();
    }
}
