package damier;

import jeu.Jeu;
import piece.Piece;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class Damier extends JPanel implements MouseListener{

	private static final int TAILLE =8;
	private Jeu jeu = new Jeu();
	private boolean[][] checkDeplacement = new boolean[8][8];
	private ArrayList<Case> ListCase = new ArrayList<>();

	
	public Damier() {
		setOpaque(false);
		setLayout(new BorderLayout());
		this.addMouseListener(this);
		initDamier();
	}

	public void initDamier () {
	    boolean isblanc = true;
	    for (int i = 0; i< TAILLE; i++){
	        for (int j=0; j< TAILLE; j++) {
                if (isblanc){
                    Case c = new CaseBlanche(i,j);
                    ListCase.add(c);
                    if (j != TAILLE-1)
                    isblanc=false;
                }
                else {
                    Case c = new CaseNoire(i,j);
                    ListCase.add(c);
                    if (j != TAILLE-1)
                        isblanc=true;
                }
            }
        }
    }


	public void paintComponent(Graphics g){
        for (Case c : ListCase){
            c.paintComponent(g);
        }
        for (Piece p : jeu.getListPiece()) {
            p.paintComponent(g);
        }

	}
	
	public void choixCase(int x, int y) {


//		   checkDeplacement = jeu.getPiece(x,y).checkCase(jeu.getPiece(x,y),checkDeplacement);

	}
	
	
	
	@Override
	public void mouseClicked(MouseEvent e) {

		if(e.getButton()==1){

//			int x = (e.getX()-50)/COTECASE;
//			int y = (e.getY()-50)/COTECASE;
//
//			Piece piece = jeu.getPiece(x,y);
//			System.out.println(piece.getNom());
//			System.out.println(x+" "+y);
//			choixCase(x,y);
			
			
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
