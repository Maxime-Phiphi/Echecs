import damier.Damier;
import jeu.Jeu;

import javax.swing.*;
import java.io.IOException;

class FenetreJeuIA extends Fenetre{

		private Jeu j = new Jeu("IA");
		private JPanel container = new JPanel();
		
		public FenetreJeuIA() throws IOException{
			container.add(j);
			container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
			
			super.setContentPane(container);
			//la fenetre est centree
			this.setLocationRelativeTo(null);
			//on ne peut pas modifier la taille de la fenetre
			setResizable(false);
			//la rendre visible
			setVisible(true);
		}
}