package damier;
import piece.Piece;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Damier {

	public static final int TAILLE =8;
	private boolean[][] checkDeplacement = new boolean[8][8];
	private ArrayList<Case> ListCase = new ArrayList<>();

	
	public Damier() {

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
    public Case getCaseAt (int x, int y){
        for (Case c: ListCase) {
            if (c.getY()==y && c.getX()==x){
                return c;
            }
        }
        return null;
    }

    public void setCasesOccupees(ArrayList<Piece> listPiece) {
        for (Case c : ListCase) {
            for (Piece p : listPiece) {
               if (c.getX() == p.getX() && c.getY() == p.getY()){
                   c.setOccupe(true);
                   break;
               }
               else {
                   c.setOccupe(false);
               }
            }
        }
    }

	public void paintComponent(Graphics g){
        for (Case c : ListCase){
            c.paintComponent(g);
        }
	}

	public String getCouleurPieceAt (int x, int y, List<Piece> listPiece){
        for (Piece p : listPiece) {
            if (p.getX() == x && p.getY()==y ) {
                return p.getCouleur();
            }
        }
        return null;
    }



}
