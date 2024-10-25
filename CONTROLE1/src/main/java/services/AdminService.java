package services;



import java.util.List;


import entities.CD;
import entities.Emprunt;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Stateless
public class AdminService {
    @PersistenceContext
    private EntityManager em;

    public void ajouterCD(CD cd) {
        em.persist(cd);
    }

    public void modifierCD(CD cd) {
        em.merge(cd);
    }

    public void supprimerCD(Long id) {
        CD cd = em.find(CD.class, id);
        if (cd != null) {
            em.remove(cd);
        }
    }

    public List<Emprunt> getEmpruntsEnCours() {
        return em.createQuery("SELECT e FROM Emprunt e WHERE e.dateRetour IS NULL", Emprunt.class).getResultList();
    }
}
