package services;

import entities.CD;
import entities.Emprunt;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;
import java.util.Date;


@Stateless
public class EmpruntService {
    @PersistenceContext
    private EntityManager em;

    public List<CD> getAvailableCDs() {
        return em.createQuery("SELECT cd FROM CD cd WHERE cd NOT IN (SELECT e.cd FROM Emprunt e)", CD.class).getResultList();
    }

    public List<Emprunt> getEmpruntsByUser(String utilisateur) {
        return em.createQuery("SELECT e FROM Emprunt e WHERE e.utilisateur = :utilisateur", Emprunt.class)
                .setParameter("utilisateur", utilisateur)
                .getResultList();
    }

    public void emprunterCD(CD cd, String utilisateur) {
        Emprunt emprunt = new Emprunt();
        emprunt.setCd(cd);
        emprunt.setUtilisateur(utilisateur);
        emprunt.setDateEmprunt(new Date());
        em.persist(emprunt);
    }

    public void retournerCD(Emprunt emprunt) {
        emprunt.setDateRetour(new Date());
        em.merge(emprunt);
    }
}
