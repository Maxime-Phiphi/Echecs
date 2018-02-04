import damier.Damier;
import jeu.Jeu;
import jeu.JeuControleur;

import javax.swing.*;
import java.io.IOException;

class FenetreJeu extends Fenetre{

		private JeuControleur j = new JeuControleur(new Jeu());
		private JPanel container = new JPanel();
		private MenuBar menu = new MenuBar();
		
		public FenetreJeu() throws IOException{
			menu.setJeuControleur(j);
			container.add(j);
			container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
			super.setJMenuBar(menu);
			super.setContentPane(container);
			//la fenetre est centree
			this.setLocationRelativeTo(null);
			//on ne peut pas modifier la taille de la fenetre
			setResizable(false);
			//la rendre visible
			setVisible(true);
		}
}
