package org.ltpo.DAO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.ltpo.models.Modelo;
import org.ltpo.models.Usuarios;

import java.util.List;

public class UsuariosDAO {
    private EntityManagerFactory emf;
    private EntityManager em;

    public UsuariosDAO (){
        emf = Persistence.createEntityManagerFactory("usuariosPU");
        em = emf.createEntityManager();
    }

    public void salvar(Usuarios usuarios) {
        try {
            em.getTransaction().begin();
            em.persist(usuarios);
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
        }
    }

    public List<Usuarios> buscarTodos(){
        return em.createQuery("SELECT u FROM Usuarios u", Usuarios.class).getResultList();
    }

    public  Usuarios buscarPorId(int id){
        return em.find(Usuarios.class, id);
    }

    public void fechar(){
        em.close();
        emf.close();
    }
}