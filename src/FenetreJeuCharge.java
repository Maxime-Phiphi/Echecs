import damier.Damier;
import jeu.Jeu;

import javax.swing.*;
import java.io.IOException;

class FenetreJeuCharge extends Fenetre{

	String s = (String)JOptionPane.showInputDialog(
            this,
            "Nom du fichier :",
            "Nom du fichier",
            JOptionPane.PLAIN_MESSAGE);
		private Jeu j = new Jeu(s);
		private JPanel container = new JPanel();
		
		public FenetreJeuCharge() throws IOException{
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
