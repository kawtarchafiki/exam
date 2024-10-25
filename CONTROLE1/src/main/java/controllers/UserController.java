package controllers;


import entities.CD;
import services.EmpruntService;
import jakarta.ejb.EJB;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@ViewScoped
public class UserController implements Serializable {
    private String utilisateur;

    @EJB
    private EmpruntService empruntService;

    public List<CD> getAvailableCDs() {
        return empruntService.getAvailableCDs();
    }

    public void emprunterCD(CD cd) {
        empruntService.emprunterCD(cd, utilisateur);
    }

    // Getters and Setters
    public String getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(String utilisateur) {
        this.utilisateur = utilisateur;
    }
}
