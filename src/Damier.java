
import jeu.Jeu;
import piece.Piece;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Damier extends JPanel implements MouseListener{

	private static final int LARGEUR_DAMIER =8, HAUTEUR_DAMIER =8;
	private static final int COTECASE = 75;
	private Jeu jeu = new Jeu();
	private boolean[][] checkDeplacement = new boolean[8][8];

	
	public Damier() {
		setOpaque(false);
		setLayout(new BorderLayout());
		this.addMouseListener(this);
	}

	public void paintComponent(Graphics g){
		//super.paintComponent(g);
		Color c = Color.white;

		for(int i = 0; i< LARGEUR_DAMIER; i++){
			for(int j = 0; j< HAUTEUR_DAMIER; j++){

				g.setColor(c);

				g.fillRect(50+(i)*COTECASE, 50+(j)*COTECASE, COTECASE, COTECASE);
				g.setColor(Color.black);

                //methode pour inserer image
				if(jeu.getPiece(i,j)!=null){
                    Piece piece = jeu.getPiece(i,j);
                    piece.paintComponent(g);
                }

				if(checkDeplacement[i][j]) {
					g.drawString("----", (i+1)*COTECASE-10,(j+1)*COTECASE-5);
				}

				if(c==Color.white) c=Color.gray;
				else c=Color.white;
				
			}
			if(c==Color.white) c=Color.gray;
			else c=Color.white;
		}
	}
	
	public void choixCase(int x, int y) {


		   checkDeplacement = jeu.getPiece(x,y).checkCase(jeu.getPiece(x,y),checkDeplacement);

	}
	
	
	
	@Override
	public void mouseClicked(MouseEvent e) {

		if(e.getButton()==1){

			int x = (e.getX()-50)/COTECASE;
			int y = (e.getY()-50)/COTECASE;

			Piece piece = jeu.getPiece(x,y);
			System.out.println(piece.getNom());
			System.out.println(x+" "+y);
			choixCase(x,y);
			
			
			//Pion p1 = new Pion(x, y, "B");
			
			repaint();
		}

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
