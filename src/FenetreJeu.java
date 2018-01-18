import damier.Damier;

import javax.swing.*;
import java.io.IOException;

class FenetreJeu extends Fenetre{

		private Damier d = new Damier();
		private JPanel container = new JPanel();
		
		public FenetreJeu() throws IOException{
			container.add(d);
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
