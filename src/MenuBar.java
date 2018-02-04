import jeu.Jeu;
import jeu.JeuControleur;

import javax.swing.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileFilter;


public class MenuBar extends JMenuBar implements ActionListener{
    private JMenu menuFichier = new JMenu("Fichier");
    private JMenuItem menuEnregistrer = new JMenuItem("Enregistrer");
    private JMenuItem menuOuvrir = new JMenuItem("Ouvrir");

    private JeuControleur jeuControleur;

    public MenuBar() {
        this.add(menuFichier);
        menuFichier.add(menuEnregistrer);
        menuFichier.add(menuOuvrir);

        menuEnregistrer.addActionListener(this);
        menuOuvrir.addActionListener(this);
    }

    public JeuControleur getJeuControleur() {
        return jeuControleur;
    }

    public void setJeuControleur(JeuControleur jeuControleur) {
        this.jeuControleur = jeuControleur;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("hello");
        if (e.getSource() == menuEnregistrer)
            serialize();
        if (e.getSource() == menuOuvrir)
            deserialize();

        repaint();
    }

    public void serialize()
    {
        Jeu jeu = jeuControleur.getJeu();
        File file = getSaveLocation();
        jeu.serialize(file);
    }

    public void deserialize()
    {
        File file = getOpenLocation();
        jeuControleur.deserialize(file);
    }

    private File getSaveLocation() {
        JFileChooser chooser = new JFileChooser();
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int result = chooser.showSaveDialog(this);

        if (result == chooser.APPROVE_OPTION) {
            return chooser.getSelectedFile();
        } else {
            return null;
        }
    }

    private File getOpenLocation() {
        JFileChooser chooser = new JFileChooser();
        chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        int result = chooser.showOpenDialog(this);

        if (result == chooser.APPROVE_OPTION) {
            return chooser.getSelectedFile();
        } else {
            return null;
        }
    }
}
