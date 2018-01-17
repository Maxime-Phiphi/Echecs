
import jeu.Grille;
import jeu.Jeu;
import piece.Piece;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Damier extends JPanel implements MouseListener{
	
	//private char[][] grille = new char[10][10];
	private int largeurDamier=8, hauteurDamier=8;
	private int COTECASE = 75;
	//private String[][] pieces = new String[10][10];
	private Grille gr = new Grille();
	private Jeu jeu = new Jeu(gr);

	private BufferedImage im = null;

	private boolean[][] checkDeplacement = new boolean[8][8];
//	int impossible = 0;

	
	public Damier() throws IOException{
		//initTableau();
		setOpaque(false);
		//pour le placement du damier
		setLayout(new BorderLayout());
		this.addMouseListener(this);
	}

	public void paintComponent(Graphics g){
		super.paintComponent(g);
		Color c = Color.white;

		for(int i = 0; i<largeurDamier; i++){
			for(int j = 0; j<hauteurDamier; j++){

				g.setColor(c);

				g.fillRect(50+(i)*COTECASE, 50+(j)*COTECASE, COTECASE, COTECASE);
				g.setColor(Color.black);
				//g.drawRect(50+(i-1)*COTECASE, 50+(j-1)*COTECASE, COTECASE, COTECASE);

                //methode pour inserer image
                jeu.Initialiser();
				if(jeu.getPiece(i,j)!=null){
                    Piece piece = jeu.getPiece(i,j);
                    piece.paintComponent(g);
                }

//				g.drawImage(im, (i+1)*COTECASE-10,(j+1)*COTECASE-5, null);
				//g.drawString(gr.getTabGrille()[i][j],(i+1)*COTECASE+10,(j+1)*COTECASE+20);
				
				
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
