import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;


public class Fenetre extends JFrame implements ActionListener{
	
	protected static final int LARGEUR = 1000;
	protected static final int HAUTEUR = 800;
	JMenuBar menuBar = new JMenuBar();
	JMenu menu = new JMenu("Options");
	JMenuItem item1 = new JMenuItem("Menu");
	JMenuItem item2 = new JMenuItem("Quitter");
	//Constructeur de classe Fenetre, on fixe uniquement la taille
	public Fenetre() {
		this.menu.add(item1);
		this.menu.add(item2);
		this.item1.addActionListener(this);
		this.item2.addActionListener(this);
		item1.setActionCommand("menu");
		item2.addActionListener(new FermetureFenetre());
		this.menuBar.add(menu);
		this.setJMenuBar(menuBar);
		setTitle("jeu.Jeu d'échecs");
		setSize(LARGEUR,HAUTEUR);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand().equals("menu")){
			try {
				new Menu();
			} catch (IOException err) {
				// TODO Auto-generated catch block
				err.printStackTrace();
			}
			dispose();
		}
	}

}
