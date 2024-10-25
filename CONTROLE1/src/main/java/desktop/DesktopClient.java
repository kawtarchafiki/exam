package desktop;

import services.AdminService;
import jakarta.ejb.EJB;
import javax.swing.*;

public class DesktopClient {
    @EJB
    private static AdminService adminService;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Admin - Gestion des CDs");
        frame.setSize(500, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Components for managing CDs
        JButton addButton = new JButton("Ajouter CD");
        JButton editButton = new JButton("Modifier CD");
        JButton deleteButton = new JButton("Supprimer CD");

        frame.getContentPane().add(addButton);
        frame.getContentPane().add(editButton);
        frame.getContentPane().add(deleteButton);

        frame.setVisible(true);
    }
}
