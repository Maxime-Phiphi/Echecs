import damier.Damier;
import jeu.Jeu;
import jeu.JeuIA;
import javax.swing.*;
import java.io.IOException;

class FenetreJeuIA extends Fenetre{

		private JeuIA j = new JeuIA();
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