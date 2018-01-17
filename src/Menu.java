import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.IOException;

public class Menu extends Fenetre{
	
	JButton play1 = new JButton("2 Joueurs");
	JButton play2 = new JButton("Jouer contre l'ordinateur");
	JButton regles = new JButton("Règles");
	JButton quitter = new JButton("Quitter");
	
	public Menu() throws IOException{
		
		play1.setActionCommand("j1");
		play1.addActionListener(this);
		
		play2.setActionCommand("j2");
		play2.addActionListener(this);
		
		regles.setActionCommand("regles");
		regles.addActionListener(this);
		
		quitter.addActionListener(new FermetureFenetre());
		
		
		getContentPane().add(play1);
		getContentPane().add(play2);
		getContentPane().add(regles);
		getContentPane().add(quitter);	
		
		//pour le placement des boutons
		getContentPane().setLayout(new FlowLayout());
		//centrer la fenetre
		this.setLocationRelativeTo(null);
		//la rendre visible
		setVisible(true);
		
	}
	
	public void actionPerformed(ActionEvent evt) {
		if (evt.getActionCommand().equals("j1")){
		
				
			}
		if (evt.getActionCommand().equals("j2")){
			
			
				
			}
	
		
		if(evt.getActionCommand().equals("regles")){
			FenetreRegle regles;
			try {
				regles = new FenetreRegle();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				
		}
				
	}

}
